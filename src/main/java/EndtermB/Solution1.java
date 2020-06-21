package EndtermB;

import java.util.*;

public class Solution1 {
    /**
     * Counts the number of nodes with an event number of children.
     *
     * @param tree
     *     The tree to count nodes with an even number of children in.
     * @return the number of nodes with an even number of children, or 0 if tree is null.
     */
    public static int countNodesEvenChildren(LibraryTree tree) {
        if (tree == null) return 0;

        int count = (tree.getChildren().size() % 2 == 0) ? 1 : 0;
        for (LibraryTree t : tree.getChildren()) {
            count += countNodesEvenChildren(t);
        }
        return count;
    }
}

/**
 * Library
 */
class LibraryTree {
    private int key;
    private List<LibraryTree> children;

    public LibraryTree(int key) {
        this.key = key;
        children = new ArrayList<>();
    }

    public LibraryTree(int key, List<LibraryTree> children) {
        this.key = key;
        this.children = children;
    }

    public int getKey() {
        return this.key;
    }

    public List<LibraryTree> getChildren() {
        return this.children;
    }
}
