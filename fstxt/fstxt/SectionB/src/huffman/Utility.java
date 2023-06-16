package huffman;

import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utility {

  public static List<String> getWords(String filePath) {
    List<String> words = null;
    try (Stream<String> linesStream = Files.lines(Paths.get(filePath))) {
      words = linesStream.flatMap(line -> Arrays.stream(line.split(" "))).map(word -> word.trim())
          .collect(Collectors.toList());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return words;
  }

  public static String sequenceOfBitsAsNumber(String binaryEncoding) {
    final String binaryEncodingWithHeading1 =
        "1" + binaryEncoding; // Prepending 1 not to lose heading zeroes
    BigInteger result = new BigInteger(binaryEncodingWithHeading1, 2);
    return result.toString();
  }

  public static String numberAsSequenceOfBits(String numberRepresentation) {
    BigInteger number = new BigInteger(numberRepresentation);
    String binaryRepresentation = number.toString(2);
    return binaryRepresentation.substring(1); // Removing previously prepended 1
  }

  public static long totalLength(List<String> words) {
    long length = words.size() - 1; // White spaces
    length += words.stream().mapToLong(w -> w.length()).sum();
    return length;
  }

  public static Map<String, Integer> countWords(List<String> words) {
    //TODO replace the current sequenctial implementation with a concurrent one (Q4)
//    return words.stream().collect(Collectors.toMap(w -> w, w -> 1, Integer::sum));
    if (words.size() < 0) {
      throw new IllegalArgumentException();
    }

    final int NUM_THREADS = 3;
    AtomicInteger position = new AtomicInteger(0);
    ConcurrentMap<String, Integer> result = new ConcurrentHashMap<>();
    Thread[] threads = new Thread[NUM_THREADS];
    Arrays.setAll(threads, t -> new Thread(new wordCounter(words, result, position)));
    Arrays.stream(threads).forEach(Thread::start);
    Arrays.stream(threads).forEach(t -> {
      try {
        t.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    return result;
  }

  private static class wordCounter implements Runnable {

    private final List<String> words;
    private final ConcurrentMap<String, Integer> wordCount;
    private final AtomicInteger position;

    public wordCounter(List<String> words, ConcurrentMap<String, Integer> wordCount, AtomicInteger position) {
      this.words = words;
      this.wordCount = wordCount;
      this.position = position;
    }

    @Override
    public void run() {
      int pos = position.getAndIncrement();
      while (pos < words.size()) {
        wordCount.merge(words.get(pos), 1, Integer::sum);
        pos = position.getAndIncrement();
      }
    }
  }
}
