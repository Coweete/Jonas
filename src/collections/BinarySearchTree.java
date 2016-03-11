package collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Searchtree using binary methods.
 * @param <K> key elements
 * @param <V> value elements
 * */
public class BinarySearchTree<K,V> implements SearchTree<K,V> {
    private Comparator<K> comparator;
    private BSTNode<K,V> tree;
    private int size = 0;

    /**
     *Constructor, creates a new comperator
     * */
    public BinarySearchTree() {
        comparator = new Comp();
    }

    /**
     *Constructor, puts specified comperator as the current one
     * @param comp The given comperator
     **/
    public BinarySearchTree(Comparator<K> comp) {
        comparator = comp;
    }

    /**
     *Returns the tree
     * @return the reference to the tree
     **/
    public BSTNode<K,V> root() {
        return tree;
    }

    /**
     *  Fetches the value of specified key
     *  @param key the key whos value we search
     *  @return the value of the given key
     **/
    public V get(K key) {
        BSTNode<K,V> node = find( key );
        if(node!=null)
            return node.value;
        return null;
    }
    
    /**
     * Places a key and its value into the tree
     * @param key key to be put in
     * @param value value to be placed with its key
     **/
    public void put(K key, V value) {
        tree = put(tree,key,value);
        size++;
    } 

    /**
     * Removes the key and its value from the tree
     * @param key the key to be removed
     **/
    public V remove(K key) {
        V value = get( key );
        if(value!=null) {
            tree = remove(tree,key);
            size--;
        }
        return value;
    }

    /**
     * Checks if a specified key is in the tree
     * @param key the key to be searched for
     * @return true or false depending if the key is present
     **/
    public boolean contains( K key ) {
        return find( key ) != null;
    }

    /**
     *Returns the high of the tree
     * @return height of the tree
     **/
    public int height() {
        return height( tree );
    }

    /**
     *Basic Iterator
     * @return the new Iterator
     **/
    public Iterator<V> iterator() {
        return new Iter();
    }
    
    private BSTNode<K,V> find(K key) {
        int res;
        BSTNode<K,V> node=tree;
        while( ( node != null ) && ( ( res = comparator.compare( key, node.key ) ) != 0 ) ) {
            if( res < 0 )
                node = node.left;
            else
                node = node.right;
        }
        return node;
    }
    
    private BSTNode<K,V> put(BSTNode<K,V> node, K key, V value) {
        if( node == null ) {
            node = new BSTNode<K,V>( key, value, null, null );
        } else {
            if(comparator.compare(key,node.key)<0) {
                node.left = put(node.left,key,value);
            } else if(comparator.compare(key,node.key)>0) {
                node.right = put(node.right,key,value);
            }
        }
        return node;
    }
    
    private BSTNode<K,V> remove(BSTNode<K,V> node, K key) {
        int compare = comparator.compare(key,node.key);
        if(compare==0) {
            if(node.left==null && node.right==null)
                node = null;
            else if(node.left!=null && node.right==null)
                node = node.left;
            else if(node.left==null && node.right!=null)
                node = node.right;
            else {
                BSTNode<K,V> min = getMin(node.right);
                min.right = remove(node.right,min.key);
                min.left = node.left;
                node = min;
            }
        } else if(compare<0) {
            node.left = remove(node.left,key);
        } else {
            node.right = remove(node.right,key);
        }
        return node;
    }
    
    private BSTNode<K,V> getMin(BSTNode<K,V> node) {
        while(node.left!=null)
            node = node.left;
        return node;
    }
        
    private int height( BSTNode<K,V> node ) {
        if( node == null )
            return -1;
        return 1 + Math.max( height( node.left ), height( node.right ));
    }
    
    /**
     * Returns the size of the tree
     * @return size of the tree
     **/
    public int size() {
        return size;
    }

    /**
     *Returns a list of all keys in the tree
     * @return list of keys
     **/
    public List<K> keys(){
    	ArrayList<K> list = new ArrayList<K>();
    	keys(tree, list);
        return list;
    }

    /**
     *Returns a list of all keys in the tree
     * @param node From where the search shall start
     * @param list where the keys value are stored
     **/
    private void keys(BSTNode<K,V> node, ArrayList<K> list){
        if(node!=null){
            keys(node.left, list);
            list.add(node.key);
            keys(node.right,list);
        }
    }
    /**
     * Returns the values in the tree
     * @return listed values
     **/
    public List<V> values(){
        ArrayList<V> list = new ArrayList<V>();
        values(tree, list);
        return list;
    }

    /**
     *Returns a list of all keys in the tree
     * @param node From where the search shall start
     * @param list where the values are stored
     **/
    private void values(BSTNode<K,V> node, ArrayList<V> list){
        if(node!=null){
            values(node.left, list);
            list.add(node.value);
            values(node.right,list);
        }
    }

    /**
     *Returns the first value of the tree
     * @return the first value
     **/
    public V first(){
        BSTNode<K, V> node = tree;
        if(node == null)
            return null;
        while (node.left != null)
            node = node.left;
        return node.value;
    }


    /**
     *Returns the last value of the tree
     * @return the last value
     **/
    public V last(){
        BSTNode<K, V> node = tree;
        if(node == null)
            return null;
        while (node.right != null)
            node = node.right;
        return node.value;
    }

    /**
     *Prints out the tree
     **/
    public void print() {
    	print(tree);
    }
    /**
     *Does nothing
     * @param node null
     **/
    private void print(BSTNode<K,V> node) {
    }
        
    private class Comp implements Comparator<K> {
        public int compare( K key1, K key2 ) {
            Comparable<K> k1 = ( Comparable<K> )key1;
            return k1.compareTo( key2 );
        }
    }
    
    private class Iter implements Iterator<V> {
        ArrayList<V> list = new ArrayList<V>();
        int index = -1;
        
        public Iter() {
            inOrder(tree);
        }
        
        private void inOrder(BSTNode<K,V> node) {
            if(node!=null) {
                inOrder(node.left);
                list.add(node.value);
                inOrder(node.right);
            }
        }

        /**
         *  Checks if the tree cointains more values
         *  @return true or false
         **/
        public boolean hasNext() {
            return index<list.size()-1;
        }

        /**
         * Returns the next value of the tree
         * @return the next value
         **/
        public V next() {
            if(!hasNext())
                throw new NoSuchElementException();
            index++;
            return list.get(index);
        }

        /**
         *Throws Exception
         **/
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private int recsize(BSTNode<K, V> node) {
        int count = 0;
        if(node == null)
            return 0;
        if(node.left != null)
            count += recsize(node.left);
        if(node.right != null)
            count += recsize(node.right);
        return count + 1;
    }
}
