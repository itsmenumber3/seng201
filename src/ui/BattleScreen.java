package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
	private String randomEventMessage;
	
	public String getRandomEventMessage() {
		return randomEventMessage;
	}

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
		
		JButton btnTravelTo = new JButton(String.format("<html><div>Travel to %s</div></html>", battle.getBattleName()));
		btnTravelTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (player.travelToPreviewBattle() == true) {
					randomEventMessage = tools.runRandomOvernightEvent(player);
					player.getPlayerInventory().sleepTime();
					JOptionPane.showMessageDialog(window, "You will now be transported to this location overnight. Your monsters are now sleeping.");
					finishedWindow(true);
					
				} else {
					JOptionPane.showMessageDialog(window, "You don't have enough fuel. Please go to shop to top up.");
				}
				
				
			}
		});
		btnTravelTo.setBounds(34, 347, 364, 43);
		panelItem.add(btnTravelTo);
		btnTravelTo.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		btnTravelTo.setBackground(SystemColor.info);
		
		JButton btnGoBackToMap = new JButton("Go back to Map");
		btnGoBackToMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				finishedWindow(false);
			}
		});
		btnGoBackToMap.setBounds(34, 402, 364, 25);
		panelItem.add(btnGoBackToMap);
		btnGoBackToMap.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		btnGoBackToMap.setBackground(SystemColor.info);
		lblPhoto.setIcon(new ImageIcon(BattleScreen.class.getResource(battle.getBattleImagePath())));
		lblPhoto.setBounds(249, 0, 499, 469);
		window.getContentPane().add(lblPhoto);
	}
}
