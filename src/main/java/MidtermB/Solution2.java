package MidtermB;

class Solution2 {
    /**
     * @param heap the Heap to check, can be null. If not null, this heap will always contain at least one Node.
     * @return the Node corresponding to the last position in the Heap, or null if the Heap is null.
     */
    public static Heap.Node findLastPosition(Heap heap) {
        if (heap == null) return null;
        int height = getHeight(heap) - 1;
        int index = getLastIndex(heap);

        Heap.Node node = heap.getRoot();
        int mask = 1 << (height - 1);
        while (height > 0) {
            if ((index & mask) == 0) {
                node = heap.getLeft(node);
            } else {
                node = heap.getRight(node);
            }

            height--;
            mask = (mask >> 1);
        }
        return node;
    }

    /**
     * Returns height of input heap, starting from 1.
     */
    public static int getHeight(Heap heap) {
        int i = 0;
        while (Math.pow(2, i) <= heap.size())
            i++;
        return i;
    }

    /**
     * Returns last index of heap
     */
    public static int getLastIndex(Heap heap) {
        int height = getHeight(heap);
        int s1 = (int) Math.pow(2, height - 1) - 1;
        int s2 = (int) Math.pow(2, height) - 1;
        int min = s2 - heap.size();
        return s2 - s1 - min - 1;
    }
}

/**
 * Library
 */
class Heap {
    private int size = 0;
    private Heap.Node root;

    /**
     * Initializes a Heap with one Node.
     *
     * @param rootKey the key given to the root Node of the Heap.
     */
    public Heap(int rootKey) {
        root = new Heap.Node(rootKey);
        size++;
    }

    /**
     * @return the root Node of this Heap.
     */
    public Heap.Node getRoot() {
        return root;
    }

    /**
     * @param n The Node to get the left child from.
     * @return the left child of n.
     */
    public Heap.Node getLeft(Heap.Node n) {
        return n.left;
    }

    /**
     * @param n The Node to get the right child from.
     * @return the right child of n.
     */
    public Heap.Node getRight(Heap.Node n) {
        return n.right;
    }

    /**
     * @param n The Node to check the left child from.
     * @return true iff Node n has a left child, false otherwise.
     */
    public boolean hasLeft(Heap.Node n) {
        return n.left != null;
    }

    /**
     * @param n The Node to check the right child from.
     * @return true iff Node n has a right child, false otherwise.
     */
    public boolean hasRight(Heap.Node n) {
        return n.right != null;
    }

    /**
     * This method creates a new left child of n if it does not yet have a left child.
     *
     * @param n       The Node to set the left child from.
     * @param leftKey The key to set in the left child of Node n.
     */
    public void setLeft(Heap.Node n, int leftKey) {
        if (n.left == null) {
            n.left = new Heap.Node(leftKey);
            size++;
        } else {
            n.left.key = leftKey;
        }
    }

    /**
     * This method creates a new right child of n if it does not yet have a right child.
     *
     * @param n        The Node to set the right child from.
     * @param rightKey The key to set in the right child of Node n.
     */
    public void setRight(Heap.Node n, int rightKey) {
        if (n.right == null) {
            n.right = new Heap.Node(rightKey);
            size++;
        } else {
            n.right.key = rightKey;
        }
    }

    /**
     * @return The size of this Heap, i.e. the amount of Nodes.
     */
    public int size() {
        return size;
    }

    class Node {
        private int key;
        private Heap.Node left, right;

        /**
         * Simple constructor.
         *
         * @param key to set as key.
         */
        public Node(int key) {
            this.key = key;
        }

        /**
         * @return The integer key of this Node.
         */
        public int getKey() {
            return key;
        }

        @Override
        public String toString() {
            return key + "(" + (left == null ? " " : left) + ',' + (right == null ? " " : right) + ')';
        }
    }
}