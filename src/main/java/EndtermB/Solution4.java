package EndtermB;

class SolutionHashTable {
    public Entry[] table;
    public int capacity;

    /**
     * Constructs a new HashTable.
     *
     * Capacity of the hash table can not be 0 or negative.
     *
     * @param capacity
     *     to be used as capacity of the table.
     * @throws IllegalArgumentException
     *     if the input capacity is invalid.
     */
    public SolutionHashTable(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException();
        this.table = new Entry[capacity];
        this.capacity = capacity;
    }

    /**
     * Add a new Entry to the hash table,
     * uses linear probing to deal with collisions.
     *
     * Returns false, if the key is null or the table is full.
     *
     * @param key
     *     String representing the key of the entry.
     * @param value
     *     String representing the value of the entry.
     * @return true iff entry has been added successfully, else false.
     */
    public boolean put(String key, String value) {
        if (key == null) return false;
        int i = hash(key);
        int end = i; // Don't allow loops
        Entry e = new Entry(key, value);
        int probeIndex = -1;
        do {
            if (table[i] != null && key.equals(table[i].getKey())) {
                table[i] = e;
                return true;
            } else if (table[i] == null || table[i].getKey() == null || key.equals(table[i].getKey())) {
                if (probeIndex == -1) probeIndex = i;
                if (table[i] == null) break;
            }
            i = (i + 1) % capacity;
        } while (i != end);

        if (probeIndex != -1) {
            table[probeIndex] = e;
            return true;
        }
        return false;
    }

    /**
     * Retrieve the value of the entry associated with this key.
     *
     * Returns null, if the key is null.
     *
     * @param key
     *     String representing the key of the entry to look for.
     * @return value of the entry as String iff the entry with this key is found in the hash table, else null.
     */
    public String get(String key) {
        if (key == null) return null;
        int i = hash(key);
        int end = i; // Don't allow loops
        do {
            if (table[i] == null) return null;
            if (key.equals(table[i].getKey())) {
                return table[i].getValue();
            }
            i = (i + 1) % capacity;
        } while (i != end);
        return null;
    }

    /**
     * Remove the entry associated with this key from the hash table.
     *
     * Returns false, if the key is null.
     *
     * @param key
     *     String representing the key of the entry to remove.
     * @return true iff the entry has been successfully removed, else false.
     */
    public boolean remove(String key) {
        if (key == null) return false;
        int i = hash(key);
        int end = i; // Don't allow loops
        do {
            if (table[i] == null) return false;
            if (key.equals(table[i].getKey())) {
                setDefunct(i);
                return true;
            }
            i = (i + 1) % capacity;
        } while (i != end);
        return false;
    }

    /**
     * Takes as input an index and sets the entry in that location as defunct.
     *
     * @param index
     *     The index of the spot that is defunct.
     */
    public void setDefunct(int index) {
        this.table[index] = new Entry(null, null);
    }

    /**
     * Hashes a string representing a key.
     *
     * @param key
     *     String that needs to be hashed.
     * @return the hashcode of the string, modulo the capacity of the HashTable.
     */
    public int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }
}

/**
 * Library
 */
class Entry {
    private String key;
    private String value;

    public Entry(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}