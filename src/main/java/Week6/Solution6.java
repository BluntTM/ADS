package Week6;

class ETHHash extends HashTable {
    public ETHHash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        if (item == null) return 0;

        int b = 1;
        for (char ch : item.toCharArray()) {
            b = (int)ch * ((b % 257) + 1);
        }
        return b % getCapacity();
    }
}

class GNUCPPHash extends HashTable {
    public GNUCPPHash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        int b = 0;
        if (item != null) {
            for (char ch : item.toCharArray()) {
                b = 4 * b + (int)ch;
            }
        }
        return ((b << 1) >>> 1) % getCapacity();
    }
}

class GNUCC1Hash extends HashTable {
    public GNUCC1Hash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        if (item == null) return 0;
        int b = item.length();
        for (char ch : item.toCharArray()) {
            b = 613*b + (int)ch;
        }
        return ((b << 2) >>> 2) % getCapacity();
    }
}

class HashCodeHash extends HashTable {
    public HashCodeHash(int size) {
        super(size);
    }

    @Override
    public int hash(String item) {
        if (item == null) return 0;
        return Math.abs(item.hashCode()) % getCapacity();
    }
}
