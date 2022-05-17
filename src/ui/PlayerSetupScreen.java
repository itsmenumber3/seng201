package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.GameEnvironment;

import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.management.loading.PrivateClassLoader;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeListener;

import assets.libraries.Tools;

import javax.swing.event.ChangeEvent;

public class PlayerSetupScreen {

	private JFrame window;
	private JTextField playerNameTextField;
	private GameEnvironment gameEnvironment;
	private Tools tools = new Tools();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerSetupScreen window = new PlayerSetupScreen();
					window.window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PlayerSetupScreen(GameEnvironment inputGameEnvironment) {
		gameEnvironment = inputGameEnvironment;
		initialize();
		window.setVisible(true);
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
		window = new JFrame();
		window.setTitle("Setup - Monster Fighter");
		window.setBounds(100, 100, 750, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblConfigurations = new JLabel("Setup");
		lblConfigurations.setFont(new Font("Dialog", Font.BOLD, 24));
		lblConfigurations.setBounds(51, 31, 279, 37);
		window.getContentPane().add(lblConfigurations);
		
		JLabel lblName = new JLabel("Player's name");
		lblName.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblName.setBounds(51, 93, 127, 20);
		window.getContentPane().add(lblName);
		
		playerNameTextField = new JTextField();
		playerNameTextField.setForeground(Color.BLACK);
		playerNameTextField.setFont(new Font("Dialog", Font.PLAIN, 18));
		playerNameTextField.setColumns(10);
		playerNameTextField.setBackground(new Color(230, 230, 250));
		playerNameTextField.setBounds(51, 127, 279, 33);
		window.getContentPane().add(playerNameTextField);
		
		JLabel lblDifficulty = new JLabel("Difficulty");
		lblDifficulty.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblDifficulty.setBounds(51, 189, 88, 31);
		window.getContentPane().add(lblDifficulty);
		
		JLabel lblNumberOfDays = new JLabel("Number of Days");
		lblNumberOfDays.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNumberOfDays.setBounds(51, 251, 152, 31);
		window.getContentPane().add(lblNumberOfDays);
		
		JSlider sliderNumberofDays = new JSlider();
		sliderNumberofDays.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				
			}
		});
		sliderNumberofDays.setValue(2);
		sliderNumberofDays.setSnapToTicks(true);
		sliderNumberofDays.setPaintTicks(true);
		sliderNumberofDays.setPaintLabels(true);
		sliderNumberofDays.setOpaque(false);
		sliderNumberofDays.setMinorTickSpacing(1);
		sliderNumberofDays.setMinimum(5);
		sliderNumberofDays.setMaximum(15);
		sliderNumberofDays.setMajorTickSpacing(1);
		sliderNumberofDays.setForeground(Color.BLACK);
		sliderNumberofDays.setFont(new Font("Dialog", Font.PLAIN, 14));
		sliderNumberofDays.setBounds(51, 294, 279, 50);
		window.getContentPane().add(sliderNumberofDays);
		
		JLabel lblPhotoCover = new JLabel("");
		lblPhotoCover.setIcon(new ImageIcon(PlayerSetupScreen.class.getResource("/assets/ui/img/SetupScreen.jpg")));
		lblPhotoCover.setBounds(384, -15, 382, 569);
		window.getContentPane().add(lblPhotoCover);
		
		JLabel lblNoOfMembersDynamic = new JLabel("4");
		lblNoOfMembersDynamic.setBounds(253, 357, 78, 31);
		lblNoOfMembersDynamic.setFont(new Font("Dialog", Font.PLAIN, 18));
		window.getContentPane().add(lblNoOfMembersDynamic);
		
		JSlider sliderDifficulty = new JSlider();
		sliderDifficulty.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int numberOfMembers = tools.howManyMonstersBasedOnDifficulty(sliderDifficulty.getValue());
				lblNoOfMembersDynamic.setText(String.valueOf(numberOfMembers));
			}
		});
		sliderDifficulty.setValue(2);
		sliderDifficulty.setSnapToTicks(true);
		sliderDifficulty.setPaintTicks(true);
		sliderDifficulty.setPaintLabels(true);
		sliderDifficulty.setOpaque(false);
		sliderDifficulty.setMinorTickSpacing(1);
		sliderDifficulty.setMinimum(1);
		sliderDifficulty.setMaximum(3);
		sliderDifficulty.setMajorTickSpacing(1);
		sliderDifficulty.setForeground(Color.BLACK);
		sliderDifficulty.setFont(new Font("Dialog", Font.PLAIN, 14));
		sliderDifficulty.setBounds(156, 189, 174, 50);
		window.getContentPane().add(sliderDifficulty);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(51, 399, 279, 39);
		window.getContentPane().add(btnNext);
		
		JLabel lblNoOfMembers = new JLabel("Max No of Monsters:");
		lblNoOfMembers.setBounds(51, 357, 200, 31);
		
		lblNoOfMembers.setFont(new Font("Dialog", Font.PLAIN, 18));
		window.getContentPane().add(lblNoOfMembers);
		
		JPanel panelBackground = new JPanel();
		panelBackground.setLayout(null);
		panelBackground.setBackground(Color.WHITE);
		panelBackground.setBounds(0, 0, 440, 469);
		window.getContentPane().add(panelBackground);
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameEnvironment.player.setPlayerName(lblName.getText());
				gameEnvironment.player.setPlayerDifficulty(sliderDifficulty.getValue());
				gameEnvironment.player.setPlayerDays(sliderNumberofDays.getValue());
				gameEnvironment.player.resetPlayerCurrentDay();
				gameEnvironment.player.resetPlayerPoint();
				gameEnvironment.player.resetPlayerGold();
			}
		});
	}
}
