package huffman;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class HuffmanEncoder {

  final HuffmanNode root;
  final Map<String, String> word2bitsequence;

  private HuffmanEncoder(HuffmanNode root,
      Map<String, String> word2bitSequence) {
    this.root = root;
    this.word2bitsequence = word2bitSequence;
  }

  public static HuffmanEncoder buildEncoder(Map<String, Integer> wordCounts) {
    //TODO: complete the implementation of this method (Q1)

    if (wordCounts == null) {
      throw new HuffmanEncoderException("wordCounts cannot be null");
    }
    if (wordCounts.size() < 2) {
      throw new HuffmanEncoderException("This encoder requires at least two different words");
    }

    // fixing the order in which words will be processed: this determinize the execution and makes
    // tests reproducible.
    TreeMap<String, Integer> sortedWords = new TreeMap<String,Integer>(wordCounts);
    PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(sortedWords.size());

    //YOUR IMPLEMENTATION HERE...
    HuffmanNode root;
    Map<String, String> word2bitSequence = new HashMap<>();

    for (String word : sortedWords.keySet()) {
      queue.offer(new HuffmanLeaf(sortedWords.get(word), word));
    }
    while (queue.size() > 1) {
      HuffmanNode leftNode = queue.poll();
      HuffmanNode rightNode = queue.poll();
      queue.offer(new HuffmanInternalNode(leftNode, rightNode));
    }

    root = queue.peek();

    Deque<HuffmanNode> stack = new ArrayDeque<>();
    Deque<String> bitStack = new ArrayDeque<>();
    stack.push(root);
    bitStack.push("");
    while (!stack.isEmpty()) {
      HuffmanNode node = stack.pop();
      String bits = bitStack.pop();
      if (node instanceof HuffmanInternalNode) {
        HuffmanInternalNode internalNode = (HuffmanInternalNode) node;
        stack.push(internalNode.left);
        stack.push(internalNode.right);
        bitStack.push(bits + "0");
        bitStack.push(bits + "1");
      } else {
        HuffmanLeaf leafNode = (HuffmanLeaf) node;
        word2bitSequence.put(leafNode.word, bits);
      }
    }

    return new HuffmanEncoder(root, word2bitSequence);
  }

  public String compress(List<String> text) {
    assert text != null && text.size() > 0;

    //TODO: implement this method (Q2)
    StringBuilder sb = new StringBuilder();
    for (String word : text) {
      if (!word2bitsequence.containsKey(word)) {
        throw new HuffmanEncoderException("Word is not recognized by the encoder");
      }
      sb.append(word2bitsequence.get(word));
    }

    return sb.toString();
  }


  public List<String> decompress(String compressedText) {
    assert compressedText != null && compressedText.length() > 0;

    //TODO: implement this method (Q3)
    HuffmanNode curNode = root;
    List<String> words = new ArrayList<>();
    for (int i = 0; i < compressedText.length(); i++) {
      assert curNode instanceof HuffmanInternalNode;
      if (compressedText.charAt(i) == '0') {
        curNode = ((HuffmanInternalNode) curNode).left;
      }
      else {
        curNode = ((HuffmanInternalNode) curNode).right;
      }

      if (curNode instanceof HuffmanLeaf leaf) {
        words.add(leaf.word);
        curNode = root;
      }
    }
    if (curNode != root) {
      throw new HuffmanEncoderException();
    }

    return words;
  }

  // Below the classes representing the tree's nodes. There should be no need to modify them, but
  // feel free to do it if you see it fit

  private static abstract class HuffmanNode implements Comparable<HuffmanNode> {

    private final int count;

    public HuffmanNode(int count) {
      this.count = count;
    }

    @Override
    public int compareTo(HuffmanNode otherNode) {
      return count - otherNode.count;
    }
  }


  private static class HuffmanLeaf extends HuffmanNode {

    private final String word;

    public HuffmanLeaf(int frequency, String word) {
      super(frequency);
      this.word = word;
    }
  }


  private static class HuffmanInternalNode extends HuffmanNode {

    private final HuffmanNode left;
    private final HuffmanNode right;

    public HuffmanInternalNode(HuffmanNode left, HuffmanNode right) {
      super(left.count + right.count);
      this.left = left;
      this.right = right;
    }
  }
}
