package Week1;

class Solution3 {
    /**
     * Merges two sorted arrays such that the resulting array has all elements
     * from both arrays and is also sorted. Assumes that the elements in the
     * given arrays are sorted in non-decreasing order. If there are duplicate
     * elements in the input arrays, these should also be present in the
     * resulting array. If both arrays are null the result should be null, or a
     * copy of the non-null array if only one is null.
     * <p>
     * Efficiency requirements: merge the two arrays in a single pass.
     *
     * @param arr1 first sorted array to be merged
     * @param arr2 second sorted array to be merged
     * @return sorted array containing all elements from both arrays
     */
    public static int[] merge(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return null;
        }

        int i1 = 0;
        int i2 = 0;
        int l1 = arr1 != null ? arr1.length : 0;
        int l2 = arr2 != null ? arr2.length : 0;
        int[] ret = new int[l1 + l2];
        int index = 0;

        while (i1 < l1 && i2 < l2) {
            if (arr1[i1] < arr2[i2]) {
                ret[index++] = arr1[i1++];
            } else {
                ret[index++] = arr2[i2++];
            }
        }

        while (i1 < l1) {
            ret[index++] = arr1[i1++];
        }

        while (i2 < l2) {
            ret[index++] = arr2[i2++];
        }

        return ret;
    }
}
