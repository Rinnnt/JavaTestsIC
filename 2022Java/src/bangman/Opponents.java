package bangman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Opponents implements Iterable<Opponent> {
  Iterator<String> secrets;

  Opponents(List<String> words) {
    List<String> wordCopy = new ArrayList<>(words);
    Collections.shuffle(wordCopy);
    this.secrets = wordCopy.iterator();
  }

  @Override
  public Iterator<Opponent> iterator() {
    return new Iterator<Opponent>() {
      public Opponent next() {
        return new Opponent(Opponents.this.secrets.next());
      }

      public boolean hasNext() {
        return Opponents.this.secrets.hasNext();
      }
    };
  }
}
