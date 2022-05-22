package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import assets.enums.PapersScissorsRockType;
import assets.libraries.Tools;
import battles.Battle;
import battles.challenge.PaperScissorsRock;
import battles.challenge.Quiz;
import entities.monsters.Monster;
import main.GameEnvironment;
import main.Player;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JToggleButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;

public class PaperScissorsRockScreen {

	private JFrame window;
	private GameEnvironment gameEnvironment;
	private PaperScissorsRock paperScissorsRock;
	private Battle battle;
	private Player player;
	private Monster battleMonster;
	private Monster playerMonster;
	private Tools tools = new Tools();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaperScissorsRockScreen window = new PaperScissorsRockScreen();
					window.window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PaperScissorsRockScreen(GameEnvironment inputGameEnvironment) {
		gameEnvironment = inputGameEnvironment;
		player = gameEnvironment.getPlayer();
		battle = player.getPlayerSelectedBattle();
		paperScissorsRock = (PaperScissorsRock) battle.getCurrentChallenge();
		battleMonster = battle.getBattleMonster();
		playerMonster = player.getPlayerInventory().getMonsters().get(0);
		
		initialize();
		window.setVisible(true);
	}

	public void closeWindow() {
		window.dispose();
	}

	public void finishedWindow() {
		battle.incrementChallengeCount();
		paperScissorsRock.runPaperScissorsRockResults();

		gameEnvironment.setFightOutcome(tools.runFight(player));

		gameEnvironment.closePaperScissorsRockScreen(this);

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
		window = new JFrame();
		window.setTitle("Paper Scissors Rock");
		window.setBounds(100, 100, 750, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblWhatIs = new JLabel(String.format("<html><div>Challenge #%s Paper, Scissors, Rock</div></html>", battle.getChallengeCount()+1));
		lblWhatIs.setFont(new Font("Century Schoolbook L", Font.BOLD, 18));
		lblWhatIs.setBounds(22, 22, 621, 45);
		window.getContentPane().add(lblWhatIs);
		
		JLabel lblWhatIs_2 = new JLabel(String.format("<html><div>The monster, get%s, has asked you to play Paper, Scissors, Rock with it. Select Paper, Scissors or Rock below to see if you win this chance to attack.</div></html>", battleMonster.getEntityName()));
		lblWhatIs_2.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		lblWhatIs_2.setBounds(22, 45, 296, 120);
		window.getContentPane().add(lblWhatIs_2);
		
		JPanel panelItem = new JPanel();
		panelItem.setLayout(null);
		panelItem.setOpaque(true);
		panelItem.setBackground(new Color(0, 51, 153));
		panelItem.setBounds(364, 22, 361, 120);
		window.getContentPane().add(panelItem);
		
		JLabel lblWhatIs_3 = new JLabel(String.format("<html><bold>About %s</bold><div>Health: %.2f<br>Attack Damage: %.2f<br>Resistance Ability: %.2f</div></html>", 
				battleMonster.getEntityName(),
				battleMonster.getMonsterHealthLevel(),
				battleMonster.getMonsterAttackDamage(),
				battleMonster.getMonsterResistanceAbility()));
		lblWhatIs_3.setForeground(Color.WHITE);
		lblWhatIs_3.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblWhatIs_3.setBounds(183, 32, 166, 82);
		panelItem.add(lblWhatIs_3);
		
		JLabel lblWhatIs_3_2 = new JLabel(String.format("<html><bold>About %s</bold><div>Health: %.2f<br>Attack Damage: %.2f<br>Resistance Ability: %.2f</div></html>", 
				playerMonster.getEntityName(),
				playerMonster.getMonsterHealthLevel(),
				playerMonster.getMonsterAttackDamage(),
				playerMonster.getMonsterResistanceAbility()));
		lblWhatIs_3_2.setForeground(Color.WHITE);
		lblWhatIs_3_2.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblWhatIs_3_2.setBounds(12, 32, 166, 82);
		panelItem.add(lblWhatIs_3_2);
		
		JLabel lblWhatIs_3_2_1 = new JLabel(String.format("<html><div>Gold: %d Points: %d Battle: %s</div></html>", player.getPlayerGold(), player.getPlayerPoints(), battle.getBattleName()));
		lblWhatIs_3_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblWhatIs_3_2_1.setForeground(Color.WHITE);
		lblWhatIs_3_2_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblWhatIs_3_2_1.setBounds(12, 0, 287, 38);
		panelItem.add(lblWhatIs_3_2_1);
		
		JLabel lblPaperSymbol = new JLabel("");
		lblPaperSymbol.setIcon(new ImageIcon(PaperScissorsRockScreen.class.getResource("/assets/ui/img/paper.png")));
		lblPaperSymbol.setBounds(102, 220, 96, 96);
		window.getContentPane().add(lblPaperSymbol);
		
		JLabel lblScissorsSymbol = new JLabel("");
		lblScissorsSymbol.setIcon(new ImageIcon(PaperScissorsRockScreen.class.getResource("/assets/ui/img/scissors.png")));
		lblScissorsSymbol.setBounds(327, 220, 96, 96);
		window.getContentPane().add(lblScissorsSymbol);
		
		JLabel lblRockSymbol = new JLabel("");
		lblRockSymbol.setIcon(new ImageIcon(PaperScissorsRockScreen.class.getResource("/assets/ui/img/rock.png")));
		lblRockSymbol.setBounds(552, 220, 96, 96);
		window.getContentPane().add(lblRockSymbol);
		
		JToggleButton tglbtnPaper = new JToggleButton("Paper");
		tglbtnPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				paperScissorsRock.setPlayerChoice(PapersScissorsRockType.PAPER);
				finishedWindow();
			}
		});
		tglbtnPaper.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		tglbtnPaper.setBounds(102, 330, 96, 34);
		window.getContentPane().add(tglbtnPaper);
		
		JToggleButton tglbtnScissors = new JToggleButton("Scissors");
		tglbtnScissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				paperScissorsRock.setPlayerChoice(PapersScissorsRockType.SCISSORS);
				finishedWindow();
			}
		});
		tglbtnScissors.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		tglbtnScissors.setBounds(305, 330, 118, 34);
		window.getContentPane().add(tglbtnScissors);
		
		JToggleButton tglbtnRock = new JToggleButton("Rock");
		tglbtnRock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				paperScissorsRock.setPlayerChoice(PapersScissorsRockType.ROCK);
				finishedWindow();
			}
		});
		tglbtnRock.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		tglbtnRock.setBounds(552, 330, 96, 34);
		window.getContentPane().add(tglbtnRock);
	}
}
