package ui;

import java.awt.EventQueue;

import javax.swing.*;

import main.GameEnvironment;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.management.loading.PrivateClassLoader;
import javax.swing.event.ChangeListener;

import assets.libraries.Tools;
import main.Player;

import javax.swing.event.ChangeEvent;
import java.awt.SystemColor;

public class PlayerSetupScreen {

	private JFrame window;
	private JTextField playerNameTextField;
	private GameEnvironment gameEnvironment;
	private Tools tools = new Tools();

	private Player player;

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
		player = player;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		gameEnvironment.closePlayerSetupScreen(this);
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
		lblConfigurations.setFont(new Font("Century Schoolbook L", Font.BOLD, 24));
		lblConfigurations.setBounds(51, 31, 279, 37);
		window.getContentPane().add(lblConfigurations);
		
		JLabel lblName = new JLabel("Player's name");
		lblName.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		lblName.setBounds(51, 93, 127, 20);
		window.getContentPane().add(lblName);
		
		playerNameTextField = new JTextField();
		playerNameTextField.setForeground(Color.BLACK);
		playerNameTextField.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		playerNameTextField.setColumns(10);
		playerNameTextField.setBackground(new Color(255, 255, 0));
		playerNameTextField.setBounds(51, 127, 279, 33);
		window.getContentPane().add(playerNameTextField);
		
		JLabel lblDifficulty = new JLabel("Difficulty");
		lblDifficulty.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		lblDifficulty.setBounds(51, 189, 88, 31);
		window.getContentPane().add(lblDifficulty);
		
		JLabel lblNumberOfDays = new JLabel("Number of Days");
		lblNumberOfDays.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		lblNumberOfDays.setBounds(51, 251, 152, 31);
		window.getContentPane().add(lblNumberOfDays);

		JPanel panelBackground = new JPanel();
		panelBackground.setLayout(null);
		panelBackground.setBackground(Color.WHITE);
		panelBackground.setBounds(0, 0, 748, 469);
		window.getContentPane().add(panelBackground);

		JLabel lblNoOfMembersDynamic = new JLabel("4");
		lblNoOfMembersDynamic.setBounds(51, 387, 78, 31);
		panelBackground.add(lblNoOfMembersDynamic);
		lblNoOfMembersDynamic.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		
		JSlider sliderDifficulty = new JSlider();
		sliderDifficulty.setBackground(Color.GRAY);
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
		sliderDifficulty.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		sliderDifficulty.setBounds(156, 189, 174, 50);
		window.getContentPane().add(sliderDifficulty);
		
		JLabel lblNoOfMembers = new JLabel("Max No of Monsters:");
		lblNoOfMembers.setBounds(51, 357, 200, 31);
		
		lblNoOfMembers.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		window.getContentPane().add(lblNoOfMembers);
		

		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(622, 387, 96, 61);
		panelBackground.add(btnNext);
		btnNext.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		btnNext.setBackground(SystemColor.info);
		

		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean successStatus = player.setPlayerName(lblName.getText());
				if (!successStatus) {
					JOptionPane.showMessageDialog(window, "This name is not legal...");
				}
				player.setPlayerDifficulty(sliderDifficulty.getValue());
				player.setPlayerDays(sliderNumberofDays.getValue());
				player.resetPlayerCurrentDay();
				player.resetPlayerPoint();
				player.resetPlayerGold();
				finishedWindow();
			}
		});
	}
}
