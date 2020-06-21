package Week2;

import java.util.*;

class Solution2 {
    /**
     * Removes all elements from the ArrayList, using the removeLastOccurrence method.
     *
     * @param list to remove the elements from.
     */
    public static void removeAll(ArrayList<Integer> list) {
        int i = 0;
        while (i < list.size()) {
            removeLastOccurrence(list.get(i), list);
        }
    }

    /**
     * Takes an ArrayList and removes last occurrence of x,
     * shifting the rest of the elements left.
     * I.e. [5, 1, 5, 9, 8], with x = 5
     * would result in: [5, 1, 9, 8].
     * Note that this method does not return a new list.
     * Instead, the list that is passed as a parameter is changed.
     *
     * @param list to remove an element from.
     * @param x    element value to look for
     */
    public static void removeLastOccurrence(int x, ArrayList<Integer> list) {
        if (list == null) return;

        int i = list.size() - 1;
        if (i >= 0) {
            while (i >= 0) {
                if (list.get(i) == x) {
                    list.remove(i);
                    break;
                }
                i--;
            }
        }
    }
}
