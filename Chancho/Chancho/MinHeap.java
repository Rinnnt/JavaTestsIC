/**
 * This class implements a min-heap abstract data type (as described by the
 * generic interface IMinHeap<T extends Comparable<T>>) using a fixed array of
 * size MinHeap.MAXIMUM_HEAP_SIZE.
 */
public class MinHeap<T extends Comparable<T>> implements IMinHeap<T> {

  private static final int MAXIMUM_HEAP_SIZE = 52;
  private final T[] array;
  private int size;

  public MinHeap() {
    array = (T[]) new Comparable[MAXIMUM_HEAP_SIZE];
    size = 0;
  }

  @Override
  public void add(T element) throws HeapException {
    if (size >= MAXIMUM_HEAP_SIZE) {
      throw new HeapException("Heap is Full");
    }
    array[size] = element;
    size++;
    percolateUp(size-1);
  }

  private void percolateUp(int index) {
    if (index != 0) {
      int parent = (index - 1) / 2;
      if ((array[parent]).compareTo(array[index]) > 0) {
        T temp = array[parent];
        array[parent] = array[index];
        array[index] = temp;
        percolateUp(parent);
      }
    }
  }

  @Override
  public T removeMin() {
    if (!isEmpty()) {
      T min = array[0];
      array[0] = array[size - 1];
      size--;
      rebuild(0);
      return min;
    }
    else {
      return null;
    }
  }

  private void rebuild(int index) {
    int leftChild = 2 *index + 1;
    if (leftChild < size) {
      int minChild = leftChild;
      int rightChild = leftChild + 1;
      if (rightChild < size && array[rightChild].compareTo(array[leftChild]) < 0) {
        minChild = rightChild;
      }
      T temp = array[index];
      array[index] = array[minChild];
      array[minChild] = temp;
      rebuild(minChild);
    }
  }

  @Override
  public T getMin() {
    return array[0];
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size(); i++) {
      sb.append(array[i]);
    }
    return sb.toString();
  }
}