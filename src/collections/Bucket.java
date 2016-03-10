package collections;

class Bucket<K,V> {
    static final int EMPTY = 0, OCCUPIED = 1, REMOVED = 2;
    int state = EMPTY;
    K key;
    V value;
}
