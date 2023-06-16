package aeroplane;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestSuiteRunner {
  public static void main(String[] args) {
    Result result =
            JUnitCore.runClasses(
                    aeroplane.Question1Tests.class,
                    aeroplane.Question2Tests.class,
                    aeroplane.Question3Tests.class,
                    aeroplane.Question4Tests.class,
                    aeroplane.Question5Tests.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
  }
}
