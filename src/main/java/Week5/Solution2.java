package Week5;

class Solution2 {
  /**
   * @param elements - array of integers to be sorted.
   */
  public static void insertionSort(int[] elements) {
    if (elements == null) return;

    int temp;
    for (int i = 1; i < elements.length; i++) {
      temp = elements[i];

      for (int j = i - 1; j >= 0; j--) {
        if (elements[j] > temp) {
          elements[j + 1] = elements[j];

          if (j == 0) {
            elements[j] = temp;
          }
        } else {
          elements[j + 1] = temp;
          break;
        }
      }
    }
  }
}
