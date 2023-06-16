package utils;

import java.util.concurrent.locks.ReentrantLock;

public class Node<E> {

  private E element;
  private Node<E> next;
  private Node<E> prev;
  private final ReentrantLock lock;

  public Node() {
    this(null);
  }

  public Node(E element) {
    this.element = element;
    next = null;
    prev = null;
    lock = new ReentrantLock();
  }

  public ReentrantLock getLock() {
    return lock;
  }

  public void lock() {
    lock.lock();
  }

  public void unlock() {
    lock.unlock();
  }

  public E getElement() {
    return element;
  }

  public void setElement(E element) {
    this.element = element;
  }

  public Node<E> getNext() {
    return next;
  }

  public void setNext(Node<E> next) {
    this.next = next;
  }

  public Node<E> getPrev() {
    return next;
  }

  public void setPrev(Node<E> prev) {
    this.prev = prev;
  }
}
