package unrestrictedtwentyquestion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * The view/ GUI for the Unrestricted Twenty Question game. The game will
 * display the instruction for the player, show the objects for player to choose
 * from, yes button, no button, restart button, the question asked and the
 * result object. Moreover, it will have the learn area where the user type in
 * new object to learn, new question to distinguish that object and the answer
 * Yes or No to that question. The learn button will makes the computer learn
 * the thing.
 * 
 * @author AP
 * @version Dec 12
 *
 */
public class UnrestrictedTwentyQuestionGUI extends JPanel implements
		ActionListener {
	// yes button, no button, restart button, learn button
	private JButton yesButton, noButton, restartButton, learnButton;

	// question being asked
	private JTextArea questionText;

	// the new object, new question and yes/no answer to that question
	private JTextField objLearned, quesLearned, yesNoLearned;

	// controller for the game
	private UnrestrictedTwentyQuestionController controller;

	/**
	 * Constructor
	 */
	public UnrestrictedTwentyQuestionGUI() {
		// inherit from super class JPanel
		super();
		// create new controller
		controller = new UnrestrictedTwentyQuestionController();
		// set border layout for the entire GUI
		setLayout(new GridLayout(4, 1));
		// play music
		playMusic();
		// add in instruction, result,button and learn areas in the game
		add(instructionArea());
		add(resultArea());
		add(buttonArea());
		add(learnArea());

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
	 * The learning area Display the text field where user can type in new
	 * object, the new question to distinguish that objectand and the wanted
	 * answer for that question
	 * 
	 * @return the panel
	 */
	public JPanel learnArea() {
		// create panel
		JPanel learnPanel = new JPanel();

		// set grid layout
		learnPanel.setLayout(new GridLayout(5, 1));

		// create object panel and set grid layout
		JPanel objPanel = new JPanel();
		objPanel.setLayout(new GridLayout(2, 1));

		// the instruction for user
		JLabel ansLearnText = new JLabel(" Which major are you thinking about?");

		// text field so that user can type in
		objLearned = new JTextField();

		// add text field and instruction to object panel
		objPanel.add(ansLearnText);
		objPanel.add(objLearned);

		// create question panel and set grid layout
		JPanel quesPanel = new JPanel();
		quesPanel.setLayout(new GridLayout(2, 1));

		// the instruction for user
		JLabel quesLearnText = new JLabel("  Please give me a yes/no question that would have determined your thing?");

		// text field so that user can type in
		quesLearned = new JTextField();

		// add text field and instruction to question panel
		quesPanel.add(quesLearnText);
		quesPanel.add(quesLearned);

		// create yes no panel and set grid layout
		JPanel yesNoPanel = new JPanel();
		yesNoPanel.setLayout(new GridLayout(2, 1));

		// create object panel and set grid layout
		JLabel yesNoText = new JLabel(" Is the answer to the question Yes or No? Please type Y or N");

		// text field so that user can type in
		yesNoLearned = new JTextField();

		// add text field and instruction to yes no panel
		yesNoPanel.add(yesNoText);
		yesNoPanel.add(yesNoLearned);

		// create learn button and add listener
		learnButton = new JButton("Learn this!");
		learnButton.addActionListener(this);

		// add everything in the learn panel
		learnPanel.add(objPanel);
		learnPanel.add(quesPanel);
		learnPanel.add(yesNoPanel);
		learnPanel.add(learnButton);

		// return panel
		return learnPanel;

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

		// if user click on learn button
		else if (e.getSource().equals(learnButton)) {
			// learn the input
			learnInput();
		}
	}

	/**
	 * Method to learn the input and later display it on GUI
	 */
	public void learnInput() {
		// learning only valif if we get to the (wrong) object
		if (controller.getCurrNode().isLeaf()) {
			// if no of the input in the learn area is empty
			if (!(objLearned.getText().isEmpty()
					|| quesLearned.getText().isEmpty() || yesNoLearned
					.getText().isEmpty())) {
				// get user inputs for new object, question and answer
				String objLearnedString = objLearned.getText();
				String quesLearnedString = quesLearned.getText();
				String yesNoLearnedString = yesNoLearned.getText();

				// if user wants answer to new question is Yes
				if (yesNoLearnedString.equals("Y")) {
					// controller behave accordingly
					controller
							.learnFromYes(objLearnedString, quesLearnedString);

					// show text
					showText();

					// notify user that it has been learned
					questionText.append("\nLearned!");
				}

				// if user wants answer to new question is No
				else if (yesNoLearnedString.equals("N")) {
					// controller behave accordingly
					controller.learnFromNo(objLearnedString, quesLearnedString);
					// show text
					showText();

					// notify user that it has been learned
					questionText.append("\nLearned!");
				}

				// else if the user doesn't type in a valid Yes/No input
				else {
					// warn user
					showText();
					questionText.append("\nPlease type in the valid Y or N");
				}

			}

			// if any of the inputs is empty
			else {
				// warn user
				showText();
				questionText.append("\nPlease type in valid input");
			}
		}

		// if user is impatient and want to learn before knowing the object
		// result
		else {
			// warn user
			showText();
			questionText.append("\nPlease wait until I display a major to learn");
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
			questionText
					.append("\nThanks for playing. If I guess right then yay:) But if I guess wrong, please help me learn a new major and click restart!");
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

			// start the clip
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
