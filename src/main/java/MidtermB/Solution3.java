package MidtermB;

class Solution3 {
    /**
     * Takes an array and sorts it in an ascending order.
     * This has to be done by using merge sort.
     * <p>
     * If the array is null, the metod should stop.
     *
     * @param arr - the array that needs to be sorted.
     */
    public static void mergeSort(int[] arr) {
        if (arr == null) return;
        int[] sorted = mergeSortHelper(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sorted[i];
        }
    }

    public static int[] mergeSortHelper(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int half = arr.length / 2;
        int[] arr1 = new int[half];
        int[] arr2 = new int[arr.length % 2 == 0 ? half : half + 1];
        for (int i = 0; i < arr.length; i++) {
            if (i < half)
                arr1[i] = arr[i];
            else
                arr2[i - half] = arr[i];
        }


        return merge(mergeSortHelper(arr1), mergeSortHelper(arr2));
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) {
            return arr2.clone();
        }
        if (arr2 == null || arr2.length == 0) {
            return arr1.clone();
        }

        int l1 = arr1.length;
        int l2 = arr2.length;

        int[] ret = new int[l1 + l2];
        int i = 0, i1 = 0, i2 = 0;

        while (i1 < l1 && i2 < l2) {
            if (arr1[i1] < arr2[i2]) {
                ret[i++] = arr1[i1++];
            } else {
                ret[i++] = arr2[i2++];
            }
        }

        while (i1 < l1) ret[i++] = arr1[i1++];
        while (i2 < l2) ret[i++] = arr2[i2++];

        return ret;
    }
}