package utils;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class UnsafeQueue<E> implements Queue<E> {

  private final Node<E> head;
  private final Node<E> tail;
  private int size;

  public UnsafeQueue() {
    head = new Node<>();
    tail = new Node<>();
    size = 0;
  }

  @Override
  public void push(E element) {
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
  public Optional<E> pop() {
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
  public int size() {
    //TODO for Question 1
    return size;
  }
}
