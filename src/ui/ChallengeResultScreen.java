package ui;

import main.GameEnvironment;
import main.Player;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import assets.enums.ChallengeOutcomeType;
import assets.libraries.Tools;
import battles.Battle;
import battles.challenge.Challenge;
import entities.monsters.Monster;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChallengeResultScreen {

	private JFrame frame;
	private GameEnvironment gameEnvironment;
	private Challenge challenge;
	private Battle battle;
	private Player player;
	private Monster battleMonster;
	private Tools tools = new Tools();
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
	
	public String displayMonsterInformation(int inputIndex) {
		try {
			return String.format("<html><div>%s' current health: %.2f</div></html>", 
					playerMonsters.get(inputIndex).getEntityName(), 
					playerMonsters.get(inputIndex).getMonsterHealthLevel());
		} catch (ArrayIndexOutOfBoundsException e){
			return "";
		}
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
		
		System.out.println(challenge.getChallengeOutcome());
		String generatedResultMessage = tools.generateChallengeResultMessage(challenge.getChallengeOutcome());
		JLabel lblNewLabel = new JLabel(String.format("<html><div>%s</div></html>", generatedResultMessage));
		lblNewLabel.setBounds(190, 22, 320, 47);
		lblNewLabel.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_Team = new JPanel();
		panel_Team.setBounds(62, 122, 285, 272);
		frame.getContentPane().add(panel_Team);
		panel_Team.setLayout(null);
		
		JLabel lblTeamTitle = new JLabel(String.format("%s's team", player.getPlayerName()));
		lblTeamTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeamTitle.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		lblTeamTitle.setBounds(68, 12, 152, 26);
		panel_Team.add(lblTeamTitle);
		
		JLabel lblMonster1Health = new JLabel("");
		lblMonster1Health.setFont(new Font("Century Schoolbook L", Font.PLAIN, 13));
		lblMonster1Health.setBounds(10, 45, 263, 215);
		panel_Team.add(lblMonster1Health);
		
		JLabel lblMonster2Health = new JLabel("");
		lblMonster2Health.setFont(new Font("Century Schoolbook L", Font.PLAIN, 13));
		lblMonster2Health.setBounds(10, 105, 263, 26);
		panel_Team.add(lblMonster2Health);
		
		JLabel lblMonster3Health = new JLabel("");
		lblMonster3Health.setFont(new Font("Century Schoolbook L", Font.PLAIN, 13));
		lblMonster3Health.setBounds(10, 164, 263, 26);
		panel_Team.add(lblMonster3Health);
		
		JLabel lblMonster4Health = new JLabel("");
		lblMonster4Health.setFont(new Font("Century Schoolbook L", Font.PLAIN, 13));
		lblMonster4Health.setBounds(10, 223, 263, 26);
		panel_Team.add(lblMonster4Health);
		
		switch (playerMonsters.size()) {
		case 4:
			lblMonster4Health.setText(displayMonsterInformation(3));
		case 3:
			lblMonster3Health.setText(displayMonsterInformation(2));
		case 2:
			lblMonster2Health.setText(displayMonsterInformation(1));
		default:
			lblMonster1Health.setText(displayMonsterInformation(0));
		}
		
		JPanel panel_Boss = new JPanel();
		panel_Boss.setBounds(377, 122, 244, 272);
		frame.getContentPane().add(panel_Boss);
		panel_Boss.setLayout(null);
		
		JLabel lblBossTitle = new JLabel(battleMonster.getEntityName());
		lblBossTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblBossTitle.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		lblBossTitle.setBounds(20, 11, 201, 39);
		panel_Boss.add(lblBossTitle);
		
		JLabel lblNewLabel_1 = new JLabel(String.format("Current health : %.2f", battleMonster.getMonsterHealthLevel()));
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
		btnContinueBattle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finishedWindow();
			}
		});
		btnContinueBattle.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnContinueBattle.setBounds(266, 405, 184, 37);
		frame.getContentPane().add(btnContinueBattle);
	}

}
