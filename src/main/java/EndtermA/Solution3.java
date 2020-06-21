package EndtermA;

import java.util.*;

public class Solution3 {
    /**
     * Sorts a list of words using MSD radix sort.
     *
     * @param words
     *     The list of words to sort.
     * @return The sorted list of words.
     * @throws NullPointerException
     *     If `words` equals `null`.
     */
    static List<String> radixSortMSD(List<String> words) {
        if (words == null) throw new NullPointerException();
        if (words.size() <= 1) return new ArrayList<>(words);
        return radixSortMSD(words, 0);
    }

    @SuppressWarnings("unchecked")
    private static List<String> radixSortMSD(List<String> words, int radix) {
        List<String> sorted = new ArrayList<>(words.size());

        LinkedList<String>[] buckets = new LinkedList[26];
        for (String word : words) {
            if (word.length() <= radix) {
                sorted.add(word);
                continue;
            }

            int i = (int) word.charAt(radix) - 97;
            if (buckets[i] == null) buckets[i] = new LinkedList<>();
            buckets[i].add(word);
        }

        if (sorted.size() != words.size()) {
            for (LinkedList<String> list : buckets) {
                if (list == null) continue;
                sorted.addAll(radixSortMSD(list, radix + 1));
            }
        }

        return sorted;
    }
}
