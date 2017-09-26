package unrestrictedtwentyquestion;

import datastructures.*;

import javax.xml.parsers.*;

import org.xml.sax.SAXException;
import org.w3c.dom.*;

import java.io.*;

/**
 * This class is responsible for reading the XML file, parse it and put it into
 * the binary tree with according binary tree nodes. For this program, each
 * question and answer (object) is a node. The left node corresponding to "Yes"
 * and right node corresponding to "No".
 * 
 * @author AP
 * @version Dec 12
 *
 */
public class UnrestrictedTwentyQuestionReader {
	/**
	 * Parse XML file, put it in tree but take string as a parameter
	 * 
	 * @param fileName
	 *            the name of file
	 * @return the binary tree
	 */
	public static BinaryTree<String> parseFile(String fileName) {
		File file = new File(fileName);
		return parseFile(file);
	}

	/**
	 * Parse XML file,put it in a binary tree
	 * 
	 * @param file
	 *            the file
	 * @return binary tree
	 */
	public static BinaryTree<String> parseFile(File file) {
		try {
			// Setup XML Document Builder Factory
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();

			// set up Document Builder
			DocumentBuilder builder = factory.newDocumentBuilder();

			// create a Document object and parse XML File
			Document document = builder.parse(file);

			// return the document binary tree
			return parseTree(document);
		}

		// catch ParserConfigurationException error
		catch (ParserConfigurationException e) {
			System.err
					.println("ParserConfigurationException " + e.getMessage());
		}

		// catch SAXException error
		catch (SAXException e) {
			System.err.println("SAXException " + e.getMessage());
		}

		// catch IOException error
		catch (IOException e) {
			System.err.println("IOException " + e.getMessage());
		}

		// error
		return null;
	}

	/**
	 * Parse the whole document and put in binary tree
	 * 
	 * @param document
	 *            the document
	 * @return the parsed binary tree
	 */
	private static BinaryTree<String> parseTree(Document document) {
		// create new binary tree
		BinaryTree<String> binTree = new DefaultBinaryTree<String>();

		// get the root element
		Node treeRoot = document.getDocumentElement();

		// set the root of the binary tree to be the node parsed
		binTree.setRoot(parseNode(treeRoot));

		// return binary tree
		return binTree;
	}

	/**
	 * Parse each node and put in binary tree node, recursively
	 * 
	 * @param node
	 *            the node being parsed
	 * @return binary tree node
	 */
	private static BinaryTreeNode<String> parseNode(Node node) {
		// cast node type to element type
		Element element = (Element) node;

		// base case is when get to the answer
		if (element.getAttribute("type").equals("answer")) {
			// get child nodes
			NodeList childNodes = element.getChildNodes();

			// loop through the child nodes
			for (int i = 0; i < childNodes.getLength(); i++) {
				// pick out the element node ones
				if (childNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
					// current element is the current childnode
					Element currElement = (Element) childNodes.item(i);

					// Create a new binary tree node
					BinaryTreeNode<String> answerNode = new DefaultBinaryTreeNode<String>();

					// set the data for that node which is the valye
					answerNode.setData(currElement.getAttribute("value"));

					// return that binary tree node
					return answerNode;
				}
			}

			// error
			return null;
		}

		// recursive case is when travelling through the questions node
		else {
			// get child nodes
			NodeList childNodes = element.getChildNodes();

			// create left child node, right child node
			BinaryTreeNode<String> leftNode = null, rightNode = null;

			// the question text
			String questionText = "";

			// current element
			Element currElement;

			// loop through each child nodes
			for (int i = 0; i < childNodes.getLength(); i++) {
				// pick out the element type ones
				if (childNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
					// current element is the current child node
					currElement = (Element) childNodes.item(i);

					// if the current element is question type
					if (currElement.getNodeName().equals("question")) {
						// get its value
						questionText = currElement.getAttribute("value");
					}

					// if the current element is text type
					else if (currElement.getNodeName().equals("text")) {
						// if left binary node is null then store in the parsed
						// node
						if (leftNode == null) {
							leftNode = parseNode(currElement);
						}

						// else store parsed node in the right binary node
						else {
							rightNode = parseNode(currElement);
						}
					}
				}
			}
			// create the question node
			BinaryTreeNode<String> questionNode = new DefaultBinaryTreeNode<String>();

			// set data for question node
			questionNode.setData(questionText);

			// set left child and right child for question node
			questionNode.setLeftChild(leftNode);
			questionNode.setRightChild(rightNode);

			// return question node
			return questionNode;
		}
	}
}