import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListPriorityQueue<T> implements PriorityQueue<T> {

  Node<T> head;
  Node<T> tail;

  public LinkedListPriorityQueue() {
    head = new Node<>(Double.MIN_VALUE, null);
    tail = new Node<>(Double.MAX_VALUE, null);
    head.setNext(tail);
  }

  private Node<T> find(double priority) {
    Node<T> cur = head;
    while (cur.getNext().getPriority() < priority) {
      cur = cur.getNext();
    }
    return cur;
  }

  @Override
  public void add(double priority, T element) {
    Node<T> cur = find(priority);
    Node<T> added = new Node<>(priority, element);
    added.setNext(cur.getNext());
    cur.setNext(added);
  }

  @Override
  public T dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("Empty queue");
    }
    Node<T> temp = head.getNext();
    head.setNext(temp.getNext());
    return temp.getValue();
  }

  @Override
  public boolean isEmpty() {
    return head.getNext() != tail;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {

      private Node<T> cur = head;

      @Override
      public boolean hasNext() {
        return cur.getNext() != tail;
      }

      @Override
      public T next() {
        cur = cur.getNext();
        return cur.getValue();
      }
    };
  }
}
