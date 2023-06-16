package utils;

import java.util.Optional;

public class SafeQueueCoarseGrained<E> implements Queue<E> {

  private final Node<E> head;
  private final Node<E> tail;
  private int size;

  public SafeQueueCoarseGrained() {
    head = new Node<>();
    tail = new Node<>();
    head.setNext(tail);
    size = 0;
  }

  @Override
  public synchronized void push(E element) {
    //TODO for Question 1
    Node<E> prev = head;
    Node<E> curr = head.getNext();
    while (curr != tail) {
      prev = curr;
      curr = curr.getNext();
    }
    Node<E> node = new Node<>(element);
    prev.setNext(node);
    node.setNext(curr);
    size++;
  }

  @Override
  public synchronized Optional<E> pop() {
    //TODO for Question 1
    Node<E> curr = head.getNext();
    if (curr == tail) {
      return Optional.empty();
    } else {
      head.setNext(curr.getNext());
      size--;
      return Optional.of(curr.getElement());
    }
  }

  @Override
  public synchronized int size() {
    //TODO for Question 1
    return size;
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
