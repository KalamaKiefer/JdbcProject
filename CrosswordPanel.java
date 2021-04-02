package menu;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class CrosswordPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CrosswordPanel() {
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		
		JLabel lblCrosswordGameHere = new JLabel("Crossword Game Here");
		lblCrosswordGameHere.setForeground(new Color(248, 248, 255));
		lblCrosswordGameHere.setBackground(new Color(255, 255, 255));
		lblCrosswordGameHere.setFont(new Font("Calibri", Font.PLAIN, 30));
		lblCrosswordGameHere.setBounds(189, 13, 289, 48);
		add(lblCrosswordGameHere);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(106, 237, 190, 22);
		add(textPane);
		
		JLabel lblWord = new JLabel("Word: ");
		lblWord.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		lblWord.setForeground(Color.WHITE);
		lblWord.setBackground(Color.ORANGE);
		lblWord.setBounds(12, 227, 98, 38);
		add(lblWord);
		
		JLabel lblNewLabel = new JLabel("Definition: ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		lblNewLabel.setBounds(12, 293, 125, 32);
		add(lblNewLabel);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		textPane_1.setBounds(132, 303, 164, 22);
		add(textPane_1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(12, 367, 125, 25);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(528, 367, 121, 25);
		add(btnNewButton_1);

	}
}
