package ui;

import battles.Battle;
import entities.monsters.Monster;
import main.GameEnvironment;
import main.Player;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BattleResultScreen {

	private JFrame frame;
	private GameEnvironment gameEnvironment;
	private Player player;
	private Battle battle;
	private Monster battleMonster;
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

	public BattleResultScreen(GameEnvironment inputGameEnvironment) {
		this.gameEnvironment = inputGameEnvironment;
		player = gameEnvironment.getPlayer();
		battle = player.getPlayerSelectedBattle();
		battleMonster = battle.getBattleMonster();
		initialize();
		frame.setVisible(true);
	}

	public void closeWindow() {
		frame.dispose();
	}

	public void finishedWindow() {
		gameEnvironment.closeBattleResultScreen(this);
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
		
		JLabel lblTitle = new JLabel(String.format("You defeated %s and won the battle!", battleMonster.getEntityName()));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Century Schoolbook L", Font.PLAIN, 19));
		lblTitle.setBounds(120, 31, 493, 35);
		frame.getContentPane().add(lblTitle);
		
		JPanel WinPanel = new JPanel();
		WinPanel.setBackground(new Color(0, 51, 153));
		WinPanel.setBounds(134, 120, 441, 300);
		frame.getContentPane().add(WinPanel);
		WinPanel.setLayout(null);
		
		JLabel lblMonsterReward = new JLabel(String.format("<html><div>You can steal all the gold coins the monster had. %d coins has been added to your gold balance</div></html>", battleMonster.getEntitySellValue()));
		lblMonsterReward.setFont(new Font("Century Schoolbook L", Font.BOLD, 12));
		lblMonsterReward.setEnabled(false);
		lblMonsterReward.setBackground(SystemColor.info);
		lblMonsterReward.setBounds(73, 63, 293, 84);
		WinPanel.add(lblMonsterReward);
		
		JButton btnBackToMap = new JButton("Back to Map");
		btnBackToMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finishedWindow();
			}
		});
		btnBackToMap.setBounds(152, 231, 124, 23);
		WinPanel.add(btnBackToMap);
	}
	
}
