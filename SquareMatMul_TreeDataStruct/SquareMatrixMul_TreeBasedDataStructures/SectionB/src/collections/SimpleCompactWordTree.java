package collections;

import collections.exceptions.InvalidWordException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleCompactWordTree implements CompactWordsSet {

  private final Node root;
  private final AtomicInteger size;

  public SimpleCompactWordTree() {
    root = new Node('\00', false);
    size = new AtomicInteger(0);
  }

  private Position<Node> find(String word) {
    Node prev = null;
    Node curr = root;
    curr.lock();
    int cnt = 0;
    while (cnt < word.length()) {
      if (curr.getChild(word.charAt(cnt)) != null) {
        curr.getChild(word.charAt(cnt)).lock();
        if (prev != null) {
          prev.unlock();
        }
        prev = curr;
        curr = curr.getChild(word.charAt(cnt));
        cnt++;
      } else {
        break;
      }
    }
    return new Position<>(prev, curr, cnt);
  }

  @Override
  public boolean add(String word) throws InvalidWordException {
    CompactWordsSet.checkIfWordIsValid(word);
    // TO BE IMPLEMENTED
    Node prev = null;
    Node curr = null;
    try {
      Position<Node> pos = find(word);
      prev = pos.prev;
      curr = pos.curr;
      if (pos.cnt == word.length() && curr.isWord()) {
        return false;
      } else {
        for (int i = pos.cnt; i < word.length(); i++) {
          char c = word.charAt(i);
          Node node = new Node(c, false);
          node.lock();
          if (prev != null) {
            prev.unlock();
          }
          curr.setChild(c, node);
          prev = curr;
          curr = curr.getChild(c);
        }
        size.getAndIncrement();
        curr.setWord(true);
        return true;
      }
    } finally {
      if (prev != null) {
        prev.unlock();
      }
      curr.unlock();
    }
  }

  @Override
  public boolean remove(String word) throws InvalidWordException {
    CompactWordsSet.checkIfWordIsValid(word);
    // TO BE IMPLEMENTED
    Node prev = null;
    Node curr = null;
    try {
      Position<Node> pos = find(word);
      prev = pos.prev;
      curr = pos.curr;
      if (pos.cnt == word.length() && curr.isWord()) {
        size.getAndDecrement();
        curr.setWord(false);
        return true;
      }
      return false;
    } finally {
      if (prev != null) {
        prev.unlock();
      }
      curr.unlock();
    }
  }

  @Override
  public boolean contains(String word) throws InvalidWordException {
    CompactWordsSet.checkIfWordIsValid(word);
    // TO BE IMPLEMENTED
    Node prev = null;
    Node curr = null;
    try {
      Position<Node> pos = find(word);
      prev = pos.prev;
      curr = pos.curr;
      return pos.cnt == word.length() && curr.isWord();
    } finally {
      if (prev != null) {
        prev.unlock();
      }
      curr.unlock();
    }
  }

  @Override
  public int size() {
    // TO BE IMPLEMENTED
    return size.get();
  }

  @Override
  public List<String> uniqueWordsInAlphabeticOrder() {
    List<String> words = new ArrayList<>();
    traverse(root, "", words);
    return words;
  }

  private void traverse(Node cur, String word, List<String> words) {
    if (cur == null) {
      return;
    }

    if (cur != root) {
      word = word + cur.getChar();
      if (cur.isWord()) {
        words.add(word);
      }
    }
    for (char c = 'a'; c <= 'z'; c++) {
      traverse(cur.getChild(c), word, words);
    }
  }

  private static class Position<E> {
    private E prev;
    private E curr;
    private int cnt;

    public Position(E prev, E curr, int cnt) {
      this.prev = prev;
      this.curr = curr;
      this.cnt = cnt;
    }
  }
}
