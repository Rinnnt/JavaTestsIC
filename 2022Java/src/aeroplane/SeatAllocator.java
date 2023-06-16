package aeroplane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SeatAllocator {

  private final Map<Seat, Passenger> allocation;

  private static final String CREW = "crew";
  private static final String BUSINESS = "business";
  private static final String ECONOMY = "economy";
  
  public SeatAllocator() {
    allocation = new HashMap<Seat, Passenger>();
  }

  @Override
  public String toString() {
    final List<Seat> allocatedSeatsSortedByName = allocation.keySet()
            .stream()
            .distinct()
            .sorted((item1, item2) -> item1.toString().compareTo(item2.toString()))
            .collect(Collectors.toList());
    final StringBuilder result = new StringBuilder();
    for (var seat : allocatedSeatsSortedByName) {
      result.append(seat)
              .append(" -> ")
              .append(allocation.get(seat))
              .append("\n");
    }
    return result.toString();
  }
  
  private void allocateInRange(Passenger passenger,
      Seat first, Seat last) throws AllocationNotPossibleException {

    // TODO: Complete during Section A, question 4

  }

  private static String readStringValue(BufferedReader br) throws MalformedDataException,
          IOException {
    String result = br.readLine();
    if (result == null) {
      throw new MalformedDataException();
    }
    return result;
  }

  private static int readIntValue(BufferedReader br)
      throws MalformedDataException, IOException {
    try {
      return Integer.parseInt(readStringValue(br));
    } catch (NumberFormatException e) {
      throw new MalformedDataException();
    }
  }

  private static Luxury readLuxuryValue(BufferedReader br)
      throws MalformedDataException, IOException {
    try {
      return Luxury.valueOf(readStringValue(br));
    } catch (IllegalArgumentException e) {
      throw new MalformedDataException();
    }
  }

  public void allocate(String filename) throws IOException, AllocationNotPossibleException {
    BufferedReader br = new BufferedReader(new FileReader(filename));
    String line;
    while ((line = br.readLine()) != null) {
      try {
        switch (line) {
          case CREW -> allocateCrew(br);
          case BUSINESS -> allocateBusiness(br);
          case ECONOMY -> allocateEconomy(br);
          default -> throw new MalformedDataException();
        }
      } catch (MalformedDataException e) {
        throw new RuntimeException("Malformed line of input: " + line);
      }
    }
    
  }
  
  private void allocateCrew(BufferedReader br) throws IOException, MalformedDataException,
          AllocationNotPossibleException {
    String firstName = readStringValue(br);
    String lastName = readStringValue(br);
    // TODO: Complete during Section A, question 4
  }

  private void allocateBusiness(BufferedReader br) throws IOException, MalformedDataException,
          AllocationNotPossibleException {
    String firstName = readStringValue(br);
    String lastName = readStringValue(br);
    int age = readIntValue(br);
    Luxury luxury = readLuxuryValue(br);
    // TODO: Complete during Section A, question 4
  }

  private void allocateEconomy(BufferedReader br) throws IOException, MalformedDataException,
          AllocationNotPossibleException {
    String firstName = readStringValue(br);
    String lastName = readStringValue(br);
    int age = readIntValue(br);
    // TODO: Complete during Section A, question 4
  }

  // TODO: Section A, question 5 - add countAdults(...) method

}
