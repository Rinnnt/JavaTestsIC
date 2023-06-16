package alphatree;

public class AlphaTreeQueue {

  public static final int MAX_LENGTH = 26;

  private final QueueNode head;
  private final QueueNode tail;
  private int size;

  public AlphaTreeQueue() {
    // TODO: Question 3
    head = new QueueNode(new AlphaTree());
    tail = new QueueNode(new AlphaTree('!', Integer.MAX_VALUE));
    head.setNext(tail);
    size = 0;
  }

  public AlphaTreeQueue(AlphaFreq freqs) {
    // TODO: Question 3
    this();
    if (freqs != null) {
      addAll(freqs);
    }
  }

  private Position find(int freq) {
    QueueNode prev = head;
    QueueNode curr = head.getNext();
    while (curr.getFreq() <= freq) {
      prev = curr;
      curr = curr.getNext();
    }
    return new Position(prev, curr);
  }

  public void addAll(AlphaFreq freqs) {
    // TODO: Question 3
    for (int i = 0; i < 26; i++) {
      char c = (char) ('a' + i);
      add(new AlphaTree(c, freqs.get(c)));
    }
  }

  public void add(AlphaTree t) {
    // TODO: Question 3
    if (t != null && !t.isEmpty()) {
      Position pos = find(t.freq());
      QueueNode prev = pos.prev;
      QueueNode curr = pos.curr;
      QueueNode node = new QueueNode(t);
      prev.setNext(node);
      node.setNext(curr);
      size++;
    }
  }

  public AlphaTree peek() {
    // TODO: Question 3
    if (size > 0) {
      QueueNode prev = head;
      QueueNode curr = head.getNext();
      return curr.getTree();
    }
    return null;
  }

  public AlphaTree poll() {
    // TODO: Question 3
    if (size > 0) {
      QueueNode prev = head;
      QueueNode curr = head.getNext();
      prev.setNext(curr.getNext());
      size--;
      return curr.getTree();
    }
    return null;
  }

  public int size() {
    // TODO: Question 3
    return size;
  }

  private static class Position {
    private QueueNode prev;
    private QueueNode curr;

    public Position(QueueNode prev, QueueNode curr) {
      this.prev = prev;
      this.curr = curr;
    }
  }
}
