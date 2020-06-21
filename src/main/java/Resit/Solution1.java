package Resit;

public class Solution1 {
    /**
     * Given a Binary Search Tree and an Integer, returns the Entry in this tree
     * with the smallest key that is strictly larger than k.
     *
     * @param tree
     *     Binary search tree to search in.
     * @param k
     *     The key of the resulting entry should be strictly larger than this k.
     * @return The entry with smallest key, strictly larger than k.
     */
    static Entry higherEntry(BinarySearchTree tree, int k) {
        if (tree == null) return null;
        if (tree.getKey() > k) {
            Entry e = higherEntry(tree.getLeft(), k);
            if (e == null) return tree.getEntry();
            return e;
        }
        return higherEntry(tree.getRight(), k);
    }
}

/**
 * Library
 */
class BinarySearchTree {
    private Entry entry;
    private BinarySearchTree left, right;

    /**
     * Simple constructor.
     *
     * @param key
     *     to set as key.
     */
    public BinarySearchTree(int key, int value) {
        this.entry = new Entry(key, value);
    }

    /**
     * Extended constructor.
     *
     * @param key
     *     to set as key.
     * @param left
     *     to set as left child.
     * @param right
     *     to set as right child.
     */
    public BinarySearchTree(int key, int value, BinarySearchTree left, BinarySearchTree right) {
        this.entry = new Entry(key, value);
        setLeft(left);
        setRight(right);
    }

    /**
     * @return Entry stored at this node
     */
    public Entry getEntry() {
        return entry;
    }

    /**
     * @return Key of the entry stored at this node
     */
    public int getKey() {
        return entry.key;
    }

    /**
     * @return Value of the entry stored at this node
     */
    public int getValue() {
        return entry.value;
    }

    /**
     * @return the left child.
     */
    public BinarySearchTree getLeft() {
        return left;
    }

    /**
     * @return the right child.
     */
    public BinarySearchTree getRight() {
        return right;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    /**
     * @param left
     *     to set
     */
    public void setLeft(BinarySearchTree left) {
        this.left = left;
    }

    /**
     * @param right
     *     to set
     */
    public void setRight(BinarySearchTree right) {
        this.right = right;
    }
}

class Entry {
    public final int key;
    public final int value;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
