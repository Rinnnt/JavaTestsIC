package concurrency;

import java.util.LinkedList;
import java.util.List;

import concurrency.schedulers.Scheduler;

public class Executor {

	private final ConcurrentProgram program;
	private final Scheduler scheduler;

	public Executor(ConcurrentProgram program, Scheduler scheduler) {
		this.program = program;
		this.scheduler = scheduler;
	}

	/**
	 * Executes program with respect to scheduler
	 *
	 * @return the final state and history of execution
	 */
	public String execute() {
		List<Integer> history = new LinkedList<Integer>();
		boolean deadlockOccurred = false;

		// TODO: Add code here to complete Question 3
		try {
			while (!program.isTerminated()) {
				int nextId = scheduler.chooseThread(program);
				program.step(nextId);
				history.add(nextId);
			}
		} catch (DeadlockException e) {
			deadlockOccurred = true;
		}

		StringBuilder result = new StringBuilder();
		result.append("Final state: " + program + "\n");
		result.append("History: " + history + "\n");
		result.append("Termination status: "
				+ (deadlockOccurred ? "deadlock" : "graceful") + "\n");
		return result.toString();
	}

	// An incorrect attempt at overriding the equals method
	// of Object
	@Override
	public boolean equals(Object that) {
		if (!(that instanceof Executor thatExecutor)) {
			return false;
		}
		return program.toString().equals(thatExecutor.program.toString());
	}

	@Override
	public int hashCode() {
		return program.toString().hashCode();
	}

}
