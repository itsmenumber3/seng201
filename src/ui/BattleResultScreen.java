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
		
		JLabel lblTitle = new JLabel("You ... <dynamic> the battle!");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Century Schoolbook L", Font.PLAIN, 19));
		lblTitle.setBounds(175, 11, 350, 35);
		frame.getContentPane().add(lblTitle);
		
		JPanel WinPanel = new JPanel();
		WinPanel.setBackground(new Color(0, 51, 153));
		WinPanel.setBounds(59, 111, 267, 323);
		frame.getContentPane().add(WinPanel);
		WinPanel.setLayout(null);
		
		JLabel lblBeatTheMonster = new JLabel("You beat the <battle_monster>");
		lblBeatTheMonster.setEnabled(false);
		lblBeatTheMonster.setFont(new Font("Century Schoolbook L", Font.BOLD, 12));
		lblBeatTheMonster.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeatTheMonster.setBackground(SystemColor.info);
		lblBeatTheMonster.setBounds(31, 11, 226, 21);
		WinPanel.add(lblBeatTheMonster);
		
		JLabel lblMonsterReward = new JLabel("<html><div>You've been given $/battle_monster.sell_price/ as a reward from the NZ Government</div></html>");
		lblMonsterReward.setFont(new Font("Century Schoolbook L", Font.BOLD, 12));
		lblMonsterReward.setEnabled(false);
		lblMonsterReward.setBackground(SystemColor.info);
		lblMonsterReward.setBounds(56, 63, 137, 87);
		WinPanel.add(lblMonsterReward);
		
		JButton btnBackToMap = new JButton("Back to Map");
		btnBackToMap.setBounds(69, 269, 124, 23);
		WinPanel.add(btnBackToMap);
		
		JPanel LosePanel = new JPanel();
		LosePanel.setBackground(new Color(0, 51, 153));
		LosePanel.setBounds(377, 111, 267, 323);
		frame.getContentPane().add(LosePanel);
		LosePanel.setLayout(null);
		
		JLabel lblLostToTheMonster = new JLabel("You Lost to the <battle_monster>");
		lblLostToTheMonster.setEnabled(false);
		lblLostToTheMonster.setFont(new Font("Century Schoolbook L", Font.BOLD, 12));
		lblLostToTheMonster.setBounds(62, 28, 167, 23);
		LosePanel.add(lblLostToTheMonster);
		
		JLabel lblNewLabel = new JLabel("Noooooo........");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Century Schoolbook L", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(62, 79, 99, 37);
		LosePanel.add(lblNewLabel);
		
		JButton btnBackToMap1 = new JButton("Back to Map");
		btnBackToMap1.setBounds(77, 267, 123, 23);
		LosePanel.add(btnBackToMap1);
	}
	
}
