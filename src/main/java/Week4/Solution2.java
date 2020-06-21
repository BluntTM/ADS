package Week4;

import java.util.*;

class Solution2 {
    /**
     * Computes whether the BinaryTree is complete.
     *
     * @param tree the BinaryTree to check.
     * @return true iff the BinaryTree is complete, else false.
     */
    public static boolean isTreeComplete(BinaryTree tree) {
        if (tree == null) return true;

        List<BinaryTree> list = new ArrayList<>();
        list.add(tree);

        boolean last = false;
        while (!list.isEmpty()) {
            BinaryTree bTree = list.remove(0);

            if (bTree.hasRight() && !bTree.hasLeft()) return false;
            if (last && (bTree.hasLeft() || bTree.hasRight())) return false;

            if (bTree.hasLeft() && !bTree.hasRight()) {
                last = true;
            }

            if (bTree.hasLeft()) {
                list.add(bTree.getLeft());
            }

            if (bTree.hasRight()) {
                list.add(bTree.getRight());
            }
        }

        return true;
    }

    /**
     * Library
     */
    class BinaryTree {
        int key;
        BinaryTree left;
        BinaryTree right;

        // Constructor with no children
        BinaryTree(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }

        // Constructor with two children
        BinaryTree(int key, BinaryTree left, BinaryTree right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }

        // Returns the key of the root of this tree.
        int getKey() {
            return key;
        }

        // Returns the left child of this tree iff hasLeft(v) is true, else null.
        BinaryTree getLeft() {
            return left;
        }

        // Set the new left child of this tree.
        void setLeft(BinaryTree child) {
            left = child;
        }

        // Returns the right child of this tree iff hasRight(v) is true, else null.
        BinaryTree getRight() {
            return right;
        }

        // Set the new right child of this tree.
        void setRight(BinaryTree child) {
            right = child;
        }

        // Returns true iff this tree has a left child.
        boolean hasLeft() {
            return left != null;
        }

        // Returns true iff this tree has a right child.
        boolean hasRight() {
            return right != null;
        }
    }
}
