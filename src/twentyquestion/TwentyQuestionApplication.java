package twentyquestion;

import javax.swing.JFrame;

/**
 * Run the Application for the classic Twenty Question game. One player think of
 * an object and the other player can ask 20 questions in an effort to guess
 * what the object is. The questions can only be answered with "Yes" or "No". In
 * this program here, the computer (program) will be the asker. There are a set
 * of objects for the player to choose from initially. The computer will lose if
 * it cannot guess what the object is after 20 questions.
 * 
 * @author Anh Pham
 * @version Dec 12
 */
public class TwentyQuestionApplication {
	/**
	 * Run the program
	 * 
	 * @param args
	 *            arguments
	 */
	public static void main(String args[]) {
		// create a new frame for the game
		JFrame gameFrame = new JFrame("Anh's Awesome Twenty Question Game");

		// set size
		gameFrame.setSize(600, 800);

		// add the game GUI
		gameFrame.add(new TwentyQuestionGUI());

		// set default exit
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set visible
		gameFrame.setVisible(true);
	}
}
