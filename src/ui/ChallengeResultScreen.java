package ui;

import main.GameEnvironment;
import main.Player;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import battles.Battle;
import battles.challenge.Challenge;
import entities.monsters.Monster;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JButton;

public class ChallengeResultScreen {

	private JFrame frame;
	private GameEnvironment gameEnvironment;
	private Challenge challenge;
	private Battle battle;
	private Player player;
	private Monster battleMonster;
	private ArrayList<Monster> playerMonsters;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChallengeResultScreen window = new ChallengeResultScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChallengeResultScreen(GameEnvironment inputGameEnvironment) {
		this.gameEnvironment = inputGameEnvironment;
		player = gameEnvironment.getPlayer();
		battle = player.getPlayerSelectedBattle();
		challenge = battle.getCurrentChallenge();
		battleMonster = battle.getBattleMonster();
		playerMonsters = player.getPlayerInventory().getMonsters();
		initialize();
		frame.setVisible(true);
	}

	public void closeWindow() {
		frame.dispose();
	}

	public void finishedWindow() {
		gameEnvironment.closeChallengeResultScreen(this);
	}

								 /**
	 * Create the application.
	 */
	public ChallengeResultScreen() {
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
		

		
		JLabel lblNewLabel = new JLabel(String.format("%s", message));
		lblNewLabel.setBounds(190, 22, 320, 47);
		lblNewLabel.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_Team = new JPanel();
		panel_Team.setBounds(62, 122, 285, 272);
		frame.getContentPane().add(panel_Team);
		panel_Team.setLayout(null);
		
		JLabel lblTeamTitle = new JLabel("Your team");
		lblTeamTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeamTitle.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		lblTeamTitle.setBounds(91, 12, 109, 26);
		panel_Team.add(lblTeamTitle);
		
		JLabel lblMonster1Health = new JLabel("<name> current health : <healthLevel>");
		lblMonster1Health.setFont(new Font("Century Schoolbook L", Font.PLAIN, 13));
		lblMonster1Health.setBounds(10, 45, 263, 26);
		panel_Team.add(lblMonster1Health);
		
		JLabel lblMonster2Health = new JLabel("<name> current health : <healthLevel>");
		lblMonster2Health.setFont(new Font("Century Schoolbook L", Font.PLAIN, 13));
		lblMonster2Health.setBounds(10, 105, 263, 26);
		panel_Team.add(lblMonster2Health);
		
		JLabel lblMonster3Health = new JLabel("<name> current health : <healthLevel>");
		lblMonster3Health.setFont(new Font("Century Schoolbook L", Font.PLAIN, 13));
		lblMonster3Health.setBounds(10, 164, 263, 26);
		panel_Team.add(lblMonster3Health);
		
		JLabel lblMonster4Health = new JLabel("<name> current health : <healthLevel>");
		lblMonster4Health.setFont(new Font("Century Schoolbook L", Font.PLAIN, 13));
		lblMonster4Health.setBounds(10, 223, 263, 26);
		panel_Team.add(lblMonster4Health);
		
		JPanel panel_Boss = new JPanel();
		panel_Boss.setBounds(377, 122, 244, 272);
		frame.getContentPane().add(panel_Boss);
		panel_Boss.setLayout(null);
		
		JLabel lblBossTitle = new JLabel("<location> boss");
		lblBossTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblBossTitle.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		lblBossTitle.setBounds(57, 11, 136, 39);
		panel_Boss.add(lblBossTitle);
		
		JLabel lblNewLabel_1 = new JLabel("Current health : <healthLevel>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 61, 224, 68);
		panel_Boss.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("<html><div><p>The monster is</p>\r\n<p>angry if health >80</p>\r\n<p>annoyed if health <80 and >30</p>\r\n<p>sleepy if health <30</p></div></html>");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Century Schoolbook L", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(20, 129, 201, 99);
		panel_Boss.add(lblNewLabel_2);
		
		JButton btnContinueBattle = new JButton("Continue Battle");
		btnContinueBattle.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnContinueBattle.setBounds(266, 405, 184, 37);
		frame.getContentPane().add(btnContinueBattle);
	}

}
