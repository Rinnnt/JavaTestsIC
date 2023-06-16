package datastructures;

import domain.Player;
import java.util.Optional;

public interface Stock<ExchangeableGood> {

  void push(ExchangeableGood element, Player player);

  Optional<ExchangeableGood> pop();

  int size();
}
