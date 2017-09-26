package datastructures;
/**
 * This class implement a single LinkedList Node that has exactly two instance
 * fields (data and next).
 * 
 * @author Anh Chau Pham
 * @version Nov 6
 *
 * @param <T>
 *            the Type of the value in the Linked List
 * 
 */
public class LinkedListNode<T> {
	// the data that is hold in each node
	private T data;

	// the next node after this node
	private LinkedListNode<T> next;

	/**
	 * Set the data stored at this node.
	 * 
	 * @param data
	 *            the data stored at this node.
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Get the data stored at this node.
	 * 
	 * @return the data stored
	 */
	public T getData() {
		return data;
	}

	/**
	 * Set the next pointer to passed node.
	 * 
	 * @param node
	 *            the node which is passed in
	 */
	public void setNext(LinkedListNode<T> node) {
		this.next = node;
	}

	/**
	 * Get (pointer to) next node.
	 * 
	 * @return (pointer to) the next node
	 */
	public LinkedListNode<T> getNext() {
		return next;
	}

	/**
	 * Returns a String representation of this node.
	 */
	public String toString() {
		return data.toString();
	}
}