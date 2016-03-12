package collections;

import java.util.Iterator;
import collections.ArrayList;

/**
 * Data structure that maps keys to values
 * @param <K> the key value
 * @param <V> value of the element
 * Created by Gustaf on 10/03/2016.
 */
public class HashTableCH<K,V> {
    private Bucket<K,V>[] table;
    private int size;
    private int threshold;
    private double loadfactor = 0.7;

    /**
     * Constructor, calls another constructor to set a start-size
     **/
    public HashTableCH() {
        this(11);
    }

    /**
     * Constructor, creates an array of Bucket objects with a given size
     * @param size The given starting size (Default 11)
     **/
    public HashTableCH( int size ) {
        table = (Bucket<K,V>[])new Bucket[ size ];
        threshold = (int)(loadfactor*table.length);
        for( int i = 0; i < table.length; i++ ) {
            table[ i ] = new Bucket<K,V>();
        }
    }

    private void grow() {
        Bucket<K,V>[] oldTable = table;
        table = (Bucket<K,V>[])new Bucket[ table.length*2 ];
        size = 0;
        threshold = (int)(loadfactor*table.length);
        for( int i = 0; i < table.length; i++ ) {
            table[ i ] = new Bucket<K,V>();
        }
        for(int index=0; index<oldTable.length; index++) {
            if( oldTable[index].state == Bucket.OCCUPIED )
                put( oldTable[index].key, oldTable[ index ].value);
        }
    }

    private int hashIndex( K key ) {
        int hashCode = key.hashCode();
        hashCode = hashCode % table.length;
        return ( hashCode < 0 ) ? -hashCode : hashCode;
    }

    /**
     * Puts a key and value into the map,
     * returns the former value if the key is already in the map
     * @param key the key to be put in
     * @param value the value to be accosiated with the key
     * @return Former value, or null
     **/
    public V put( K key, V value ) {
        V res = null;
        if( size >= threshold ) {
            grow();
        }
        int hashIndex = hashIndex( key ), removed = -1;
        while( table[ hashIndex ].state != Bucket.EMPTY && !key.equals(table[ hashIndex ].key) ) {
            if( removed == -1 && table[ hashIndex ].state == Bucket.REMOVED )
                removed = hashIndex;
            hashIndex++;
            if(hashIndex==table.length)
                hashIndex=0;
        }
        if( table[ hashIndex ].state == Bucket.OCCUPIED ) {
            res = table[ hashIndex ].value;
            table[ hashIndex ].value = value;
        } else {
            if( removed != -1 )
                hashIndex = removed;
            table[ hashIndex ].key = key;
            table[ hashIndex ].value = value;
            table[ hashIndex ].state = Bucket.OCCUPIED;
            size++;
        }
        return res;
    }

    /**
     * Puts all the key values in a ArrayList
     * @return the keys itteraded
     **/
    public Iterator<K> keys() {
        ArrayList<K> keys = new ArrayList<K>();
        for(int i=0; i<table.length; i++)
            if( table[ i ].state == Bucket.OCCUPIED )
                keys.add(table[ i ].key);
        return keys.iterator();
    }

    /**
     * Prints out the keys, its associated value and its current state
     **/
    public void list() {
        System.out.println( "Tabellen innehåller " + size() + " element:" );
        for(int i=0; i<table.length; i++)
            System.out.println(i+": key=" + table[ i ].key +" value=" + table[ i ].value + " state=" + table[ i ].state );
    }

    /**
     * Fetches the value associated with the given key
     * @param key the key whos value to be fetched
     * @return value of the key, or null if the value does not exist
     **/
    public V get( K key ) {
        int index = hashIndex(key);
        while(table[index].state != Bucket.EMPTY && !table[index].key.equals(key))
            index++;
        if(table[index].state == Bucket.OCCUPIED)
            return table[index].value;
        return null;
    }

    /**
     * Removes the key and value
     * @param key key to be removed
     * @return value associated with removed key, or null
     **/
    public V remove( K key ) {
        int index = hashIndex(key);
        V value;
        while (table[index].state != Bucket.EMPTY && !table[index].key.equals(key))
            index++;
        if(table[index].state == Bucket.OCCUPIED) {
            table[index].key = null;
            value = table[index].value;
            table[index].state = Bucket.REMOVED;
            size--;
            return value;
        }
        return null;
    }

    /**
     * Returns the size of the HashTable
     * @return the size
     **/
    public int size() {
        return size;
    }

    /**
     * Returns if the HashTable is empty or not
     * @return true/false
     **/
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns true/false if the given key exists in the HashTable
     * @return true/false
     **/
    public boolean containsKey(K key) {
        return get(key) != null;
    }
    /**
     * Clears the HashTable of keys and values
     **/
    public void clear() {
        Bucket<K, V> bukkit[] = (Bucket<K, V>[])new Bucket[table.length];
        table = bukkit;
        for( int i = 0; i < table.length; i++ )
            table[ i ] = new Bucket<K,V>();
        size = 0;
    }

    /**
     * Returns a ArrayList of the values contained in the HashTable
     **/
    public Iterator<V> values() {
        ArrayList<V> values = new ArrayList<>();
        for (Bucket<K, V> bucket : table) {
            if(bucket.state == Bucket.OCCUPIED)
                values.add(bucket.value);
        }
        return values.iterator();
    }
}
