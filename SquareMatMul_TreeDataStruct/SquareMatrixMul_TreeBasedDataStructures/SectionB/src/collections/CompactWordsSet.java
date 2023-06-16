package collections;

import collections.exceptions.InvalidWordException;
import java.util.List;

public interface CompactWordsSet {

  static void checkIfWordIsValid(String word) throws InvalidWordException {
    // TO BE IMPLEMENTED
    if (word == null) {
      throw new InvalidWordException("Word is null");
    }
    if (word.isEmpty()) {
      throw new InvalidWordException("Word is empty");
    }
    if (word.chars().anyMatch(c -> c < 'a' || c > 'z')) {
      throw new InvalidWordException("Word contains characters other than lowercase alphabets");
    }
  }

  boolean add(String word) throws InvalidWordException;

  boolean remove(String word) throws InvalidWordException;

  boolean contains(String word) throws InvalidWordException;

  int size();

  List<String> uniqueWordsInAlphabeticOrder();

}
