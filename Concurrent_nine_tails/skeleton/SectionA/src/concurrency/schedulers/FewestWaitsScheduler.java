package concurrency.schedulers;

import concurrency.ConcurrentProgram;
import concurrency.DeadlockException;
import concurrency.statements.WaitStmt;
import java.util.Set;

public class FewestWaitsScheduler implements Scheduler {

  public FewestWaitsScheduler() {
  }

  @Override
  public int chooseThread(ConcurrentProgram program) throws DeadlockException {
    Set<Integer> ids = program.getEnabledThreadIds();
    if (ids.isEmpty()) {
      throw new DeadlockException();
    }

    return ids.stream().reduce((t1, t2) -> {
      long w1 = program.remainingStatements(t1).stream().filter(stmt -> stmt instanceof WaitStmt).count();
      long w2 = program.remainingStatements(t2).stream().filter(stmt -> stmt instanceof WaitStmt).count();
      if (w1 == w2) {
        return (t1 < t2) ? t1 : t2;
      } else {
        return (w1 < w2) ? t1 : t2;
      }
    }).get();

//    int nextId = -1;
//    int fewestWaits = Integer.MAX_VALUE;
//    for (int id : ids) {
//      int waits = (int) program.remainingStatements(id).stream().filter(stmt -> stmt instanceof WaitStmt).count();
//      if (waits < fewestWaits || (waits == fewestWaits && id < nextId)) {
//        nextId = id;
//        fewestWaits = waits;
//      }
//    }
//    return nextId;
  }
}
