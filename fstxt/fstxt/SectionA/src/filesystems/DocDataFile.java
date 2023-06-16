package filesystems;

import java.util.Arrays;

public final class DocDataFile extends DocFile {

  private final byte[] contents;

  public DocDataFile(String name, byte[] contents) {
    super(name);
    this.contents = Arrays.copyOf(contents, contents.length);
  }

  public boolean containsByte(byte targetByte) {
    for (byte content : contents) {
      if (content == targetByte) {
        return true;
      }
    }
    return false;
  }

  @Override
  public int getSize() {
    return getName().length() + contents.length;
  }

  @Override
  public boolean isDirectory() {
    return false;
  }

  @Override
  public boolean isDataFile() {
    return true;
  }

  @Override
  public DocDirectory asDirectory() {
    throw new UnsupportedOperationException();
  }

  @Override
  public DocDataFile asDataFile() {
    return this;
  }

  @Override
  public DocFile duplicate() {
    return new DocDataFile(getName(), contents);
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof DocDataFile that)) {
      return false;
    }
    return getName().equals(that.getName()) && Arrays.equals(contents, that.contents);
  }

  @Override
  public int hashCode() {
    return getName().hashCode() + Arrays.hashCode(contents);
  }
}
