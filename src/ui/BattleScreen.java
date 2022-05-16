package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class BattleScreen {

	private JFrame frmBattle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleScreen window = new BattleScreen();
					window.frmBattle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		frmBattle = new JFrame();
		frmBattle.setTitle("Battle");
		frmBattle.setBounds(100, 100, 750, 500);
		frmBattle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
