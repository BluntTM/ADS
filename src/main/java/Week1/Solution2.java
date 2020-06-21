package Week1;

class Solution2 {
    /**
     * Reverses the order of the elements of the given array.
     *
     * @param arr the array to reverse
     */
    public static void reverse(int[] arr) {
        if (arr == null) {
            return;
        }

        int temp1, temp2;

        for (int i = 0; i < arr.length - i; i++) {
            temp1 = arr[i];
            temp2 = arr[arr.length - 1 - i];
            arr[i] = temp2;
            arr[arr.length - 1 - i] = temp1;
        }
    }
}
