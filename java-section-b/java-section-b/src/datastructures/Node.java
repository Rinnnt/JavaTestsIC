package datastructures;

import domain.producttypes.ExchangeableChemical;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

public class Node<E extends ExchangeableChemical> {

  private final int key;
  private final LIFO<E> stack;
  private volatile Node<E> left;
  private volatile Node<E> right;
  private ReentrantLock lock;

  public Node(int key) {
    this.key = key;
    stack = new LIFOImpl<>();
    left = null;
    right = null;
    lock = new ReentrantLock();
  }

  public void lock() {
    lock.lock();
  }

  public void unlock() {
    lock.unlock();
  }

  public int getKey() {
    return key;
  }

  public Node<E> getLeft() {
    return left;
  }

  public void setLeft(Node<E> next) {
    this.left = next;
  }

  public Node<E> getRight() {
    return right;
  }

  public void setRight(Node<E> next) {
    this.right = next;
  }

  public void push(E item) {
    stack.push(item);
  }

  public Optional<E> pop() {
    return stack.pop();
  }

  public int size() {
    return stack.size();
  }
}
