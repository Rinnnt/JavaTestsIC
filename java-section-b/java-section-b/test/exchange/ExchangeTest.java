package exchange;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import chemicals.Carbon;
import chemicals.Hydrogen;
import domain.Player;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import players.CarbonSupplier;
import players.Chemist;
import players.HydrogenSupplier;
import players.MethaneMixer;
import testutils.MockPlayer;

public class ExchangeTest {

  private Exchange exchange;
  private Player player0, player1;
  private Carbon newCarbon1, newCarbon2, newCarbon3;
  private Hydrogen newHydrogen1, newHydrogen2, newHydrogen3;

  @Before
  public void setup() {
    exchange = new ExchangeImpl();

    newCarbon1 = new Carbon();
    newCarbon2 = new Carbon();
    newCarbon3 = new Carbon();

    newHydrogen1 = new Hydrogen();
    newHydrogen2 = new Hydrogen();
    newHydrogen3 = new Hydrogen();

    player0 = new MockPlayer(exchange);
    player1 = new MockPlayer(exchange);
  }

  @Test
  public void exchangeHasInitiallyNoGoods() {
    assertTrue(exchange.buyCarbon().isEmpty());
    assertTrue(exchange.buyHydrogen().isEmpty());
    assertTrue(exchange.buyMethane().isEmpty());
  }

  @Test
  public void productsDoNotGetLost() {
    exchangeHasInitiallyNoGoods();

    exchange.sellCarbon(newCarbon1, player0);
    exchange.sellCarbon(newCarbon2, player1);
    exchange.sellHydrogen(newHydrogen1, player0);

    Set<Carbon> boughtSet1 = new HashSet<>();

    Optional<Carbon> bought1 = exchange.buyCarbon();
    assertTrue(bought1.isPresent());
    boughtSet1.add(bought1.get());

    bought1 = exchange.buyCarbon();
    assertTrue(bought1.isPresent());
    boughtSet1.add(bought1.get());

    bought1 = exchange.buyCarbon();
    assertFalse(bought1.isPresent());

    assertEquals(Set.of(newCarbon1, newCarbon2), boughtSet1);

    Optional<Hydrogen> bought2 = exchange.buyHydrogen();
    assertTrue(bought2.isPresent());
    assertEquals(newHydrogen1, bought2.get());

    bought2 = exchange.buyHydrogen();
    assertFalse(bought2.isPresent());
  }

  @Test
  public void chemicalOrderedByAgentsPriorityAndLIFO() {
    exchangeHasInitiallyNoGoods();

    exchange.sellCarbon(newCarbon1, player0);
    exchange.sellCarbon(newCarbon2, player1);
    exchange.sellCarbon(newCarbon3, player1);

    Optional<Carbon> bought1 = exchange.buyCarbon();
    assertTrue(bought1.isPresent());
    assertEquals(newCarbon3, bought1.get());

    bought1 = exchange.buyCarbon();
    assertTrue(bought1.isPresent());
    assertEquals(newCarbon2, bought1.get());

    bought1 = exchange.buyCarbon();
    assertTrue(bought1.isPresent());
    assertEquals(newCarbon1, bought1.get());

    bought1 = exchange.buyCarbon();
    assertFalse(bought1.isPresent());

    exchange.sellHydrogen(newHydrogen2, player0);
    exchange.sellHydrogen(newHydrogen1, player0);
    exchange.sellHydrogen(newHydrogen3, player1);

    Optional<Hydrogen> bought2 = exchange.buyHydrogen();
    assertTrue(bought2.isPresent());
    assertEquals(newHydrogen3, bought2.get());

    bought2 = exchange.buyHydrogen();
    assertTrue(bought2.isPresent());
    assertEquals(newHydrogen1, bought2.get());

    bought2 = exchange.buyHydrogen();
    assertTrue(bought2.isPresent());
    assertEquals(newHydrogen2, bought2.get());

    bought2 = exchange.buyHydrogen();
    assertFalse(bought2.isPresent());
  }

  @Test
  public void lifeCycle() {
    final var carbonSupplier = new CarbonSupplier(1, exchange);
    final var hydrogenSupplier = new HydrogenSupplier(1, exchange);
    final var methaneMixer = new MethaneMixer(1, exchange);
    final var chemist = new Chemist(1, exchange);

    exchangeHasInitiallyNoGoods();

    // new elements sold
    carbonSupplier.doAction();
    hydrogenSupplier.doAction();
    hydrogenSupplier.doAction();

    // new composite made and sold
    methaneMixer.doAction();

    // composite bought and consumed
    chemist.doAction();

    exchangeHasInitiallyNoGoods();
  }
}
