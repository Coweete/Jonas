package collections;

/**
 * An element with a key and a value
 * @param <K> type of key
 * @param <V> type of value
 */
class BSTNode<K,V> {
    K key;
    V value;
    BSTNode<K,V> left;
    BSTNode<K,V> right;

    /**
     * Constructor.
     * @param key the key
     * @param value the value
     * @param left the left node
     * @param right the right node
     */
    public BSTNode(K key, V value, BSTNode<K, V> left, BSTNode<K, V> right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    /**
     * Returns the height of the node
     * @return the amount of nodes on the right or left, whichever is largest
     */
    public int height() {
        int leftH = -1, rightH = -1;
        if( left != null )
            leftH = left.height();
        if( right != null )
            rightH = right.height();
        return 1 + Math.max( leftH, rightH );
    }

    /**
     * returns the size of the tree
     * @return size of the tree
     */
    public int size() {
        int leftS = 0, rightS = 0;
        if( left != null )
            leftS = left.size();
        if( right != null )
            rightS = right.size();
        return 1 + leftS + rightS;
    }

    /**
     * prints the nodes of the tree from the bottom, left values first
     */
    public void print() {
        if( left != null)
            left.print();
        System.out.println(key + ": " + value);
        if( right != null )
            right.print();
    }

    /**
     * shows the tree graphically
     */
    public void showTree() {
        //javax.swing.JOptionPane.showMessageDialog( null, new ShowBST<K,V>( this, 800,600 ), "Show tree", javax.swing.JOptionPane.PLAIN_MESSAGE );
    }
}
