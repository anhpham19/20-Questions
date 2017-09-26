package twentyquestion;

import datastructures.*;

/**
 * This is the controller class for the Twenty Question Game. It is responsible
 * for controlling the behavior of the question binary tree.
 * 
 * @author AP
 * @version Dec 12
 *
 */
public class TwentyQuestionController {

	// create a new binary tree
	private BinaryTree<String> tree;

	// create new binary tree node current node and previous node
	private BinaryTreeNode<String> currNode, prevNode;

	/**
	 * Constructor
	 */
	public TwentyQuestionController() {
		// read and parse xml file, putting it into a binary tree
		tree = TwentyQuestionReader.parseFile("TwentyQuestionText.xml");

		// current node is root
		currNode = tree.getRoot();

		// previous node is root
		prevNode = tree.getRoot();
	}

	/*
	 * Behavior of tree if player choose yes
	 */
	public void chooseYes() {
		// if current node is not a leaf (not an answer)
		if (!currNode.isLeaf()) {
			// assign current node to a temporary node
			BinaryTreeNode<String> tempNode = currNode;

			// new current node is now left child of it
			currNode = currNode.getLeftChild();

			// previous node is (last) current node
			prevNode = tempNode;
		}
	}

	/**
	 * Behavior of tree if player choose no
	 */
	public void chooseNo() {
		// if current node is not a leaf (not an answer)
		if (!currNode.isLeaf()) {
			// assign current node to a temporary node
			BinaryTreeNode<String> tempNode = currNode;

			// new current node is now left child of it
			currNode = currNode.getRightChild();

			// previous node is (last) current node
			prevNode = tempNode;
		}
	}

	/**
	 * Behavior of tree if restart game
	 */
	public void restartGame() {
		// current node set back to root
		currNode = tree.getRoot();
	}

	/**
	 * Get the current node
	 * 
	 * @return current node
	 */
	public BinaryTreeNode<String> getCurrNode() {
		return currNode;
	}

}