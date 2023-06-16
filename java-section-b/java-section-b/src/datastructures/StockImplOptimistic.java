package datastructures;

import domain.Player;
import domain.producttypes.ExchangeableChemical;
import exchange.Exchange;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class StockImplOptimistic<E extends ExchangeableChemical> implements Stock<E> {

  // OPTIMISTIC LOCKING....??
  // DOESNT WORK RN
  // COARSE AND FINE DOES WORK
  Node<E> root;
  private AtomicInteger size;

  public StockImplOptimistic() {
    root = new Node<>(Integer.MIN_VALUE);
    size = new AtomicInteger(0);
  }

  private Position<Node<E>> find(int key) {
    Node<E> prev = null;
    Node<E> curr = root;
    while (curr.getKey() != key) {
      if (curr.getKey() > key && curr.getLeft() != null) {
        prev = curr;
        curr = curr.getLeft();
      } else if (curr.getKey() < key && curr.getRight() != null) {
        prev = curr;
        curr = curr.getRight();
      } else {
        break;
      }
    }
    return new Position<>(prev, curr);
  }

  private boolean valid(Node<E> prev,  Node<E> curr) {
    Node<E> cur = root;
    if (prev == null) {
      return curr == cur;
    } else {
      while (cur.getKey() != prev.getKey()) {
        if (cur.getKey() < prev.getKey() && cur.getRight() != null) {
          cur = cur.getRight();
        } else if (cur.getKey() > prev.getKey() && cur.getLeft() != null) {
          cur = cur.getLeft();
        } else {
          break;
        }
      }
      if (cur != prev) {
        return false;
      }
      if (curr.getKey() > prev.getKey()) {
        return cur.getRight() == curr;
      } else {
        return cur.getLeft() == curr;
      }
    }
  }


  @Override
  public void push(E element, Player player) {
    // TODO: Q2/Q4
    do {
      Position<Node<E>> position = find(player.id);
      Node<E> prev = position.prev;
      Node<E> curr = position.curr;
      try {
        if (valid(prev, curr)) {
          if (position.curr.getKey() == player.id) {
            position.curr.push(element);
          } else if (position.curr.getKey() < player.id) {
            position.curr.setRight(new Node<>(player.id));
            position.curr.getRight().push(element);
          } else {
            position.curr.setLeft(new Node<>(player.id));
            position.curr.getLeft().push(element);
          }
          size.getAndIncrement();
          return;
        }
      } finally {
        if (prev != null) {
          prev.unlock();
        }
        curr.unlock();
      }
    } while (true);
  }


  @Override
  public Optional<E> pop() {
    // TODO: Q2/Q4
    do {
      Position<Node<E>> position = find(Integer.MAX_VALUE);
      Node<E> prev = position.prev;
      Node<E> curr = position.curr;
      try {
        if (valid(prev, curr)) {
          if (position.curr == root) {
            return Optional.empty();
          } else {
            Optional<E> item = position.curr.pop();
            if (position.curr.size() == 0) {
              position.prev.setRight(position.curr.getLeft());
            }
            size.getAndDecrement();
            return item;
          }
        }
      } finally {
        if (prev != null) {
          prev.unlock();
        }
        curr.unlock();
      }
    } while (true);
  }

  @Override
  public int size() {
    // TODO: Q2/Q4
    return size.get();
  }

  private static class Position<E> {
    E prev;
    E curr;
    public Position(E prev, E curr) {
      this.prev = prev;
      this.curr = curr;
    }
  }
}
