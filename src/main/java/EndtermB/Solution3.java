package EndtermB;

import java.util.*;

public class Solution3 {
    /**
     * Sorts a list of Dutch mobile phone numbers using LSD radix sort.
     *
     * @param phoneNumbers
     *     The list of phone numbers to sort.
     * @return The sorted list of phone numbers.
     * @throws NullPointerException
     *     If `phoneNumbers` equals `null`.
     */
    static List<String> radixSortLSD(List<String> phoneNumbers) {
        if (phoneNumbers == null) throw new NullPointerException();
        if (phoneNumbers.size() <= 1) return new ArrayList<>(phoneNumbers);

        for (int i = 9; i >= 2; i--) { // Assuming 06XXXXXXXX format.
            phoneNumbers = radixSortLSD(phoneNumbers, i);
        }
        return phoneNumbers;
    }

    @SuppressWarnings("unchecked")
    static List<String> radixSortLSD(List<String> phoneNumbers, int radix) {
        List<String> sorted = new ArrayList<>();

        LinkedList<String>[] buckets = new LinkedList[10];
        for (String phone : phoneNumbers) {
            int index = (int) phone.charAt(radix) - 48;
            if (buckets[index] == null) buckets[index] = new LinkedList<>();
            buckets[index].add(phone);
        }

        for (LinkedList<String> bucket : buckets) {
            if (bucket == null) continue;
            sorted.addAll(bucket);
        }

        return sorted;
    }
}
