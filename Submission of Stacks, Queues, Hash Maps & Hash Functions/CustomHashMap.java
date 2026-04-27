class CustomHashMap {
    
    // Entry class representing K,V pairs
    private static class Entry {
        int key;
        int value;
        Entry next;
        
        Entry(int k, int v) {
            key = k;
            value = v;
        }
    }
    
    private final int SIZE = 1000;
    private Entry[] buckets;

    public CustomHashMap() {
        buckets = new Entry[SIZE];
    }
    
    private int getHash(int key) {
        // Handle negative keys by shifting to positive range modulo
        return Math.abs(Integer.hashCode(key)) % SIZE;
    }

    public void put(int key, int value) {
        int index = getHash(key);
        Entry curr = buckets[index];
        if (curr == null) {
            buckets[index] = new Entry(key, value);
            return;
        }
        
        Entry prev = null;
        while (curr != null) {
            // Update existing key
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        
        // Append new key at end of chain
        prev.next = new Entry(key, value);
    }

    public int get(int key) {
        int index = getHash(key);
        Entry curr = buckets[index];
        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }
        return -1; // Standard return for not found
    }

    public void remove(int key) {
        int index = getHash(key);
        Entry curr = buckets[index];
        Entry prev = null;
        
        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    buckets[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put(1, 100);
        map.put(2, 200);
        System.out.println("Get 1: " + map.get(1)); // 100
        System.out.println("Get 3: " + map.get(3)); // -1
        map.put(2, 250); 
        System.out.println("Get 2 Update: " + map.get(2)); // 250
        map.remove(2);
        System.out.println("Get 2 Removed: " + map.get(2)); // -1
    }
}
