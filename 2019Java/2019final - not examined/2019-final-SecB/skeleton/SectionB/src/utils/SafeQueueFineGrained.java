package utils;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class SafeQueueFineGrained<E> implements Queue<E> {

  private final Node<E> head;
  private final Node<E> tail;
  private AtomicInteger size;

  public SafeQueueFineGrained() {
    head = new Node<>();
    tail = new Node<>();
    head.setNext(tail);
    size = new AtomicInteger(0);
  }

  private Position<Node<E>> findFirst() {
    Node<E> prev = head;
    prev.lock();
    Node<E> curr = prev.getNext();
    curr.lock();
    return new Position<>(prev, curr);
  }

  private Position<Node<E>> findLast() {
    Node<E> prev = head;
    prev.lock();
    Node<E> curr = prev.getNext();
    curr.lock();
    while (curr != tail) {
      curr.getNext().lock();
      prev.unlock();
      prev = curr;
      curr = curr.getNext();
    }
    return new Position<>(prev, curr);
  }

  @Override
  public void push(E element) {
    //TODO for Question 1
    Node<E> prev = null;
    Node<E> curr = null;
    try {
      Position<Node<E>> pos = findLast();
      prev = pos.prev;
      curr = pos.curr;
      Node<E> node = new Node<>(element);
      prev.setNext(node);
      node.setNext(curr);
      size.getAndIncrement();
    } finally {
      prev.unlock();
      curr.unlock();
    }
  }

  @Override
  public Optional<E> pop() {
    //TODO for Question 1
    Node<E> prev = null;
    Node<E> curr = null;
    try {
      Position<Node<E>> pos = findFirst();
      prev = pos.prev;
      curr = pos.curr;
      if (curr == tail) {
        return Optional.empty();
      } else {
        head.setNext(curr.getNext());
        size.getAndDecrement();
        return Optional.of(curr.getElement());
      }
    } finally {
      prev.unlock();
      curr.unlock();
    }
  }

  @Override
  public int size() {
    //TODO for Question 1
    return size.get();
  }

  private static class Position<E> {
    private final E prev;
    private final E curr;

    public Position(E prev, E curr) {
      this.prev = prev;
      this.curr = curr;
    }
  }
}
