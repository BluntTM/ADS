package Week7;

import java.util.*;

public class Solution2 {
    /**
     * Return all elements in the given BST in descending order.
     * @param tree The BST to traverse.
     * @return A list of all elements in reverse order.
     */
    public static List<Integer> descendingOrder(BinaryTree tree) {
        return descendingOrder(tree, new ArrayList<>());
    }

    /**
     * Return all elements in the given BST in descending order.
     * @param tree The BST to traverse.
     * @param list The List to start with.
     * @return A list of all elements in reverse order.
     */
    public static List<Integer> descendingOrder(BinaryTree tree, List<Integer> list) {
        if (tree.hasRight()) descendingOrder(tree.getRight(), list);
        list.add(tree.getKey());
        if (tree.hasLeft()) descendingOrder(tree.getLeft(), list);
        return list;
    }
}
