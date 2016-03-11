package collections;

/**
 * Nodes with keys and values, also contains states which tells if they
 * are empty, occupied or removed.
 * @param <K> the key value
 * @param <V> value of the element
 **/
class Bucket<K,V> {
    static final int EMPTY = 0, OCCUPIED = 1, REMOVED = 2;
    int state = EMPTY;
    K key;
    V value;
}
