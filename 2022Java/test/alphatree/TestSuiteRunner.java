package alphatree;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestSuiteRunner {
  public static void main(String[] args) {
    Result result =
        JUnitCore.runClasses(alphatree.TestQuestion1.class, alphatree.TestQuestion2.class,
            alphatree.TestQuestion3.class, alphatree.TestQuestion4.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
  }
}
