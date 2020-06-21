package Week5;

class Solution1 {
  /**
   * @param elements Array of integers to be sorted.
   */
  public static void selectionSort(int[] elements) {
    int smallest, temp;
    for (int i = 0; i < elements.length; i++) {
      smallest = elements[i];
      for (int j = i; j < elements.length; j++) {
        if (elements[j] < smallest) {
          temp = smallest;
          smallest = elements[j];
          elements[j] = temp;
        }

        if (j == elements.length - 1) {
          elements[i] = smallest;
        }
      }
    }
  }
}
