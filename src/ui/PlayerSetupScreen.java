package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JButton;

public class PlayerSetupScreen {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerSetupScreen window = new PlayerSetupScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlayerSetupScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(46, 49, 70, 15);
		frame.getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setBounds(120, 47, 114, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JSlider slider = new JSlider();
		slider.setValue(2);
		slider.setMaximum(3);
		slider.setMinimum(1);
		slider.setBounds(120, 91, 200, 16);
		frame.getContentPane().add(slider);
		
		JLabel lblDifficulty = new JLabel("Difficulty");
		lblDifficulty.setBounds(46, 92, 70, 15);
		frame.getContentPane().add(lblDifficulty);
		
		JLabel lblHowManyDays = new JLabel("How many days");
		lblHowManyDays.setBounds(46, 133, 140, 15);
		frame.getContentPane().add(lblHowManyDays);
		
		JSlider slider_1 = new JSlider();
		slider_1.setValue(5);
		slider_1.setMinimum(5);
		slider_1.setMaximum(15);
		slider_1.setBounds(176, 132, 200, 16);
		frame.getContentPane().add(slider_1);
		
		JButton btnSave = new JButton("Confirm configuration");
		btnSave.setBounds(491, 418, 218, 25);
		frame.getContentPane().add(btnSave);
	}
}
