package collections;

import java.util.Iterator;
/**
 *Interface for SearchTrees
 **/
public interface SearchTree<K,V> {
    public void put(K key, V value);
    public V remove(K key);
    public V get(K key);
    public boolean contains(K key);
    public int height();
    public Iterator<V> iterator();
    public int size();
    public List<K> keys();
    public List<V> values();
    public V first();
    public V last();
}
