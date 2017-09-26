package datastructures;
/**
 * This class implements BinaryTree interface and set up a basic binary tree
 * with root instance. The binary tree has preorder, inorder and postorder
 * traversal. The main method sets up a dwarfs tree containg 6 dwarfs.
 * 
 * @author Anh Chau Pham
 * @version Dec 5
 *
 * @param <T>
 *            the data type
 */
public class DefaultBinaryTree<T> implements BinaryTree<T> {
	// the root of tree
	private BinaryTreeNode<T> root;

	/**
	 * Get the root node for this tree.
	 * 
	 * @return root or null if tree is empty.
	 */
	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	/**
	 * Set the root node for this tree.
	 */
	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

	/**
	 * Test if the tree is empty.
	 * 
	 * @return true if tree has no data.
	 */
	public boolean isEmpty() {
		return (root == null);
	}

	/**
	 * Get the data of this tree using inorder traversal.
	 * 
	 * @return inorder List.
	 */
	public LinkedList<T> inorderTraversal() {
		LinkedList<T> traversal = new LinkedList<T>();
		inorderTraversal(root, traversal);
		return traversal;
	}

	/**
	 * A recursive function to traverse tree starting at a node and inserts
	 * nodes in the linked list
	 * 
	 * @param node
	 *            the node that starts the traversal
	 * @param traversal
	 *            the list to be inserted nodes
	 */
	private void inorderTraversal(BinaryTreeNode<T> node,
			LinkedList<T> traversal) {
		// Base case: node is null
		if (node == null) {
			return;
		}

		// Base case: node is leaf
		else if (node.isLeaf()) {
			traversal.insertLast(node.getData());
		}

		else {
			// traverse in left-node-right order
			inorderTraversal(node.getLeftChild(), traversal);
			traversal.insertLast(node.getData());
			inorderTraversal(node.getRightChild(), traversal);
		}
	}

	/**
	 * Get the data of this tree using preorder traversal.
	 * 
	 * @return preorder List.
	 */
	public LinkedList<T> preorderTraversal() {
		LinkedList<T> traversal = new LinkedList<T>();
		preorderTraversal(root, traversal);
		return traversal;
	}

	/**
	 * A recursive function to traverse tree starting at a node and inserts
	 * nodes in the linked list
	 * 
	 * @param node
	 *            the node that starts the traversal
	 * @param traversal
	 *            the list to be inserted nodes
	 */
	private void preorderTraversal(BinaryTreeNode<T> node,
			LinkedList<T> traversal) {
		// Base case: node is null
		if (node == null) {
			return;
		}

		// Base case: node is leaf
		else if (node.isLeaf()) {
			traversal.insertLast(node.getData());
		}

		else {
			// traverse in node-left-right order
			traversal.insertLast(node.getData());
			preorderTraversal(node.getLeftChild(), traversal);
			preorderTraversal(node.getRightChild(), traversal);
		}
	}

	/**
	 * Get the data of this tree using postorder traversal.
	 * 
	 * @return postorder List.
	 */
	public LinkedList<T> postorderTraversal() {
		LinkedList<T> traversal = new LinkedList<T>();
		postorderTraversal(root, traversal);
		return traversal;
	}

	/**
	 * A recursive function to traverse tree starting at a node and inserts
	 * nodes in the linked list
	 * 
	 * @param node
	 *            the node that starts the traversal
	 * @param traversal
	 *            the list to be inserted nodes
	 */
	private void postorderTraversal(BinaryTreeNode<T> node,
			LinkedList<T> traversal) {
		// Base case: node is null
		if (node == null) {
			return;
		}

		// Base case: node is leaf
		else if (node.isLeaf()) {
			traversal.insertLast(node.getData());
		}

		else {
			// traverse in left-right-node order
			postorderTraversal(node.getLeftChild(), traversal);
			postorderTraversal(node.getRightChild(), traversal);
			traversal.insertLast(node.getData());
		}
	}

	/**
	 * Convert the inordered tree to string
	 * 
	 * @return the tree string
	 */
	public String inorderString() {
		return inorderTraversal().toString();
	}

	/**
	 * Convert the preordered tree to string
	 * 
	 * @return the tree string
	 */
	public String preorderString() {
		return preorderTraversal().toString();
	}

	/**
	 * Convert the postordered tree to string
	 * 
	 * @return the tree string
	 */
	public String postorderString() {
		return postorderTraversal().toString();
	}

	/**
	 * Create a binary tree containing 6 dwarfs and manually inserting the
	 * dwarfs into the tree.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String args[]) {
		// create the dwarfs tree
		DefaultBinaryTree<String> dwarfsTree = new DefaultBinaryTree<String>();

		// Set root as happy
		DefaultBinaryTreeNode<String> happy = new DefaultBinaryTreeNode<String>();
		happy.setData("Happy");
		dwarfsTree.setRoot(happy);

		// Doc
		DefaultBinaryTreeNode<String> doc = new DefaultBinaryTreeNode<String>();
		doc.setData("Doc");
		happy.setLeftChild(doc);

		// Bashful
		DefaultBinaryTreeNode<String> bashful = new DefaultBinaryTreeNode<String>();
		bashful.setData("Bashful");
		doc.setLeftChild(bashful);

		// Grumpy
		DefaultBinaryTreeNode<String> grumpy = new DefaultBinaryTreeNode<String>();
		grumpy.setData("Grumpy");
		doc.setRightChild(grumpy);

		// Sleepy
		DefaultBinaryTreeNode<String> sleepy = new DefaultBinaryTreeNode<String>();
		sleepy.setData("Sleepy");
		happy.setRightChild(sleepy);

		// Sneezy
		DefaultBinaryTreeNode<String> sneezy = new DefaultBinaryTreeNode<String>();
		sneezy.setData("Sneezy");
		sleepy.setRightChild(sneezy);

	}
}
