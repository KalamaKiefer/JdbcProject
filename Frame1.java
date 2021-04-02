package menu;

import java.awt.EventQueue;
import java.sql.*;
import java.util.Calendar;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.Cursor;
import java.awt.Dialog;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;

public class Frame1 {

	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.getContentPane().setLayout(null);
		
		JFrame quiz = new JFrame();
		quiz.getContentPane().setBackground(new Color(0,255,255));
		quiz.getContentPane().setLayout(null);
		quiz.setBounds(100, 100, 750, 490);
		
		JLabel lblSakaiPluginMajor = new JLabel("Laulima Study Center");
		lblSakaiPluginMajor.setBounds(91, 9, 549, 31);
		lblSakaiPluginMajor.setHorizontalAlignment(SwingConstants.CENTER);
		lblSakaiPluginMajor.setFont(new Font("Old English Text MT", Font.PLAIN, 30));
		frame.getContentPane().add(lblSakaiPluginMajor);
		
		JButton Crossword = new JButton("Crossword Game");
		Crossword.setBounds(0, 76, 191, 38);
		Crossword.setPreferredSize(new Dimension(99, 25));
		Crossword.setBorderPainted(false);
		Crossword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		CrosswordPanel obj = new CrosswordPanel();
		Crossword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				 quiz.setVisible(true);
				 
			}
		});
		Crossword.setForeground(new Color(0, 255, 255));
		Crossword.setBackground(new Color(0, 0, 0));
		Crossword.setFont(new Font("Old English Text MT", Font.PLAIN, 14));
		frame.getContentPane().add(Crossword);
		
		JButton quizbtn = new JButton("Enter Vocab");
		quizbtn.setBounds(0, 169, 191, 38);
		quizbtn.setPreferredSize(new Dimension(99, 25));
		quizbtn.setBorderPainted(false);
		quizbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
		
		
		quizbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quiz.setVisible(true);
				
				
				
				JLabel defin = new JLabel("Please Enter Your word and definition");
				defin.setBounds(91, 9, 549, 31);
				defin.setFont(new Font("Old English Text MT", Font.PLAIN, 30));
				
				
				JTextPane textPane = new JTextPane();
				textPane.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
				textPane.setBounds(132, 237, 164, 22);
				
				
				JLabel lblWord = new JLabel("Word: ");
				lblWord.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
				lblWord.setForeground(Color.WHITE);
				lblWord.setBackground(Color.ORANGE);
				lblWord.setBounds(12, 227, 98, 38);
	
				JLabel lblNewLabel = new JLabel("Definition: ");
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
				lblNewLabel.setBounds(12, 293, 125, 32);
				
				
				JTextPane textPane_1 = new JTextPane();
				textPane_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
				textPane_1.setBounds(132, 303, 164, 22);
				
				JButton submit = new JButton("Submit");
				submit.setBounds(12, 367, 121, 25);
				
				JButton seeData = new JButton("Display Words");
				seeData.setBounds(528, 367, 121, 25);
				
				

				quiz.getContentPane().add(seeData);
				quiz.getContentPane().add(lblWord);
				quiz.getContentPane().add(lblNewLabel);
				quiz.getContentPane().add(textPane_1);
				quiz.getContentPane().add(defin);
				quiz.getContentPane().add(textPane);
				quiz.getContentPane().add(submit);
				
				
				submit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				
				String db = "jdbc:mysql://localhost:3306/game";
				String  query = "INSERT INTO vocab (num, word, def) " + " values(?, ?, ?)";
				String def = textPane_1.getText();
				String word = textPane.getText() ;
				
				try {
				Connection conn = DriverManager.getConnection(db, "root", "root");
				
				int id[] = {19};
				PreparedStatement preparedStmt = conn.prepareStatement(query);
				
				preparedStmt.setInt(1, id[0]);
				preparedStmt.setString(2, word);
				preparedStmt.setString(3, def);
				
				
				preparedStmt.execute();
				
				
				}catch(Exception e1) {
					System.err.println("Got an exception!");
				    System.err.println(e1.getMessage());
				};
					} // actionPerformed 
				
				});	 // ends action listener
				seeData.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
		
						try {
							
							JFrame frame3;//creating object of second JFrame
						    DefaultTableModel defaultTableModel;//creating object of DefaultTableModel
						    JTable table;//Creating object of JTable
						    Connection connection;//Creating object of Connection class
						    Statement statement;//Creating object of Statement class
						    int flag=0;
						    
						    frame3 = new JFrame("Database Results");
					        frame3.getContentPane().setLayout(new FlowLayout());
					        frame.getContentPane().setBackground(Color.CYAN);
					        frame3.setBounds(100, 100, 750, 490);
					 
					        //Setting the properties of JTable and DefaultTableModel
					        defaultTableModel = new DefaultTableModel();
					        table = new JTable(defaultTableModel);
					        
					        table.setPreferredScrollableViewportSize(new Dimension(730, 495));
					        table.setOpaque(true);
					        table.setFillsViewportHeight(true);
					        table.setBackground(Color.CYAN);
					        frame3.getContentPane().add(new JScrollPane(table));
					        defaultTableModel.addColumn("num");
					        defaultTableModel.addColumn("word");
					        defaultTableModel.addColumn("def");
					 
					 
					 
					        try {
					         
					            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/game", "root", "root");//Crating connection with database
					            statement = connection.createStatement();  //crating statement object
					            String query = "select * from vocab;";  //Storing MySQL query in A string variable
					            ResultSet resultSet = statement.executeQuery(query);  //executing query and storing result in ResultSet
					 
					 
					            while (resultSet.next()) {
					             
					             //Retrieving details from the database and storing it in the String variables
					                int id = resultSet.getInt("num");
					                String defin = resultSet.getString("def");
					                String words = resultSet.getString("word");
					                
					                    defaultTableModel.addRow(new Object[]{id, defin, words});  //Adding row in Table
					                    frame3.setVisible(true);  //Setting the visibility of second Frame
					                    frame3.validate();
					                    
					 
					            }
					 
					            if (flag == 0) {
					                JOptionPane.showMessageDialog(null, "No Such Username Found");//When invalid username is entered
					            }
					 
					 
					        } catch (SQLException throwables) {
					            throwables.printStackTrace();
					        }
							
						}catch(Exception e2) {
							
							
						}
						
						
					}
				});
				
			}
			
			
			
			
			
		}); //ends vocab screen(button clicked)
		
		
		
	
		
		quizbtn.setForeground(new Color(0, 255, 255));
		quizbtn.setBackground(new Color(0, 0, 0));
		quizbtn.setFont(new Font("Old English Text MT", Font.PLAIN, 14));
		frame.getContentPane().add(quizbtn);
		
		JButton btnNewButton = new JButton("S");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		try {
		BufferedImage img = null;
		img = ImageIO.read(new File("C:\\Users\\kalam\\Documents\\settings.png"));
		Image img1 = img.getScaledInstance(btnNewButton.getWidth(), btnNewButton.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon d = new ImageIcon(img1);
		btnNewButton.setIcon(new ImageIcon(Frame1.class.getResource("/menu/settings.png")));
		}catch(Exception e) {
			
		}
		btnNewButton.setBounds(660, 371, 60, 59);
		frame.getContentPane().add(btnNewButton);
		
		JButton flashCards = new JButton("Flashcards Test");
		flashCards.setForeground(new Color(0, 255, 255));
		flashCards.setBackground(new Color(0, 0, 0));
		flashCards.setFont(new Font("Old English Text MT", Font.PLAIN, 14));
		flashCards.setBounds(0, 256, 191, 38);
		frame.getContentPane().add(flashCards);
		
		
		
		
		frame.setBounds(100, 100, 750, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
