package unrestrictedtwentyquestion;

import datastructures.*;

/**
 * This is the controller class for the Twenty Question Game. It is responsible
 * for controlling the behavior of the question binary tree. It also contains a
 * method that learn (update the binary tree).
 * 
 * @author AP
 * @version Dec 12
 *
 */
public class UnrestrictedTwentyQuestionController

{
	// create a new binary tree
	private BinaryTree<String> tree;

	// create new binary tree node current node and previous node
	private BinaryTreeNode<String> currNode, prevNode;

	/**
	 * Constructor
	 */
	public UnrestrictedTwentyQuestionController() {
		// read and parse xml file, putting it into a binary tree
		tree = UnrestrictedTwentyQuestionReader
				.parseFile("TwentyQuestionText.xml");

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
	 * Update the binary tree if the answer to the user's new question is "Yes"
	 * 
	 * @param obj
	 *            the new object the user want to add
	 * @param ques
	 *            the new question the user want to add
	 */
	public void learnFromYes(String obj, String ques) {
		// Create new binary tree node for the new object
		BinaryTreeNode<String> objNode = new DefaultBinaryTreeNode<String>();
		objNode.setData(obj);

		// Create new binary tree node for new question
		BinaryTreeNode<String> quesNode = new DefaultBinaryTreeNode<String>();
		quesNode.setData(ques);

		// if previous node's left child is current node
		if (prevNode.getLeftChild().equals(currNode)) {
			// get current node data which is the old object
			String oldObj = currNode.getData();

			// create tree node for the old object
			BinaryTreeNode<String> oldObjNode = new DefaultBinaryTreeNode<String>();
			oldObjNode.setData(oldObj);

			// left child of previous node is new question node
			prevNode.setLeftChild(quesNode);

			// right child of new question node is old object
			quesNode.setRightChild(oldObjNode);

			// left child of new question is new object
			quesNode.setLeftChild(objNode);
		}

		// if previous node's right child is current node
		else {
			// get current node data which is the old object
			String oldObj = currNode.getData();

			// create tree node for the old object
			BinaryTreeNode<String> oldObjNode = new DefaultBinaryTreeNode<String>();
			oldObjNode.setData(oldObj);

			// right child of previous node is new question node
			prevNode.setRightChild(quesNode);

			// right child of new question node is old object
			quesNode.setRightChild(oldObjNode);

			// left child of new question is new object
			quesNode.setLeftChild(objNode);
		}

	}

	/**
	 * Update the binary tree if the answer to the user's new question is "No"
	 * 
	 * @param obj
	 *            the new object the user want to add
	 * @param ques
	 *            the new question the user want to add
	 */
	public void learnFromNo(String obj, String ques) {
		// Create new binary tree node for the new object
		BinaryTreeNode<String> objNode = new DefaultBinaryTreeNode<String>();
		objNode.setData(obj);

		// Create new binary tree node for new question
		BinaryTreeNode<String> quesNode = new DefaultBinaryTreeNode<String>();
		quesNode.setData(ques);

		// if previous node's left child is current node
		if (prevNode.getLeftChild().equals(currNode)) {
			// get current node data which is the old object
			String oldObj = currNode.getData();
			// create tree node for the old object
			BinaryTreeNode<String> oldObjNode = new DefaultBinaryTreeNode<String>();
			oldObjNode.setData(oldObj);

			// left child of previous node is new question node
			prevNode.setLeftChild(quesNode);

			// left child of new question node is old object
			quesNode.setLeftChild(oldObjNode);
			// right child of new question is new object
			quesNode.setRightChild(objNode);
		}

		// if previous node's right child is current node
		else {
			// get current node data which is the old object
			String oldObj = currNode.getData();

			// create tree node for the old object
			BinaryTreeNode<String> oldObjNode = new DefaultBinaryTreeNode<String>();
			oldObjNode.setData(oldObj);

			// right child of previous node is new question node
			prevNode.setRightChild(quesNode);
			// left child of new question node is old object
			quesNode.setLeftChild(oldObjNode);
			// right child of new question is new object
			quesNode.setRightChild(objNode);
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
