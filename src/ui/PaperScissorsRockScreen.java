package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JToggleButton;
import java.awt.SystemColor;

public class PaperScissorsRockScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaperScissorsRockScreen window = new PaperScissorsRockScreen();
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
	public PaperScissorsRockScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Paper, Scissors, Rock");
		lblTitle.setFont(new Font("Century Schoolbook L", Font.PLAIN, 25));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(12, 11, 724, 49);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblDescription = new JLabel("<html><div>The monster has asked you to play Paper, Scissors, Rock with it. Select Paper, Scissors or Rock below to see if you win this chance to attack.</div></html>");
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setFont(new Font("Century Schoolbook L", Font.PLAIN, 17));
		lblDescription.setBounds(12, 71, 724, 112);
		frame.getContentPane().add(lblDescription);
		
		JLabel lblPaperSymbol = new JLabel("");
		lblPaperSymbol.setIcon(new ImageIcon(PaperScissorsRockScreen.class.getResource("/assets/ui/img/paper.png")));
		lblPaperSymbol.setBounds(102, 220, 96, 96);
		frame.getContentPane().add(lblPaperSymbol);
		
		JLabel lblScissorsSymbol = new JLabel("");
		lblScissorsSymbol.setIcon(new ImageIcon(PaperScissorsRockScreen.class.getResource("/assets/ui/img/scissors.png")));
		lblScissorsSymbol.setBounds(327, 220, 96, 96);
		frame.getContentPane().add(lblScissorsSymbol);
		
		JLabel lblRockSymbol = new JLabel("");
		lblRockSymbol.setIcon(new ImageIcon(PaperScissorsRockScreen.class.getResource("/assets/ui/img/rock.png")));
		lblRockSymbol.setBounds(552, 220, 96, 96);
		frame.getContentPane().add(lblRockSymbol);
		
		JButton btnNewButton = new JButton("Confirm Choice");
		btnNewButton.setBackground(SystemColor.info);
		btnNewButton.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		btnNewButton.setBounds(270, 405, 202, 34);
		frame.getContentPane().add(btnNewButton);
		
		JToggleButton tglbtnPaper = new JToggleButton("Paper");
		tglbtnPaper.setFont(new Font("Dialog", Font.PLAIN, 18));
		tglbtnPaper.setBounds(102, 330, 96, 23);
		frame.getContentPane().add(tglbtnPaper);
		
		JToggleButton tglbtnScissors = new JToggleButton("Scissors");
		tglbtnScissors.setFont(new Font("Dialog", Font.BOLD, 18));
		tglbtnScissors.setBounds(327, 330, 96, 23);
		frame.getContentPane().add(tglbtnScissors);
		
		JToggleButton tglbtnRock = new JToggleButton("Rock");
		tglbtnRock.setBounds(552, 330, 96, 23);
		frame.getContentPane().add(tglbtnRock);
	}
}
