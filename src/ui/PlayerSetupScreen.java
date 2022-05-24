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
		player = inputGameEnvironment.getPlayer();
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
		window.getContentPane().setBackground(Color.WHITE);
		window.setTitle("Setup - Monster Fighter");
		window.setBounds(100, 100, 750, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
				
				JPanel panel = new JPanel();
				panel.setBackground(SystemColor.info);
				panel.setBounds(32, 46, 315, 348);
				window.getContentPane().add(panel);
				panel.setLayout(null);
				
				JLabel lblConfigurations = new JLabel("Setup");
				lblConfigurations.setBounds(12, 12, 72, 34);
				panel.add(lblConfigurations);
				lblConfigurations.setFont(new Font("Century Schoolbook L", Font.BOLD, 24));
				
				JLabel lblName = new JLabel("Player's name");
				lblName.setBounds(12, 57, 127, 20);
				panel.add(lblName);
				lblName.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
				
				JLabel lblNoOfMembersDynamic = new JLabel("4");
				lblNoOfMembersDynamic.setBounds(222, 232, 78, 31);
				panel.add(lblNoOfMembersDynamic);
				lblNoOfMembersDynamic.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
				
				playerNameTextField = new JTextField("SleazyPasta");
				playerNameTextField.setBounds(148, 51, 152, 33);
				panel.add(playerNameTextField);
				playerNameTextField.setForeground(Color.BLACK);
				playerNameTextField.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
				playerNameTextField.setColumns(10);
				playerNameTextField.setBackground(SystemColor.controlLtHighlight);
				
				JSlider sliderDifficulty = new JSlider();
				sliderDifficulty.setBounds(126, 96, 174, 50);
				panel.add(sliderDifficulty);
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
				
				JLabel lblDifficulty = new JLabel("Difficulty");
				lblDifficulty.setBounds(12, 96, 88, 31);
				panel.add(lblDifficulty);
				lblDifficulty.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
				
				JLabel lblNumberOfDays = new JLabel("Number of Days");
				lblNumberOfDays.setBounds(12, 139, 152, 31);
				panel.add(lblNumberOfDays);
				lblNumberOfDays.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
				
				JSlider sliderNumberofDays = new JSlider();
				sliderNumberofDays.setBounds(12, 170, 288, 50);
				panel.add(sliderNumberofDays);
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
				sliderNumberofDays.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
				sliderNumberofDays.setBackground(Color.GRAY);
				
				JLabel lblNoOfMembers = new JLabel("Max No of Monsters:");
				lblNoOfMembers.setBounds(12, 232, 200, 31);
				panel.add(lblNoOfMembers);
				
				lblNoOfMembers.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
				
				JButton btnNext = new JButton("Next");
				btnNext.setForeground(Color.WHITE);
				btnNext.setBounds(12, 286, 288, 50);
				panel.add(btnNext);
				btnNext.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (playerNameTextField.getText() == "" || playerNameTextField.getText() == null || playerNameTextField.getText() == "Player's name") {
							JOptionPane.showMessageDialog(window, "You need to enter a name");
							
						} else {
							boolean successStatus = player.setPlayerName(playerNameTextField.getText());
							if (!successStatus) {
								JOptionPane.showMessageDialog(window, "This name is not legal...");
							} else {
								player.setPlayerDifficulty(sliderDifficulty.getValue());
								player.setPlayerDays(sliderNumberofDays.getValue());
								player.resetPlayerCurrentDay();
								player.resetPlayerPoint();
								player.resetPlayerGold();
								finishedWindow();
							}
							
						}
						
					}
				});
				
						btnNext.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
						btnNext.setBackground(Color.DARK_GRAY);
						
						JLabel label = new JLabel("");
						label.setIcon(new ImageIcon(PlayerSetupScreen.class.getResource("/assets/ui/img/CanterburyWetlands.jpg")));
						label.setBounds(0, 0, 748, 469);
						window.getContentPane().add(label);
	}
}
