package datastructures;

import java.util.Optional;

public interface LIFO<E> {

  void push(E item);

  Optional<E> pop();

  int size();
}
