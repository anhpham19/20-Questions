package unrestrictedtwentyquestion;

import javax.swing.JFrame;

/**
 * Run the Application for the Unrestricted Twenty Question game. But instead of
 * choosing from a prespecified list objetcs, the user is allowed to think of an
 * object that is no on the pre-specified list. If the computer gets to a point
 * in the tree where there is only one thing remaining, and guesses incorrectly
 * (because the thing the user is thinking of is unknown), the program will
 * learn the thing. Then, for the next rounds the learned things are included in
 * the list of objects. The user will have to specify the object, question that
 * would have determined object and answer for that question.
 * 
 * @author AP
 * @version Dec 12
 *
 */
public class UnrestrictedTwentyQuestionApplication {
	/**
	 * Run the program
	 * 
	 * @param args
	 *            arguments
	 */
	public static void main(String args[]) {
		// create a new frame for the game
		JFrame gameFrame = new JFrame(
				"Anh's Awesome Unrestricted Twenty Question Game");

		// set size
		gameFrame.setSize(800, 930);

		// add the game GUI
		gameFrame.add(new UnrestrictedTwentyQuestionGUI());

		// set default exit
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set visible
		gameFrame.setVisible(true);

	}
}
