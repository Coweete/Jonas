package playground.seb.uml.impl;

import java.util.Iterator;
import collections.ArrayList;

/**
 * Created by Gustaf on 10/03/2016.
 */
public class HashTableCH<K,V> {
    private Bucket<K,V>[] table;
    private int size;
    private int threshold;
    private double loadfactor = 0.7;

    public HashTableCH() {
        this(11);
    }

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

    public Iterator<K> keys() {
        ArrayList<K> keys = new ArrayList<K>();
        for(int i=0; i<table.length; i++)
            if( table[ i ].state == Bucket.OCCUPIED )
                keys.add(table[ i ].key);
        return keys.iterator();
    }

    public void list() {
        System.out.println( "Tabellen innehåller " + size() + " element:" );
        for(int i=0; i<table.length; i++)
            System.out.println(i+": key=" + table[ i ].key +" value=" + table[ i ].value + " state=" + table[ i ].state );
    }

    public V get( K key ) {
        int index = hashIndex(key);
        while(table[index].state != Bucket.EMPTY && !table[index].key.equals(key))
            index++;
        if(table[index].state == Bucket.OCCUPIED)
            return table[index].value;
        return null;
    }

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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public void clear() {
        Bucket<K, V> bukkit[] = (Bucket<K, V>[])new Bucket[table.length];
        table = bukkit;
        for( int i = 0; i < table.length; i++ )
            table[ i ] = new Bucket<K,V>();
        size = 0;
    }

    public Iterator<V> values() {
        ArrayList<V> values = new ArrayList<>();
        for (Bucket<K, V> bucket : table) {
            if(bucket.state == Bucket.OCCUPIED)
                values.add(bucket.value);
        }
        return values.iterator();
    }
}
