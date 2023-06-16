package alphatree;

import java.util.concurrent.locks.ReentrantLock;

public class QueueNode {

  private AlphaTree tree;
  private QueueNode next;
  private ReentrantLock lock;

  public QueueNode(AlphaTree tree) {
    this.tree = tree;
  }

  public void lock() {
    lock.lock();
  }

  public void unlock() {
    lock.unlock();
  }

  public AlphaTree getTree() {
    return tree;
  }

  public int getFreq() {
    return tree.freq();
  }

  public QueueNode getNext() {
    return next;
  }

  public void setNext(QueueNode next) {
    this.next = next;
  }

}
