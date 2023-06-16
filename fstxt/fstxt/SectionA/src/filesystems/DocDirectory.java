package filesystems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DocDirectory extends DocFile {

  List<DocFile> files;

  public DocDirectory(String name) {
    super(name);
    files = new ArrayList<>();
  }

  public boolean containsFile(String name) {
    for (DocFile file : files) {
      if (name.equals(file.getName())) {
        return true;
      }
    }
    return false;
  }

  public Set<DocFile> getAllFiles() {
    return new HashSet<>(files);
  }

  public Set<DocDirectory> getDirectories() {
    return files.stream()
        .filter(DocFile::isDirectory)
        .map(DocFile::asDirectory)
        .collect(Collectors.toSet());
  }

  public Set<DocDataFile> getDataFiles() {
    return files.stream()
        .filter(DocFile::isDataFile)
        .map(DocFile::asDataFile)
        .collect(Collectors.toSet());
  }

  public void addFile(DocFile file) {
    if (containsFile(file.getName())) {
      throw new IllegalArgumentException("Directory already includes a file with name: " + file.getName());
    }
    files.add(file);
  }

  public boolean removeFile(String filename) {
    for (DocFile file : files) {
      if (filename.equals(file.getName())) {
        files.remove(file);
        return true;
      }
    }
    return false;
  }

  // PRE: Directory contains a file with the given filename
  public DocFile getFile(String filename) {
    for (DocFile file : files) {
      if (filename.equals(file.getName())) {
        return file;
      }
    }
    return null;
  }

  @Override
  public int getSize() {
    return getName().length();
  }

  @Override
  public boolean isDirectory() {
    return true;
  }

  @Override
  public boolean isDataFile() {
    return false;
  }

  @Override
  public DocDirectory asDirectory() {
    return this;
  }

  @Override
  public DocDataFile asDataFile() {
    throw new UnsupportedOperationException();
  }

  @Override
  public DocFile duplicate() {
    DocDirectory duplicateDirectory = new DocDirectory(getName());
    for (DocFile file : files) {
      duplicateDirectory.addFile(file.duplicate());
    }
    return duplicateDirectory;
  }
}
