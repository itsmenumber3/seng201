package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

import main.GameEnvironment;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TravellingScreen {

	private JFrame window;
	private boolean stateOfProgressBar = true;
	private GameEnvironment gameEnvironment;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TravellingScreen window = new TravellingScreen();
					window.window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TravellingScreen(GameEnvironment inputGameEnvironment) {
		this.gameEnvironment = inputGameEnvironment;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		gameEnvironment.closeTravellingScreen(this);
	}
	/**
	 * Create the application.
	 */
	public TravellingScreen() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();

		window.setTitle("Travelling... Your monsters are now put on sleep.");
		window.setBounds(100, 100, 750, 520);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JProgressBar progressBar = new JProgressBar(0,100);
		progressBar.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.BLACK);
		progressBar.setBounds(12, 12, 724, 35);
		window.getContentPane().add(progressBar);
		
		JLabel lblIntroduction_1 = new JLabel("<html><div>Your monsters are being transported overnight to your next battle... They are now put on sleep, which increases health by 20%.</div></html>");
		lblIntroduction_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblIntroduction_1.setBounds(12, 59, 515, 42);
		window.getContentPane().add(lblIntroduction_1);
		
		window.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (stateOfProgressBar) {
					for (int index = 0; index <= 100; index++) {
						try {
							Thread.sleep(40);
						} catch (InterruptedException ex) {
							ex.printStackTrace();
						}
						progressBar.setValue(index);
						progressBar.update(progressBar.getGraphics());
					}
					stateOfProgressBar = false;
					finishedWindow();
				}
			}
		});
	}
}
