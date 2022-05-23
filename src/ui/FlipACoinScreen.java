package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import assets.libraries.Tools;
import battles.Battle;
import battles.challenge.FlipACoin;
import battles.challenge.Quiz;
import entities.monsters.Monster;
import main.GameEnvironment;
import main.Player;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FlipACoinScreen {

	private JFrame frame;
	private GameEnvironment gameEnvironment;
	private FlipACoin flipACoin;
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
					FlipACoinScreen window = new FlipACoinScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FlipACoinScreen(GameEnvironment inputGameEnvironment) {
		gameEnvironment = inputGameEnvironment;
		player = gameEnvironment.getPlayer();
		battle = player.getPlayerSelectedBattle();
		flipACoin = (FlipACoin) battle.getCurrentChallenge();
		battleMonster = battle.getBattleMonster();
		playerMonster = player.getPlayerInventory().getMonsters().get(0);
		
		initialize();
		frame.setVisible(true);
	}

	public void closeWindow() {
		frame.dispose();
	}

	public void finishedWindow() {
		battle.incrementChallengeCount();
		flipACoin.runFlipACoinResults();
		battle.setFightOutcome(tools.runFight(player));
		gameEnvironment.closeFlipACoinScreen(this);
	}

	/**
	 * Create the application.
	 */
	public FlipACoinScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (gameEnvironment.getRandomEventMessage() != "") {
					JOptionPane.showMessageDialog(frame, gameEnvironment.getRandomEventMessage());
					gameEnvironment.resetRandomEventMessage();
				}
			}
		});
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblselectHeadsOr = new JLabel("");
		lblselectHeadsOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblselectHeadsOr.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		lblselectHeadsOr.setBounds(77, 133, 606, 90);
		frame.getContentPane().add(lblselectHeadsOr);
		
		JLabel lblTailSymbol = new JLabel("");
		lblTailSymbol.setIcon(new ImageIcon(FlipACoinScreen.class.getResource("/assets/ui/img/Tails.jpg")));
		lblTailSymbol.setBounds(207, 235, 96, 96);
		frame.getContentPane().add(lblTailSymbol);
		
		JLabel lblHeadsSymbol = new JLabel("");
		lblHeadsSymbol.setIcon(new ImageIcon(FlipACoinScreen.class.getResource("/assets/ui/img/Heads.jpg")));
		lblHeadsSymbol.setBounds(457, 235, 96, 96);
		frame.getContentPane().add(lblHeadsSymbol);
		
		JToggleButton tglbtnHeads = new JToggleButton("Heads");
		tglbtnHeads.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flipACoin.setIsPlayerChoosingHead(true);
				finishedWindow();
			}
		});
		tglbtnHeads.setBackground(Color.YELLOW);
		tglbtnHeads.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		tglbtnHeads.setBounds(457, 356, 96, 31);
		frame.getContentPane().add(tglbtnHeads);
		
		JToggleButton tglbtnTails = new JToggleButton("Tails");
		tglbtnTails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flipACoin.setIsPlayerChoosingHead(false);
				finishedWindow();
			}
		});
		tglbtnTails.setBackground(SystemColor.info);
		tglbtnTails.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		tglbtnTails.setBounds(207, 356, 96, 31);
		frame.getContentPane().add(tglbtnTails);
		
		JPanel panelItem = new JPanel();
		panelItem.setLayout(null);
		panelItem.setOpaque(true);
		panelItem.setBackground(new Color(0, 51, 153));
		panelItem.setBounds(375, 11, 361, 120);
		frame.getContentPane().add(panelItem);
		
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
		
		JLabel lblWhatIs_3_2_1 = new JLabel(String.format("<html><div>Gold: 0 Points: 0 Battle: %s</div></html>",battle.getBattleName()));
		lblWhatIs_3_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblWhatIs_3_2_1.setForeground(Color.WHITE);
		lblWhatIs_3_2_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblWhatIs_3_2_1.setBounds(12, 0, 287, 38);
		panelItem.add(lblWhatIs_3_2_1);
		
		JLabel lblchallengeFlip = new JLabel(String.format("<html><div>Challenge #%d Flip A Coin</div></html>",  battle.getChallengeCount() + 1));
		lblchallengeFlip.setFont(new Font("Century Schoolbook L", Font.BOLD, 18));
		lblchallengeFlip.setBounds(25, 12, 621, 45);
		frame.getContentPane().add(lblchallengeFlip);
		
		JLabel lblWhatIs_2 = new JLabel("<html><div>Select Heads or Tails below to see if you win this chance to attack</div></html>");
		lblWhatIs_2.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		lblWhatIs_2.setBounds(25, 35, 296, 120);
		frame.getContentPane().add(lblWhatIs_2);
	}

}
