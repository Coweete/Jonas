package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Creates a list of elements of the type E
 * @param <E> type of object
 */

public class ArrayList<E> implements List<E> {
	private E[] elements;
	private int size;

	/**
	 * Expands the elements array to twice the size
	 */
	private void grow() {
		E[] temp = (E[])new Object[elements.length * 2];
		for (int i = 0; i < elements.length; i++) {
			temp[i] = elements[i];
		}
		elements = temp;
	}

	/**
	 * Constructor
	 */
	public ArrayList() {
		this(20);
	}

	/**
	 * Constuctor
	 * @param initialCapacity the amount of starting elements
     */
	public ArrayList(int initialCapacity) {
		initialCapacity = Math.max(1, initialCapacity);
		elements = (E[])new Object[initialCapacity];
	}

	/**
	 * adds an element to the list
	 * @param index index at which the specified element is to be inserted
	 * @param element element to be inserted
     */
	public void add(int index, E element) {
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException();
		if(size==elements.length)
			grow();
		for(int i=size; i>index; i--) {
			elements[i]=elements[i-1];
		}
		elements[index] = element;
		size++;
	}

	/**
	 * adds an element at the last position of the list
	 * @param element element to be appended to this list
     */
	public void add(E element) {
		add(size,element);
	}

	/**
	 * adds an element at the first position of the list
	 * @param element element to be inserted at the beginning of this list
     */
	public void addFirst(E element) {
		add(0, element);
	}

	/**
	 * adds an element to the last position of the list
	 * @param element element to be appended at the end of this list
     */
	public void addLast(E element) {
		add(element);
	}

	/**
	 * removes an element from the list and moves all elements to fill the "hole"
	 * @param index the index of the element to be removed
	 * @return removed element
     */
	public E remove(int index) {
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		E removedObject = elements[index];
		for (int i = index; i < size - 1; i++) {
			elements[i] = elements[i + 1];
		}
		size--;
		return removedObject;
	}

	/**
	 * Removes the first element of the list
	 * @return the removed element
     */
	public E removeFirst() {
		return remove(0);
	}

	/**
	 * removes the last element of the list
	 * @return removed element
     */
	public E removeLast() {
		return remove(size);
	}

	/**
	 * removes all elements
	 */
	public void clear() {
		E[] temp = (E[]) new Object[elements.length];
		elements = temp;
	}

	/**
	 * gets the elements at index
	 * @param index index of the element to return
	 * @return the element at index
     */
	public E get(int index) {
		if(index > size || index < 0)
			throw new IndexOutOfBoundsException();
		return elements[index];
	}

	/**
	 * sets the element at index
	 * @param index index of the element to replace
	 * @param element element to be stored at the specified position
     * @return the previous element
     */
	public E set(int index, E element) {
		if(index > size || index < 0)
			throw new IndexOutOfBoundsException();
		E prevElement = elements[index];
		elements[index] = element;
		return prevElement;
	}

	/**
	 * finds the index of the element if it exists in the list
	 * @param element element to search for
	 * @return index of element, if the element do not exist it returns -1
     */
	public int indexOf(E element) {
		for (int i = 0; i < elements.length; i++) {
			if(element.equals(elements[i]))
				return i;
		}
		return -1;
	}

	/**
	 * finds the index of the element from start position
	 * @param startIndex the search starts at position startIndex in the list
	 * @param element element to search for
     * @return index of the element, if the element do not exist it returns -1
     */
	public int indexOf(int startIndex, E element) {
		if(startIndex > size || startIndex < 0)
			throw new IndexOutOfBoundsException();

		for (int i = startIndex; i < elements.length; i++) {
			if(element.equals(elements[i]))
				return i;
		}
		return -1;
	}

	/**
	 * gets the size of the list
	 * @return the size of the list
     */
	public int size() {
		return size;
	}

	/**
	 * returns a string format of the list
	 * @return string format of the list
     */
	public String toString() {
		StringBuilder res = new StringBuilder("[ ");
		for(int i=0; i<size; i++) {
			res.append(elements[i]);
			if(i<size-1)
				res.append("; ");
		}
		res.append(" ]");
		return res.toString();
	}

	/**
	 * creates a new iterator of the list
	 * @return a new iterator
     */
	public Iterator<E> iterator() {
		return new Iter();
	}

	/**
	 * An iterator for the list
	 */
	private class Iter implements Iterator<E> {
		private int index=0;

		/**
		 * finds out if there is a next element in the list
		 * @return true if there is an element, false if it is the last element
         */
		public boolean hasNext() {
			return index<size;
		}

		/**
		 * gets the next element
		 * @return the next element
         */
		public E next() {
			if(index==size)
				throw new NoSuchElementException();
			return elements[index++];
		}

		/**
		 * removes the element
		 */
		@Deprecated
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(10);
		for(int i=10; i<100; i+=10) {
			list.add(i);
		}
		System.out.println(list);
		Iterator<Integer> numbers = list.iterator();
		while(numbers.hasNext())
			System.out.print(numbers.next()+ " ");
	}
}
