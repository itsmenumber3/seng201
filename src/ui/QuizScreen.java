package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import main.GameEnvironment;
import main.Player;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import battles.Battle;
import battles.challenge.Quiz;
import entities.monsters.Monster;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;

public class QuizScreen {

	private JFrame window;
	private GameEnvironment gameEnvironment;
	private Quiz quiz;
	private Battle battle;
	private Player player;
	private Monster battleMonster;
	private Monster playerMonster;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizScreen window = new QuizScreen();
					window.window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public QuizScreen(GameEnvironment inputGameEnvironment) {
		gameEnvironment = inputGameEnvironment;
		player = gameEnvironment.getPlayer();
		battle = player.getPlayerSelectedBattle();
		quiz = (Quiz) battle.getCurrentChallenge();
		battleMonster = battle.getBattleMonster();
		playerMonster = player.getPlayerInventory().getMonsters().get(0);
		
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		gameEnvironment.closeQuizScreen(this);
	}

	/**
	 * Create the application.
	 */
	public QuizScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Monster Quiz");
		window.setBounds(100, 100, 708, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblWhatIs = new JLabel(String.format("<html><div>Challenge #%d</div></html>", battle.getChallengeCount() + 1));
		lblWhatIs.setFont(new Font("Century Schoolbook L", Font.BOLD, 18));
		lblWhatIs.setBounds(31, 17, 253, 45);
		window.getContentPane().add(lblWhatIs);
		
		
		
		JLabel lblWhatIs_2 = new JLabel(String.format("<html><div>The monster, %s, has set you a quiz challenge. Get it right, and you can attack the monster. Get it wrong, and the monster attacks you.</div></html>", 
				battleMonster.getEntityName()));
		lblWhatIs_2.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		lblWhatIs_2.setBounds(31, 40, 296, 120);
		window.getContentPane().add(lblWhatIs_2);
		
		JPanel panelItem = new JPanel();
		panelItem.setLayout(null);
		panelItem.setOpaque(true);
		panelItem.setBackground(new Color(0, 51, 153));
		panelItem.setBounds(325, 21, 361, 120);
		window.getContentPane().add(panelItem);
		
		
		
		JLabel lblWhatIs_3 = new JLabel(String.format("<html><bold>About %s</bold><div>Health: %.2f<br>Attack Damage: %.2f<br>Resistance Ability: %.2f</div></html>", 
				battleMonster.getEntityName(),
				battleMonster.getMonsterHealthLevel(),
				battleMonster.getMonsterAttackDamage(),
				battleMonster.getMonsterResistanceAbility()));
		lblWhatIs_3.setForeground(Color.WHITE);
		lblWhatIs_3.setBounds(183, 32, 166, 82);
		panelItem.add(lblWhatIs_3);
		lblWhatIs_3.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		
		
		JLabel lblWhatIs_3_2 = new JLabel(String.format("<html><bold>About %s</bold><div>Health: %.2f<br>Attack Damage: %.2f<br>Resistance Ability: %.2f</div></html>", 
				playerMonster.getEntityName(),
				playerMonster.getMonsterHealthLevel(),
				playerMonster.getMonsterAttackDamage(),
				playerMonster.getMonsterResistanceAbility()));
		lblWhatIs_3_2.setForeground(Color.WHITE);
		lblWhatIs_3_2.setBounds(12, 32, 166, 82);
		panelItem.add(lblWhatIs_3_2);
		lblWhatIs_3_2.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		
		JLabel lblWhatIs_3_2_1 = new JLabel("<html><div>Gold: 0 Points: 0 Battle: Farewell Spit</div></html>");
		lblWhatIs_3_2_1.setForeground(Color.WHITE);
		lblWhatIs_3_2_1.setBounds(12, 0, 287, 38);
		panelItem.add(lblWhatIs_3_2_1);
		lblWhatIs_3_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblWhatIs_3_2_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		
		
		JLabel lblWhatIs_1 = new JLabel(String.format("<html><div style='text-align: center;'>%s</div></html>", quiz.getQuizQuestion()));
		lblWhatIs_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhatIs_1.setFont(new Font("Century Schoolbook L", Font.BOLD, 25));
		lblWhatIs_1.setBounds(31, 189, 655, 95);
		window.getContentPane().add(lblWhatIs_1);
		
		JButton btnJacindaArdern = new JButton(quiz.getQuizChoices()[0]);
		btnJacindaArdern.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnJacindaArdern.setBounds(12, 339, 166, 106);
		window.getContentPane().add(btnJacindaArdern);
		
		JButton btnJudithCollins = new JButton(quiz.getQuizChoices()[1]);
		btnJudithCollins.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnJudithCollins.setBounds(181, 339, 166, 106);
		window.getContentPane().add(btnJudithCollins);
		
		JButton btnJacindaArdern_1_1 = new JButton(quiz.getQuizChoices()[2]);
		btnJacindaArdern_1_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnJacindaArdern_1_1.setBounds(350, 339, 166, 106);
		window.getContentPane().add(btnJacindaArdern_1_1);
		
		JButton btnJacindaArdern_1_1_1 = new JButton(quiz.getQuizChoices()[3]);
		btnJacindaArdern_1_1_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnJacindaArdern_1_1_1.setBounds(520, 339, 166, 106);
		window.getContentPane().add(btnJacindaArdern_1_1_1);
	}
}
