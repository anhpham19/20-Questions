package datastructures;
import java.util.*;

/**
 * This class implement a generic LinkedList class that has exactly one instance
 * field (head).
 * 
 * @author Anh Pham
 * @version Nov 6
 *
 * @param <T>the Type of the value in the Linked List
 * 
 */
public class LinkedList<T> {
	// the head of the linked list which is the reference to the first node in
	// the list
	private LinkedListNode<T> head;

	// the size of the linked list which is the number of nodes in the list
	private int size;

	/**
	 * Constructor for the linked list
	 */
	public LinkedList() {
		// the first node is null because there is no node in the list yet
		head = null;

		// the size of the list is 0 because there is no node in the list yet
		size = 0;
	}

	/**
	 * Get data stored in head node of list.
	 * 
	 * @return data stored in head node of list.
	 */
	public T getFirst() {
		// if there is no list then throw exception
		if (head == null)
			return null;

		// return the data of the first node
		else
			return getFirstNode().getData();
	}

	/**
	 * Get the head node of the list.
	 * 
	 * @return head node of the list.
	 */
	public LinkedListNode<T> getFirstNode() {

		// if there is no list then throw exception
		if (head == null)
			throw new NoSuchElementException();

		else
			// return the head node
			return head;
	}

	/**
	 * Get data stored in last node of list.
	 * 
	 * @return data stored in last node of list.
	 */
	public T getLast() {
		// if there is no list then throw exception
		if (head == null)
			throw new NoSuchElementException();

		// return the data of the last node
		else
			return getLastNode().getData();
	}

	/**
	 * Get the tail node of the list.
	 * 
	 * @return tail node of the list.
	 */
	public LinkedListNode<T> getLastNode() {
		// if there is no list then throw exception
		if (head == null)
			throw new NoSuchElementException();

		else {
			// starting with the head node
			LinkedListNode<T> current = head;

			// traverse through the list, while the next node of the current
			// node is not null keep getting to the next node
			while (current.getNext() != null) {
				current = current.getNext();
			}

			// return that current node
			return current;
		}
	}

	/**
	 * Insert a new node with data at the head of the list.
	 * 
	 * @param data
	 *            the data of that node inserted
	 */
	public void insertFirst(T data) {
		// create a temporary node
		LinkedListNode<T> temp = new LinkedListNode<T>();

		// set the data for the node
		temp.setData(data);

		// set the next node of this temp to be the head
		temp.setNext(head);

		// the temp is assigned in the head node
		head = temp;

		// increase the size of the list
		size++;
	}

	/**
	 * Insert a new node with data after currentNode
	 * 
	 * @param currentNode
	 *            the current node
	 * @param data
	 *            the data of the node needed to be inserted
	 */
	public void insertAfter(LinkedListNode<T> currentNode, T data) {
		// if there is no list then throw exception
		if (head == null)
			throw new NoSuchElementException();

		else {
			// the node which needed to be inserted
			LinkedListNode<T> tempInsert = new LinkedListNode<T>();

			// set the data for that node
			tempInsert.setData(data);

			// the node which is next to the current node
			LinkedListNode<T> tempNext = currentNode.getNext();

			// set the next node of the tempInsert to be the next node of the
			// current node
			tempInsert.setNext(tempNext);

			// set the next node of the current node to be the tempInsert node
			currentNode.setNext(tempInsert);

			// increase the size of the list
			size++;
		}
	}

	/**
	 * Insert a new node with data at the end of the list.
	 * 
	 * @param data
	 *            data of that node needed to be inserted
	 */
	public void insertLast(T data) {
		// create a node which needed to be inserted at the last place
		LinkedListNode<T> lastNode = new LinkedListNode<T>();

		// set data for that node
		lastNode.setData(data);

		// if there is no node then insert into the head
		if (head == null)
			insertFirst(data);

		// traverse through the list, while the next node of the current node is
		// not null keep getting to the next node
		else {
			// starting with the head node
			LinkedListNode<T> current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}

			// set the current last node
			current.setNext(lastNode);
		}
		// increase the size of the list
		size++;
	}

	/**
	 * Remove the first node
	 */
	public void deleteFirst() {
		// if there is no list then throw exception
		if (head == null)
			throw new NoSuchElementException();

		else {
			// the head of the node is now the next node to the initial head
			head = head.getNext();

			// decrease the size of the list
			size--;
		}
	}

	/**
	 * Remove the last node
	 */
	public void deleteLast() {

		// if there is no list then throw exception
		if (head == null)
			throw new NoSuchElementException();

		// traverse through the list, while the next node of the current node is
		// not null keep getting to the next node
		else {
			// starting with the head node
			LinkedListNode<T> current = head;

			while (current.getNext().getNext() != null) {
				current = current.getNext();
			}

			// set the next node to the current to null
			current.setNext(null);

			// decrease the size of the list
			size--;
		}
	}

	/**
	 * Remove node following currentNode If no node exists (i.e., currentNode is
	 * the tail), do nothing
	 * 
	 * @param currentNode
	 *            the current node
	 */
	public void deleteNext(LinkedListNode<T> currentNode) {
		// if there is no list then throw exception
		if (head == null)
			throw new NoSuchElementException();

		// if there is no current node then throw exception
		else if (currentNode == null)
			throw new NoSuchElementException();

		// if there is no next node to the current node then do nothing
		else if (currentNode.getNext() == null)
			System.out.println("Cannot remove node following currentnode");

		// set the next node of the current node to be the next next node of the
		// current node
		else {
			currentNode.setNext(currentNode.getNext().getNext());

			// decrease the size of the list
			size--;
		}
	}

	/**
	 * Return the number of nodes in this list.
	 * 
	 * @return number of nodes in this list.
	 */
	public int size() {
		return size;
	}

	/**
	 * Check if list is empty.
	 * 
	 * @return true if list contains no items.
	 */
	public boolean isEmpty() {
		return (head == null);
	}

	/**
	 * Return a String representation of the list.
	 */
	public String toString() {
		// starting with the head node
		LinkedListNode<T> node = head;

		// add the arrow
		String arrow = " > ";

		// current string of list has nothing
		String string = "";

		// if the head and next node of current node is not null, print out the
		// node string and the arrow
		if (head != null) {

			while (node.getNext() != null) {
				string += node.toString();
				string += arrow;

				// traverse through the list and keep getting to the next node
				node = node.getNext();
			}
			string += node.toString();
		}

		// return the node string
		return string;
	}

}