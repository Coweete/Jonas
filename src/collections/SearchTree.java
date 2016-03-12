package collections;

import java.util.Iterator;
/**
 *Interface for SearchTrees
 * @param <K> key value
 * @param <V> value of the element
 **/
public interface SearchTree<K,V> {
    /**
     * Places a key and its value into the tree
     * @param key key to be put in
     * @param value value to be placed with its key
     **/
    public void put(K key, V value);

    /**
     * Removes the key and its value from the tree
     * @param key the key to be removed
     **/
    public V remove(K key);

    /**
     *  Fetches the value of specified key
     *  @param key the key whos value we search
     *  @return the value of the given key
     **/
    public V get(K key);

    /**
     * Checks if a specified key is in the tree
     * @param key the key to be searched for
     * @return true or false depending if the key is present
     **/
    public boolean contains(K key);

    /**
     *Returns the high of the tree
     * @return height of the tree
     **/
    public int height();

    /**
     *Basic Iterator
     * @return the new Iterator
     **/
    public Iterator<V> iterator();

    /**
     * Returns the size of the tree
     * @return size of the tree
     **/
    public int size();

    /**
     *Returns a list of all keys in the tree
     * @return list of keys
     **/
    public List<K> keys();

    /**
     * Returns the values in the tree
     * @return listed values
     **/
    public List<V> values();

    /**
     *Returns the first value of the tree
     * @return the first value
     **/
    public V first();

    /**
     *Returns the last value of the tree
     * @return the last value
     **/
    public V last();
}
