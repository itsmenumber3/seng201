package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Font;

public class FInishGameScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FInishGameScreen window = new FInishGameScreen();
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
	public FInishGameScreen() {
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
		
		JLabel lblGameResultTitle = new JLabel("You <won_or_lose>!");
		lblGameResultTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		lblGameResultTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameResultTitle.setBounds(237, 12, 248, 38);
		frame.getContentPane().add(lblGameResultTitle);
		
		JPanel panel = new JPanel();
		panel.setBounds(84, 84, 580, 320);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPlayerName = new JLabel("Player Name : <Player_Name>");
		lblPlayerName.setFont(new Font("Century Schoolbook L", Font.BOLD, 15));
		lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerName.setBounds(129, 64, 322, 22);
		panel.add(lblPlayerName);
		
		JLabel lblGameDuration = new JLabel("Game Duration : <Game_Duration>");
		lblGameDuration.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameDuration.setFont(new Font("Century Schoolbook L", Font.BOLD, 15));
		lblGameDuration.setBounds(129, 128, 322, 22);
		panel.add(lblGameDuration);
		
		JLabel lblGoldGained = new JLabel("Gold Gained: <Gold_Gained>");
		lblGoldGained.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoldGained.setFont(new Font("Century Schoolbook L", Font.BOLD, 15));
		lblGoldGained.setBounds(129, 192, 322, 30);
		panel.add(lblGoldGained);
		
		JLabel lblPointsGained = new JLabel("Points Gained : <Points_Gained>");
		lblPointsGained.setHorizontalAlignment(SwingConstants.CENTER);
		lblPointsGained.setFont(new Font("Century Schoolbook L", Font.BOLD, 15));
		lblPointsGained.setBounds(129, 256, 322, 30);
		panel.add(lblPointsGained);
	}
}
