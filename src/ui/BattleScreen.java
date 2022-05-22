package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import assets.libraries.Tools;

import battles.Battle;
import main.GameEnvironment;
import main.Player;

import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BattleScreen {

	private JFrame window;
	private GameEnvironment gameEnvironment;
	private final Tools tools = new Tools();
	private final JLabel lblPhoto = new JLabel("");
	private Player player;
	private Battle battle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleScreen window = new BattleScreen();
					window.window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public BattleScreen(GameEnvironment inputGameEnvironment) {
		this.gameEnvironment = inputGameEnvironment;
		player = gameEnvironment.getPlayer();
		battle = player.getPlayerPreviewBattle();
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow(boolean isPlayerBattling) {
		gameEnvironment.closeBattleScreen(this, isPlayerBattling);
	}

	/**
	 * Create the application.
	 */
	public BattleScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Battle");
		window.setBounds(100, 100, 750, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JPanel panelItem = new JPanel();
		panelItem.setLayout(null);
		panelItem.setBackground(new Color(0, 51, 153));
		panelItem.setBounds(0, 0, 434, 469);
		window.getContentPane().add(panelItem);
		
		JLabel lblBattleName = new JLabel(String.format("<html><div>%s</div></html>", battle.getBattleName()));
		lblBattleName.setBounds(34, 26, 329, 77);
		panelItem.add(lblBattleName);
		lblBattleName.setForeground(Color.WHITE);
		lblBattleName.setFont(new Font("Century Schoolbook L", Font.BOLD, 24));
		
		JLabel lblBattleDescription = new JLabel(String.format("<html><div>%s</div></html>", tools.makeBattleDescription(battle)));
		lblBattleDescription.setBounds(34, 89, 329, 213);
		panelItem.add(lblBattleDescription);
		lblBattleDescription.setForeground(Color.WHITE);
		lblBattleDescription.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		
		JButton btnFarewellSpit_1_1 = new JButton(String.format("<html><div>Travel to %s</div></html>", battle.getBattleName()));
		btnFarewellSpit_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finishedWindow(true);
			}
		});
		btnFarewellSpit_1_1.setBounds(34, 347, 364, 43);
		panelItem.add(btnFarewellSpit_1_1);
		btnFarewellSpit_1_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		btnFarewellSpit_1_1.setBackground(SystemColor.info);
		
		JButton btnFarewellSpit_1 = new JButton("Go back to Map");
		btnFarewellSpit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				finishedWindow(false);
			}
		});
		btnFarewellSpit_1.setBounds(34, 402, 364, 25);
		panelItem.add(btnFarewellSpit_1);
		btnFarewellSpit_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		btnFarewellSpit_1.setBackground(SystemColor.info);
		lblPhoto.setIcon(new ImageIcon(BattleScreen.class.getResource(battle.getBattleImagePath())));
		lblPhoto.setBounds(239, 0, 499, 469);
		window.getContentPane().add(lblPhoto);
	}
}
