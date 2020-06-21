package Week6;

public class Solution3 {
    public static void stableSort(String[][] table, int column) {
        if (table == null || column < 0) return;

        // insertion sort
        for (int i = 1; i < table.length; i++) {
            String[] row = table[i];
            String v = row[column];
            for (int j = i - 1; j >= 0; j--) {
                String v2 = table[j][column];

                if (v2.compareTo(v) > 0) {
                    table[j+1] = table[j];
                    if (j == 0) {
                        table[j] = row;
                    }
                } else {
                    table[j+1] = row;
                    break;
                }
            }
        }
    }
}
