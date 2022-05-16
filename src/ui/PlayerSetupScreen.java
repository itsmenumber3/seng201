package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class PlayerSetupScreen {

	private JFrame frmSetup;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerSetupScreen window = new PlayerSetupScreen();
					window.frmSetup.setVisible(true);
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
		frmSetup = new JFrame();
		frmSetup.setTitle("Setup");
		frmSetup.setBounds(100, 100, 750, 500);
		frmSetup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSetup.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Player's name");
		lblName.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblName.setBounds(49, 93, 127, 20);
		frmSetup.getContentPane().add(lblName);
		
		JLabel lblDifficulty = new JLabel("Difficulty");
		lblDifficulty.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblDifficulty.setBounds(49, 189, 127, 31);
		frmSetup.getContentPane().add(lblDifficulty);
		
		JButton btnSave = new JButton("Next");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnSave.setBounds(253, 372, 75, 50);
		frmSetup.getContentPane().add(btnSave);
		
		JLabel lblConfigurations = new JLabel("Setup");
		lblConfigurations.setFont(new Font("Dialog", Font.BOLD, 24));
		lblConfigurations.setBounds(49, 31, 458, 37);
		frmSetup.getContentPane().add(lblConfigurations);
		
		JSlider sliderCrewCount = new JSlider();
		sliderCrewCount.setValue(2);
		sliderCrewCount.setSnapToTicks(true);
		sliderCrewCount.setPaintTicks(true);
		sliderCrewCount.setPaintLabels(true);
		sliderCrewCount.setOpaque(false);
		sliderCrewCount.setMinorTickSpacing(1);
		sliderCrewCount.setMinimum(1);
		sliderCrewCount.setMaximum(3);
		sliderCrewCount.setMajorTickSpacing(1);
		sliderCrewCount.setForeground(Color.BLACK);
		sliderCrewCount.setFont(new Font("Dialog", Font.PLAIN, 14));
		sliderCrewCount.setBounds(156, 189, 172, 50);
		frmSetup.getContentPane().add(sliderCrewCount);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBackground(new Color(230, 230, 250));
		textField.setBounds(49, 127, 278, 33);
		frmSetup.getContentPane().add(textField);
		
		JLabel lblNumberOfDays = new JLabel("Number of Days");
		lblNumberOfDays.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNumberOfDays.setBounds(49, 251, 200, 31);
		frmSetup.getContentPane().add(lblNumberOfDays);
		
		JSlider sliderCrewCount_1 = new JSlider();
		sliderCrewCount_1.setValue(2);
		sliderCrewCount_1.setSnapToTicks(true);
		sliderCrewCount_1.setPaintTicks(true);
		sliderCrewCount_1.setPaintLabels(true);
		sliderCrewCount_1.setOpaque(false);
		sliderCrewCount_1.setMinorTickSpacing(1);
		sliderCrewCount_1.setMinimum(5);
		sliderCrewCount_1.setMaximum(15);
		sliderCrewCount_1.setMajorTickSpacing(1);
		sliderCrewCount_1.setForeground(Color.BLACK);
		sliderCrewCount_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		sliderCrewCount_1.setBounds(49, 294, 279, 50);
		frmSetup.getContentPane().add(sliderCrewCount_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PlayerSetupScreen.class.getResource("/assets/ui/img/SetupScreen.jpg")));
		lblNewLabel.setBounds(384, -15, 382, 569);
		frmSetup.getContentPane().add(lblNewLabel);
		
		JPanel panelBackground = new JPanel();
		panelBackground.setLayout(null);
		panelBackground.setBackground(Color.WHITE);
		panelBackground.setBounds(0, 0, 440, 469);
		frmSetup.getContentPane().add(panelBackground);
		
		JLabel lblNoOfMembers = new JLabel("Max No of Monsters:");
		lblNoOfMembers.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNoOfMembers.setBounds(49, 369, 200, 31);
		panelBackground.add(lblNoOfMembers);
		
		JLabel lblNoOfMembers_1 = new JLabel("4");
		lblNoOfMembers_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNoOfMembers_1.setBounds(49, 398, 200, 31);
		panelBackground.add(lblNoOfMembers_1);
	}
}
