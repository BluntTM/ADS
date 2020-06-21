package Week6;

public class Solution1 {
    /**
     * @param elements
     *     Array of integers to be sorted.
     */
    public static void quickSort(int[] elements) {
        if (elements == null) return;
        quickSort(elements, 0, elements.length - 1);
    }

    public static void quickSort(int[] elements, int a, int b) {
        if (a >= b) return;
        int left = a;
        int right = b - 1;
        int pivot = elements[b];
        while (left <= right) {
            while (left <= right && elements[left] < pivot) left++;
            while (left <= right && elements[right] > pivot) right--;
            if (left <= right) {
                swap(elements, left, right);
                left++;
                right--;
            }
        }
        swap(elements, left, b);

        quickSort(elements, a, left - 1);
        quickSort(elements, left + 1, b);
    }

    private static void swap(int[] elements, int a, int b) {
        int temp = elements[a];
        elements[a] = elements[b];
        elements[b] = temp;
    }
}
