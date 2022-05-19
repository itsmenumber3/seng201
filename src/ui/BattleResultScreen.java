package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;

public class BattleResultScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleResultScreen window = new BattleResultScreen();
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
	public BattleResultScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.info);
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("You defeated <boss> and won the battle!");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Century Schoolbook L", Font.PLAIN, 19));
		lblTitle.setBounds(120, 31, 493, 35);
		frame.getContentPane().add(lblTitle);
		
		JPanel WinPanel = new JPanel();
		WinPanel.setBackground(new Color(0, 51, 153));
		WinPanel.setBounds(134, 120, 441, 300);
		frame.getContentPane().add(WinPanel);
		WinPanel.setLayout(null);
		
		JLabel lblMonsterReward = new JLabel("<html><div>You've been given $/battle_monster.sell_price/ as a reward from the NZ Government</div></html>");
		lblMonsterReward.setFont(new Font("Century Schoolbook L", Font.BOLD, 12));
		lblMonsterReward.setEnabled(false);
		lblMonsterReward.setBackground(SystemColor.info);
		lblMonsterReward.setBounds(73, 63, 293, 84);
		WinPanel.add(lblMonsterReward);
		
		JButton btnBackToMap = new JButton("Back to Map");
		btnBackToMap.setBounds(152, 231, 124, 23);
		WinPanel.add(btnBackToMap);
	}
	
}
