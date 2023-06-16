package testutils;

import exchange.ExchangeTest;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestSuiteRunner {

  public static void main(String[] args) {
    // Comment out the following line if you want to see output on the output stream
    System.setOut(
        new PrintStream(
            new OutputStream() {
              @Override
              public void write(int b) throws IOException {
                // Discard any write operation
              }
            }));

    Result result =
        JUnitCore.runClasses(
            datastructures.LIFOTest.class,
            datastructures.StockTest.class,
            ExchangeTest.class,
            datastructures.StockStressMonkey.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
  }
}
