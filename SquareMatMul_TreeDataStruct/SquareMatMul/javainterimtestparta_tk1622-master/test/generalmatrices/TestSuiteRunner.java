package generalmatrices;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestSuiteRunner {
  public static void main(String[] args) {
    Result result =
            JUnitCore.runClasses(
                    generalmatrices.Question1Tests.class,
                    generalmatrices.Question2Tests.class,
                    generalmatrices.Question3Tests.class,
                    generalmatrices.Question4Tests.class);
    if (result.wasSuccessful()) {
      System.exit(0);
    }
    System.err.println("There were test failures:");
    for (Failure failure : result.getFailures()) {
      System.err.println(failure.toString());
    }
    System.exit(1);
  }
}
