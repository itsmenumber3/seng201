package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MainGameScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGameScreen window = new MainGameScreen();
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
	public MainGameScreen() {
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
		
		JLabel lblMonsterFighter = new JLabel("Monster Fighter");
		lblMonsterFighter.setBounds(72, 61, 214, 15);
		frame.getContentPane().add(lblMonsterFighter);
		
		JButton btnStartGame = new JButton("Start game");
		btnStartGame.setBounds(604, 432, 117, 25);
		frame.getContentPane().add(btnStartGame);
	}
}
