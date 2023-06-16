package aeroplane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SeatAllocator {

	private Map<Seat, Passenger> allocation;

	private static final String CREW = "crew";
	private static final String BUSINESS = "business";
	private static final String ECONOMY = "economy";

	private static final Seat CREW_START = new Seat(1, 'A');
	private static final Seat CREW_END = new Seat(1, 'F');
	private static final Seat BUSINESS_START = new Seat(2, 'A');
	private static final Seat BUSINESS_END = new Seat(15, 'F');
	private static final Seat ECONOMY_START = new Seat(16, 'A');
	private static final Seat ECONOMY_END = new Seat(50, 'F');

	public SeatAllocator() {
		allocation = new HashMap<Seat, Passenger>();
	}

	@Override
	public String toString() {
		return allocation.toString();
	}
	
	private void allocateInRange(Passenger passenger,
			Seat first, Seat last) throws AeroplaneFullException {

		// TODO: Section A, Task 4

		Seat cur = first;
		while (true) {
			if (!allocation.containsKey(cur)) {
				if (!cur.isEmergencyExit() || passenger.isAdult()) {
					allocation.put(cur, passenger);
					break;
				}
			}
			if (cur.hasNext() && cur != last) {
				cur = cur.next();
			} else {
				throw new AeroplaneFullException();
			}
		}
	}

	private static String readStringValue(BufferedReader br) throws MalformedDataException, IOException {

		String result = br.readLine();
		
		if(result == null) {
			throw new MalformedDataException();
		}
		
		return result;
		
	}

	private static int readIntValue(BufferedReader br)
			throws MalformedDataException, IOException {
		try {
			return Integer.parseInt(readStringValue(br));
		} catch(NumberFormatException e) {
			throw new MalformedDataException();
		}
	}

	private static Luxury readLuxuryValue(BufferedReader br)
			throws MalformedDataException, IOException {
		try {
			return Luxury.valueOf(readStringValue(br));
		} catch(IllegalArgumentException e) {
			throw new MalformedDataException();
		}
	}

	
	public void allocate(String filename) throws IOException, AeroplaneFullException {
		
		BufferedReader br = new BufferedReader(new FileReader(filename));

		String line;
		while((line = br.readLine()) != null) {
			try {
				if(line.equals(CREW)) {
					allocateCrew(br);
				} else if(line.equals(BUSINESS)) {
					allocateBusiness(br);
				} else if(line.equals(ECONOMY)) {
					allocateEconomy(br);
				} else {
					throw new MalformedDataException();
				}
			} catch(MalformedDataException e) {
				System.out.println("Skipping malformed line of input");
			}
		}
		
	}
	
	private void allocateCrew(BufferedReader br) throws IOException, MalformedDataException, AeroplaneFullException {
		String firstName = readStringValue(br);
		String lastName = readStringValue(br);
		// TODO: Section A, Task 4
		//       create a crew member using firstName and lastName
		//       call allocateInRange with appropriate arguments
		Passenger crewPassenger = new CrewPassenger(firstName, lastName);
		allocateInRange(crewPassenger, CREW_START, CREW_END);
	}

	private void allocateBusiness(BufferedReader br) throws IOException, MalformedDataException, AeroplaneFullException {
		String firstName = readStringValue(br);
		String lastName = readStringValue(br);
		int age = readIntValue(br);
		Luxury luxury = readLuxuryValue(br);
		// TODO: Section A, Task 4
		//       create a business class passenger using firstName, lastName, age and luxury
		//       call allocateInRange with appropriate arguments
		Passenger businessPassenger = new BusinessClassPassenger(firstName, lastName, age, luxury);
		allocateInRange(businessPassenger, BUSINESS_START, BUSINESS_END);
	}

	private void allocateEconomy(BufferedReader br) throws IOException, MalformedDataException, AeroplaneFullException {
		String firstName = readStringValue(br);
		String lastName = readStringValue(br);
		int age = readIntValue(br);
		// TODO: Section A, Task 4
		//       create an economy class passenger using firstName, lastName and age
		//       call allocateInRange with appropriate arguments
		Passenger economyPassenger = new EconomyClassPassenger(firstName, lastName, age);
		allocateInRange(economyPassenger,ECONOMY_START, ECONOMY_END);
	}

	// TODO: Section A, Task 5 - add upgrade method

	void upgrade() {
		Seat toUpgrade = ECONOMY_START;
		boolean full = false;
		while (allocation.containsKey(toUpgrade)) {
			Seat freeBusiness = BUSINESS_START;
			while (allocation.containsKey(freeBusiness) && freeBusiness != ECONOMY_START) {
				freeBusiness = freeBusiness.next();
			}
			if (!allocation.containsKey(freeBusiness)) {
				allocation.put(freeBusiness, allocation.get(toUpgrade));
				allocation.remove(toUpgrade);
			} else {
				break;
			}

			if (toUpgrade.hasNext()) {
				toUpgrade = toUpgrade.next();
			} else {
				break;
			}
		}
	}

}
