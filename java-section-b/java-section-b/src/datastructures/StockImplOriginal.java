package datastructures;

import domain.Player;
import domain.producttypes.ExchangeableChemical;
import exchange.Exchange;
import java.util.Optional;

public class StockImplOriginal<E extends ExchangeableChemical> implements Stock<E> {

  Node<E> root;
  private int size;

  public StockImplOriginal() {
    root = new Node<>(Integer.MIN_VALUE);
    size = 0;
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


  @Override
  public void push(E element, Player player) {
    // TODO: Q2/Q4
    Position<Node<E>> position = find(player.id);
    if (position.curr.getKey() == player.id) {
      position.curr.push(element);
    } else if (position.curr.getKey() < player.id) {
      position.curr.setRight(new Node<>(player.id));
      position.curr.getRight().push(element);
    } else {
      position.curr.setLeft(new Node<>(player.id));
      position.curr.getLeft().push(element);
    }
    size++;
  }

  @Override
  public Optional<E> pop() {
    // TODO: Q2/Q4
    Position<Node<E>> position = find(Integer.MAX_VALUE);
    if (position.curr == root) {
      return Optional.empty();
    } else {
      Optional<E> item = position.curr.pop();
      if (position.curr.size() == 0) {
        position.prev.setRight(position.curr.getLeft());
      }
      size--;
      return item;
    }
  }

  @Override
  public int size() {
    // TODO: Q2/Q4
    return size;
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
