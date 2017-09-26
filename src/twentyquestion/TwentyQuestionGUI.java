package twentyquestion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

/**
 * The view/ GUI for the Twenty Question game. The game will display the
 * instruction for the player, show the objects for player to choose from, yes
 * button, no button, restart button, the question asked and the result object.
 * 
 * @author AP
 * @version Dec 12
 *
 */

public class TwentyQuestionGUI extends JPanel implements ActionListener {

	// yes button, no button, restart button
	private JButton yesButton, noButton, restartButton;

	// question being asked
	private JTextArea questionText;

	// controller for the game
	private TwentyQuestionController controller;

	/**
	 * Constructor
	 */
	public TwentyQuestionGUI() {
		// inherit from super class JPanel
		super();

		// create new controller
		controller = new TwentyQuestionController();

		// set border layout for the entire GUI
		setLayout(new GridLayout(4, 1));

		// play music
		playMusic();

		// add in instruction, result and button areas in the game
		add(instructionArea());
		add(resultArea());
		add(buttonArea());

	}

	/**
	 * Instruction area Display game instruction and list of objects
	 * 
	 * @return the panel
	 */
	public JPanel instructionArea() {
		// create instruction panel
		JPanel instructionPanel = new JPanel();

		// set grid layout
		instructionPanel.setLayout(new GridLayout(2, 1));

		// create instruction and object list label
		JLabel instruction = new JLabel("<html>Confused about what to major in college? <br>This fun game will help you with that! Pick a major below and play the game!</html>");
		JLabel objectList = new JLabel("<html>Here are some majors to start with: <br> Astronomy, Marine Science, Biology, Chemistry, <br>Computer Science, Mathematics"
				+ ", Business, Economics, <br> Acting, Dancing, Journalism, Drawing,<br> Psychology, Education, History, Philosophy. <br> Pick one!! </html>");

		// add instruction and object list in panel
		instructionPanel.add(instruction);
		instructionPanel.add(objectList);

		// return panel
		return instructionPanel;
	}

	/**
	 * Result area Display question being asked and the result of the game
	 * 
	 * @return the panel
	 */
	public JPanel resultArea() {
		// create question panel
		JPanel questionPanel = new JPanel();

		// create question text area
		questionText = new JTextArea();

		// show the text/ question being asked or object
		showText();

		// not allow user to edit this text
		questionText.setEditable(false);

		// add question text in the panel
		questionPanel.add(questionText);

		// return panel
		return questionPanel;

	}

	/**
	 * Button area Display yes, no, restart buttons
	 * 
	 * @return the panel
	 */
	public JPanel buttonArea() {
		// create button panel
		JPanel buttonPanel = new JPanel();

		// set grid layout
		buttonPanel.setLayout(new GridLayout(1, 3));

		// create yes button and add listener
		yesButton = new JButton("Yes");
		yesButton.addActionListener(this);

		// create no button and add listener
		noButton = new JButton("No");
		noButton.addActionListener(this);

		// create restart button and add listener
		restartButton = new JButton("Restart");
		restartButton.addActionListener(this);

		// add yes, no and restart buttons into the panel
		buttonPanel.add(yesButton);
		buttonPanel.add(noButton);
		buttonPanel.add(restartButton);

		// return panel
		return buttonPanel;
	}

	/**
	 * Action of the buttons to interact with the user
	 * 
	 * @param e
	 *            the source of action event
	 */
	public void actionPerformed(ActionEvent e) {
		// if user click on yes button
		if (e.getSource().equals(yesButton)) {
			// game controller behaves accordingly
			controller.chooseYes();

			// show next question/ object
			showText();
		}

		// if user click on no button
		else if (e.getSource().equals(noButton)) {
			// game controller behaves accordingly
			controller.chooseNo();
			// show next question/ object
			showText();
		}

		// if user click on restart button
		else if (e.getSource().equals(restartButton)) {
			// game controller behaves accordingly
			controller.restartGame();

			// show the first question
			showText();
		}
	}

	/**
	 * Show the question or object (the binary tree node)
	 */
	public void showText() {
		// get the text of the current binary tree node's data
		String text = controller.getCurrNode().getData();

		// set the text
		questionText.setText(text);

		// if the current node is the object then game is ended, show end game
		// message
		if (controller.getCurrNode().isLeaf()) {
			questionText.append("\nAm I correct? If I am then press restart to restart the game. If not, my apology!");
		}
	}

	/**
	 * Play the music when the application starts
	 */
	public void playMusic() {
		try {
			// get the audio input stream for the audio system
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File(
							"Can't Touch This_McHammer.wav").getAbsoluteFile());

			// get clip
			Clip clip = AudioSystem.getClip();

			// open the audio input strea,
			clip.open(audioInputStream);

			// start theclip
			clip.start();

			// loop continuously until program ends
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			Thread.sleep(100);
		}

		// catch any error
		catch (Exception ex) {
			System.out.println("Error playing audio");
			ex.printStackTrace();
		}
	}

}
