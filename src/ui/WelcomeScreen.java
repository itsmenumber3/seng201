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

public class WelcomeScreen {

	private JFrame frmMonsterFighter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeScreen window = new WelcomeScreen();
					window.frmMonsterFighter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelcomeScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMonsterFighter = new JFrame();
		frmMonsterFighter.setTitle("Monster Fighter");
		frmMonsterFighter.setBounds(100, 100, 750, 500);
		frmMonsterFighter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMonsterFighter.getContentPane().setLayout(null);
		
		JLabel lblMonsterFighter = new JLabel("MONSTER FIGHTER");
		lblMonsterFighter.setForeground(Color.WHITE);
		lblMonsterFighter.setFont(new Font("Dialog", Font.BOLD, 36));
		lblMonsterFighter.setVerticalAlignment(SwingConstants.BOTTOM);
		lblMonsterFighter.setBounds(32, 12, 580, 67);
		frmMonsterFighter.getContentPane().add(lblMonsterFighter);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnStartGame.setBounds(397, 417, 317, 34);
		frmMonsterFighter.getContentPane().add(btnStartGame);
	}
}
