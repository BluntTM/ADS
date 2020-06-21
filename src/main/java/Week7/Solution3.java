package Week7;

public class Solution3 {
    /**
     * Computes whether the BinaryTree is an AVL tree.
     *
     * @param tree
     *     the BinaryTree to check.
     * @return true iff the BinaryTree is an AVL tree, else false.
     */
    public static boolean isTreeAVL(BinaryTree tree) {
        return isTreeAVL(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Computes the height of the BinaryTree.
     * @param tree
     *     the BinaryTree to calculate the height for.
     * @return the height of the tree.
     */
    public static int getHeight(BinaryTree tree) {
        if (tree == null) return 0;
        return 1 + Math.max(getHeight(tree.getLeft()), getHeight(tree.getRight()));
    }

    /**
     * Computes whether the BinaryTree is an AVL tree.
     *
     * @param tree
     *     the BinaryTree to check.
     * @param min
     *     the minimum value the root key needs to have
     * @param max
     *     the maximum value the root key needs to have
     * @return true iff the BinaryTree is an AVL tree, else false.
     */
    public static boolean isTreeAVL(BinaryTree tree, int min, int max) {
        if (tree.getKey() < min || tree.getKey() > max) return false;
        if (tree.hasLeft() && !isTreeAVL(tree.getLeft(), min, tree.getKey() - 1)) return false;
        if (tree.hasRight() && !isTreeAVL(tree.getRight(), tree.getKey() + 1, max)) return false;
        if (Math.abs(getHeight(tree.getLeft()) - getHeight(tree.getRight())) > 1) return false;
        return true;
    }
}
