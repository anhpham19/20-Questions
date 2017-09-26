package datastructures;
/**
 * This class implements Binary Tree Node interface and set up a binary tree
 * node with data, left children and right children.
 * 
 * @author Anh Chau Pham
 * @version Dec 5
 * @param <T>
 *            Type T data
 */
public class DefaultBinaryTreeNode<T> implements BinaryTreeNode<T> {
	// data of the node
	private T data;

	// left child and right child of the node
	private BinaryTreeNode<T> leftChild, rightChild;

	/**
	 * Get the data stored at this node.
	 * 
	 * @return Object data.
	 */
	public T getData() {
		return data;
	}

	/**
	 * Set the data stored at this node.
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Get the left child.
	 * 
	 * @return BinaryTreeNode that is left child, or null if no child.
	 */
	public BinaryTreeNode<T> getLeftChild() {
		return leftChild;
	}

	/**
	 * Get the right child.
	 * 
	 * @return BinaryTreeNode that is right child, or null if no child.
	 */
	public BinaryTreeNode<T> getRightChild() {
		return rightChild;
	}

	/**
	 * Set the left child.
	 */
	public void setLeftChild(BinaryTreeNode<T> left) {
		this.leftChild = left;
	}

	/**
	 * Set the right child.
	 */
	public void setRightChild(BinaryTreeNode<T> right) {
		this.rightChild = right;
	}

	/**
	 * Tests if this node is a leaf (has no children).
	 * 
	 * @return true if leaf node.
	 */
	public boolean isLeaf() {
		return ((leftChild == null) && (rightChild == null));
	}

}
