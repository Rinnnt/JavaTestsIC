package aeroplane;

import java.io.IOException;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.out.println("Program should be invoked with exactly one argument, the name of the data file");
			System.exit(1);
		}
		
		SeatAllocator allocator = new SeatAllocator();
		
		try {
			allocator.allocate(args[0]);
		} catch (IOException e) {
			System.out.println("An IO exception occurred");
			System.exit(1);
		} catch (AeroplaneFullException e) {
			System.out.println("Unable to allocate all passengers");
		}

		System.out.println(allocator);

		// TODO: Section A, Task 5 - use upgrade method

		allocator.upgrade();
		System.out.println(allocator);
		
	}

	// TODO: Section A, Task 6 - add countAdults method

	static long countAdults(Set<? extends Passenger> passengers) {
		return passengers.stream().filter(Passenger::isAdult).count();
	}
	
}
