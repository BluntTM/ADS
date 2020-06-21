package Week2;

class Solution1 {
    /**
     * Takes the array and the last occurring element x,
     * shifting the rest of the elements left. I.e.
     * [1, 4, 7, 9], with x=7 would result in:
     * [1, 4, 9].
     *
     * @param x   the entry to remove from the array
     * @param arr to remove an entry from
     * @return the updated array, without the last occurrence of x
     */
    public static int[] removeLastOccurrence(int x, int[] arr) {
        if (arr == null)
            return null;

        int i = arr.length - 1;
        if (i >= 0) {
            int[] ret = new int[i];

            boolean isRemoved = false;
            while (i >= 0) {
                if (!isRemoved && arr[i] == x) {
                    isRemoved = true;
                    i--;
                    continue;
                }

                int in = isRemoved ? i : i - 1;
                if (in >= 0 && in < ret.length) {
                    ret[in] = arr[i];
                }
                i--;
            }

            return isRemoved ? ret : arr.clone();
        }

        return arr.clone();
    }
}
