package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TravellingScreen {

	private JFrame window;
	private boolean stateOfProgressBar = true;
	private JProgressBar progressBar;
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

	/**
	 * Create the application.
	 */
	public TravellingScreen() {
		initialize();
	}
	
	public void fillProgressBar() {
		for (int index = 0; index < 100; index++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.progressBar.setValue(i);
			this.progressBar.update(this.progressBar.getGraphics());
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (stateOfProgressBar) {
					
				}
			}
		});
		window.setTitle("Travelling...");
		window.setBounds(100, 100, 750, 520);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.BLACK);
		progressBar.setBounds(12, 12, 724, 35);
		window.getContentPane().add(progressBar);
		
		JLabel lblIntroduction_1 = new JLabel("<html><div>Your monster is being transported from point A to point B...</div></html>");
		lblIntroduction_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblIntroduction_1.setBounds(12, 59, 515, 42);
		window.getContentPane().add(lblIntroduction_1);
	}
}
