package Week6;

import java.util.*;

public class Solution2 {
    @SuppressWarnings("unchecked")
    public static Queue<Integer>[] fillBuckets(int[] array) {
        if (array == null || array.length == 0) return new LinkedList[0];
        int vmin = array[0];
        int vmax = array[0];

        for (int i : array) {
            if (i < vmin) vmin = i;
            if (i > vmax) vmax = i;
        }

        Queue<Integer>[] buckets = new Queue[vmax - vmin + 1];

        for (int v : array) {
            int i = v - vmin;

            if (buckets[i] == null) {
                buckets[i] = new LinkedList<>();
            }
            buckets[i].add(v);
        }
        return buckets;
    }

    public static int[] readBuckets(Queue<Integer>[] buckets) {
        int size = 0;
        for (Queue<Integer> q : buckets) {
            if (q == null) continue;
            size += q.size();
        }

        int[] ret = new int[size];
        int i = 0;
        for (Queue<Integer> q : buckets) {
            if (q == null) continue;
            while (q.peek() != null) ret[i++] = q.remove();
        }
        return ret;
    }
}
