package bangman.player;

import alphatree.AlphaTree;
import alphatree.Utils;
import bangman.Bangman;
import bangman.Guess;
import java.util.LinkedList;
import java.util.List;

public class PlayerTree extends Player {
  public static PlayerFactory factory = new PlayerFactory() {
    public Player makePlayer(List<String> words) {
      return new PlayerTree(words);
    }
  };
  private final AlphaTree root;
  private AlphaTree tree;
  private AlphaTree treeTrue;
  private AlphaTree treeFalse;
  private int length;
  private StringBuilder word;
  private int secretLength;

  public PlayerTree(List<String> words) {
    List<Character> chars = new LinkedList<Character>();
    for (String word : words) {
      for (char c : word.toCharArray()) {
        chars.add(c);
      }
    }

    this.root = Utils.newAlphaTree(chars);
  }

  public static void main(String[] args) {
    Bangman.runGame(PlayerTree.factory);
  }

  @Override
  public void newGame(int secretLength, String hint) {
    this.tree = this.root;
    this.length = 0;
    this.secretLength = secretLength;
    this.word = new StringBuilder();
  }

  @Override
  public Guess guess() {
    if (root == null || root.isEmpty()) {
      return new Guess.Word("");
    } else if (root.isSingleton()) {
      return new Guess.Word("" + Utils.getElem(root.chars()));
    } else if (length == secretLength) {
      return new Guess.Word(word.toString());
    } else {
      treeTrue = tree.left();
      treeFalse = tree.right();
      return new Guess.Char(length, treeTrue.chars());
    }
  }

  @Override
  public void tell(boolean response, int turns, boolean finished) {
    if (finished) {
      return;
    }

    tree = response ? treeTrue : treeFalse;
    if (tree != null && tree.isSingleton()) {
      word.append(Utils.getElem(tree.chars()));
      length++;
      tree = root;
    }
  }
}
