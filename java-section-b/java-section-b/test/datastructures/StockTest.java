package datastructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import testutils.MockChemical;
import testutils.MockPlayer;

public class StockTest {

  Stock<MockChemical> stock;
  MockPlayer mockAgents[] = new MockPlayer[5];

  private MockChemical newMockProduct() {
    return new MockChemical();
  }

  @Before
  public void initializeStock() {
    stock = new StockImpl<>();
    // The array is filled in order so to have mockAgents[i].id < mockAgent[i+1].id
    Arrays.setAll(mockAgents, i -> new MockPlayer(1, null));
  }

  @Test
  public void theStockIsInitiallyEmpty() {
    assertEquals(0, stock.size());
  }

  @Test
  public void popFromEmptyStockIsEmpty() {
    Optional<MockChemical> retrieved = stock.pop();
    assertTrue(retrieved.isEmpty());
  }

  @Test
  public void addingElementsIncreasesTheSize() {
    assertEquals(0, stock.size());
    stock.push(newMockProduct(), mockAgents[3]);
    assertEquals(1, stock.size());
    stock.push(newMockProduct(), mockAgents[3]);
    assertEquals(2, stock.size());
    stock.push(newMockProduct(), mockAgents[1]);
    assertEquals(3, stock.size());
    stock.push(newMockProduct(), mockAgents[4]);
    assertEquals(4, stock.size());
    stock.push(newMockProduct(), mockAgents[2]);
    assertEquals(5, stock.size());
    stock.push(newMockProduct(), mockAgents[2]);
    assertEquals(6, stock.size());
  }

  @Test
  public void removingElementsDecreasesTheSize() {
    stock.push(newMockProduct(), mockAgents[0]);
    stock.push(newMockProduct(), mockAgents[3]);
    stock.push(newMockProduct(), mockAgents[2]);
    stock.push(newMockProduct(), mockAgents[3]);
    stock.push(newMockProduct(), mockAgents[4]);
    stock.push(newMockProduct(), mockAgents[4]);
    stock.push(newMockProduct(), mockAgents[1]);
    stock.push(newMockProduct(), mockAgents[1]);

    assertEquals(8, stock.size());
    Optional<MockChemical> retrieved = stock.pop();
    assertTrue(retrieved.isPresent());
    assertEquals(7, stock.size());

    for (int expected = 6; expected >= 0; expected--) {
      retrieved = stock.pop();
      assertTrue(retrieved.isPresent());
      assertEquals(expected, stock.size());
    }

    retrieved = stock.pop();
    assertTrue(retrieved.isEmpty());
    assertEquals(0, stock.size());
  }

  @Test
  public void productsFromHigherPriorityAgentComeFirst() {
    final List<MockChemical> a0p = List.of(newMockProduct(), newMockProduct());
    final List<MockChemical> a1p = List.of(newMockProduct(), newMockProduct());
    final List<MockChemical> a2p = List.of(newMockProduct(), newMockProduct());
    final List<MockChemical> a3p = List.of(newMockProduct(), newMockProduct());
    final List<MockChemical> a4p = List.of(newMockProduct(), newMockProduct());

    stock.push(a1p.get(0), mockAgents[1]);
    stock.push(a0p.get(0), mockAgents[0]);
    stock.push(a3p.get(0), mockAgents[3]);
    stock.push(a4p.get(0), mockAgents[4]);
    stock.push(a2p.get(0), mockAgents[2]);

    stock.push(a1p.get(1), mockAgents[1]);
    stock.push(a0p.get(1), mockAgents[0]);
    stock.push(a3p.get(1), mockAgents[3]);
    stock.push(a4p.get(1), mockAgents[4]);
    stock.push(a2p.get(1), mockAgents[2]);

    assertEquals(10, stock.size());

    assertTrue(a4p.contains(stock.pop().get()));
    assertTrue(a4p.contains(stock.pop().get()));

    assertTrue(a3p.contains(stock.pop().get()));
    assertTrue(a3p.contains(stock.pop().get()));

    assertTrue(a2p.contains(stock.pop().get()));
    assertTrue(a2p.contains(stock.pop().get()));

    assertTrue(a1p.contains(stock.pop().get()));
    assertTrue(a1p.contains(stock.pop().get()));

    assertTrue(a0p.contains(stock.pop().get()));
    assertTrue(a0p.contains(stock.pop().get()));

    assertEquals(0, stock.size());
  }
}
