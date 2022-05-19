package ui;

import main.GameEnvironment;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class HowToPlayScreen {

	private JFrame frame;
	private GameEnvironment gameEnvironment;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HowToPlayScreen window = new HowToPlayScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HowToPlayScreen(GameEnvironment inputGameEnvironment) {
		this.gameEnvironment = inputGameEnvironment;
		initialize();
		frame.setVisible(true);
	}

	public void closeWindow() {
		frame.dispose();
	}

	public void finishedWindow() {
		gameEnvironment.closeHowToPlayScreen(this);
	}

	/**
	 * Create the application.
	 */
	public HowToPlayScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
