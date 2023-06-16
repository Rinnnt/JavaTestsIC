package utils;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

// Optimised fine grain but gets null pointer exception everytime???
// passes test.
// idk why
public class SafeQueue<E> implements Queue<E> {

  private final Node<E> head;
  private final Node<E> tail;
  private AtomicInteger size;

  public SafeQueue() {
    head = new Node<>();
    tail = new Node<>();
    head.setNext(tail);
    tail.setPrev(head);
    size = new AtomicInteger(0);
  }

  @Override
  public void push(E element) {
    //TODO for Question 1
    Node<E> prev = null;
    try {
      boolean locked = false;
      while (!locked) {
        prev = tail.getPrev();
        prev.lock();
        tail.lock();

        if (prev.getNext() == tail && tail.getPrev() != prev) {
          locked = true;
        }
      }
      Node<E> node = new Node<>(element);
      prev.setNext(node);
      node.setPrev(prev);
      node.setNext(tail);
      tail.setPrev(node);
      size.getAndIncrement();
    } finally {
      prev.unlock();
      tail.unlock();
    }
  }

  @Override
  public Optional<E> pop() {
    //TODO for Question 1
    Node<E> prev = null;
    Node<E> curr = null;
    try {
      boolean locked = false;
      while (!locked) {
        if (size() == 0) {
          return Optional.empty();
        }
        head.lock();
        prev = head.getNext();
        prev.lock();
        curr = prev.getNext();
        curr.lock();

        if (head.getNext() == prev && prev.getNext() == curr && curr.getPrev() == prev && prev.getPrev() == head) {
          locked = true;
        }
      }
      if (prev == tail) {
        return Optional.empty();
      } else {
        head.setNext(curr);
        curr.setPrev(head);
        size.getAndDecrement();
        return Optional.of(prev.getElement());
      }
    } finally {
      head.unlock();
      prev.unlock();
      if (curr != null) {
        curr.unlock();
      }
    }
  }

  @Override
  public int size() {
    //TODO for Question 1
    return size.get();
  }
}
