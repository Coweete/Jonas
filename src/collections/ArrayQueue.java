package collections;

public class ArrayQueue<E> implements Queue<E> {
    private E[] elements;
    private int size = 0;
    
    public ArrayQueue(int capacity) {
        elements = (E[])new Object[ capacity ];
    }
    
    public void enqueue( E elem ) {
        if( size==elements.length) {
            throw new QueueException("enqueue: Queue is full");
        }
        elements[ size++ ] = elem;
    }
    
    public E dequeue() {
        if(size==0) {
            throw new QueueException("dequeue: Queue is empty");
        }
        E value = elements[ 0 ];
        size--;
        for(int i=1; i<size; i++) {
        	elements[i-1] = elements[i];
        }
        elements[size] = null;
        return value;
    }
    
    public E peek() {
        if( size==0 ) {
            throw new QueueException("peek: Queue is empty");
        }
        return elements[ 0 ];
    }
    
    public boolean isEmpty() {
        return (size==0);
    }
    
    public int size() {
        return size;
    }
}
