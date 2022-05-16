package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;

import main.GameEnvironment;

public class WelcomeScreen {

	private JFrame window;
	private GameEnvironment gameEnvironment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeScreen window = new WelcomeScreen();
					window.window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelcomeScreen(GameEnvironment inputGameEnvironment) {
		gameEnvironment = inputGameEnvironment;
		this.initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		gameEnvironment.closeWelcomeScreen(this);
	}

	public WelcomeScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Monster Fighter");
		window.setBounds(100, 100, 750, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblMonsterFighter = new JLabel("MONSTER FIGHTER");
		lblMonsterFighter.setForeground(Color.WHITE);
		lblMonsterFighter.setFont(new Font("Dialog", Font.BOLD, 36));
		lblMonsterFighter.setVerticalAlignment(SwingConstants.BOTTOM);
		lblMonsterFighter.setBounds(32, 12, 580, 67);
		window.getContentPane().add(lblMonsterFighter);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finishedWindow();
			}
		});
		btnStartGame.setBounds(32, 417, 547, 34);
		window.getContentPane().add(btnStartGame);
		
		JButton btnHowToPlay = new JButton("How To Play");
		btnHowToPlay.setBounds(591, 417, 120, 34);
		window.getContentPane().add(btnHowToPlay);
	}
}
