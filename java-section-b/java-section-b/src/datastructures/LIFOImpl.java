package datastructures;

import java.util.Optional;
import java.util.Stack;

public class LIFOImpl<E> implements LIFO<E> {

  private Stack<E> stack;

  public LIFOImpl() {
    stack = new Stack<>();
  }

  @Override
  public void push(E item) {
    stack.push(item);
  }

  @Override
  public Optional<E> pop() {
    // TODO: Q1
    return (stack.isEmpty()) ? Optional.empty() : Optional.of(stack.pop());
  }

  @Override
  public int size() {
    // TODO: Q1
    return stack.size();
  }
}
