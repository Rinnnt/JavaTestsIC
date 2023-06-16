package collections;

import java.util.concurrent.locks.ReentrantLock;

public class Node {

  private final char character;
  private boolean isWord;
  private final Node[] children;
  private final ReentrantLock lock;

  public Node(char character, boolean isWord) {
    this.character = character;
    this.isWord = isWord;
    children = new Node[26];
    this.lock = new ReentrantLock();
  }

  public void lock() {
    lock.lock();
  }

  public void unlock() {
    lock.unlock();
  }

  public char getChar() {
    return character;
  }

  public boolean isWord() {
    return isWord;
  }

  public void setWord(boolean isWord) {
    this.isWord = isWord;
  }

  public Node getChild(char character) {
    return children[character - 'a'];
  }

  public void setChild(char character, Node node) {
    children[character - 'a'] = node;
  }

}
