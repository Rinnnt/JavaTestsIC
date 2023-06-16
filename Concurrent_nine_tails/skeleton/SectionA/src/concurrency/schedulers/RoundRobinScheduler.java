package concurrency.schedulers;

import concurrency.ConcurrentProgram;
import concurrency.DeadlockException;
import java.util.Optional;
import java.util.Set;

public class RoundRobinScheduler implements Scheduler {

  private int lastId;

  public RoundRobinScheduler() {
    lastId = -1;
  }

  @Override
  public int chooseThread(ConcurrentProgram program) throws DeadlockException {
    Set<Integer> ids = program.getEnabledThreadIds();
    if (ids.isEmpty()) {
      throw new DeadlockException();
    }

    int smallestId = ids.stream().min(Integer::compareTo).get();
    if (lastId == -1) {
      lastId = smallestId;
    } else {
      lastId =  ids.stream().filter(t -> t > lastId).min(Integer::compareTo).orElse(smallestId);
    }
    return lastId;
  }
}
