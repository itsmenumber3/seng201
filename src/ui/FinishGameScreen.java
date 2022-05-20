package ui;

import main.GameEnvironment;
import main.Player;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinishGameScreen {

	private JFrame frmGameResults;
	private GameEnvironment gameEnvironment;
	private Player player;
	private boolean quitGame;
	
	public boolean getQuitGame() {
		return quitGame;
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinishGameScreen window = new FinishGameScreen();
					window.frmGameResults.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FinishGameScreen(GameEnvironment inputGameEnvironment) {
		this.gameEnvironment = inputGameEnvironment;
		player = gameEnvironment.getPlayer();
		initialize();
		frmGameResults.setVisible(true);
	}

	public void closeWindow() {
		frmGameResults.dispose();
	}

	public void finishedWindow() {
		gameEnvironment.closeFinishGameScreen(this);
	}


	/**
	 * Create the application.
	 */
	public FinishGameScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGameResults = new JFrame();
		frmGameResults.setTitle("Game results");
		frmGameResults.setBounds(100, 100, 750, 500);
		frmGameResults.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGameResults.getContentPane().setLayout(null);
		
		
		JLabel lblGameResultTitle = new JLabel("");
		if (player.hasGameBeenWon()) {
			lblGameResultTitle.setText("You won!");
		} else {
			lblGameResultTitle.setText("Game over");
		}
		lblGameResultTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		lblGameResultTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameResultTitle.setBounds(237, 12, 248, 38);
		frmGameResults.getContentPane().add(lblGameResultTitle);
		
		JPanel panel = new JPanel();
		panel.setBounds(84, 84, 580, 320);
		frmGameResults.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPlayerName = new JLabel(String.format("Player Name : %s", player.getPlayerName()));
		lblPlayerName.setFont(new Font("Century Schoolbook L", Font.BOLD, 15));
		lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerName.setBounds(129, 64, 322, 22);
		panel.add(lblPlayerName);
		
		JLabel lblGameDuration = new JLabel(String.format("Game Duration : %d", player.getPlayerCurrentDay()));
		lblGameDuration.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameDuration.setFont(new Font("Century Schoolbook L", Font.BOLD, 15));
		lblGameDuration.setBounds(129, 128, 322, 22);
		panel.add(lblGameDuration);
		
		JLabel lblGoldGained = new JLabel(String.format("Gold Gained: %d", player.getPlayerGold()));
		lblGoldGained.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoldGained.setFont(new Font("Century Schoolbook L", Font.BOLD, 15));
		lblGoldGained.setBounds(129, 192, 322, 30);
		panel.add(lblGoldGained);
		
		JLabel lblPointsGained = new JLabel(String.format("Points Gained : %d", player.getPlayerPoints()));
		lblPointsGained.setHorizontalAlignment(SwingConstants.CENTER);
		lblPointsGained.setFont(new Font("Century Schoolbook L", Font.BOLD, 15));
		lblPointsGained.setBounds(129, 256, 322, 30);
		panel.add(lblPointsGained);
		
		JButton btnQuitGame = new JButton("Quit Game");
		btnQuitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				quitGame = true;
				finishedWindow();
			}
		});
		btnQuitGame.setBounds(603, 432, 117, 25);
		frmGameResults.getContentPane().add(btnQuitGame);
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				quitGame = false;
				finishedWindow();
			}
		});
		btnRestart.setBounds(474, 432, 117, 25);
		frmGameResults.getContentPane().add(btnRestart);
	}
}
