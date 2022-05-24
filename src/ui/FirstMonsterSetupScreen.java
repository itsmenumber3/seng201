package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;

import assets.libraries.Tools;
import entities.monsters.Monster;
import main.GameEnvironment;
import main.Inventory;
import main.Player;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class FirstMonsterSetupScreen {

	private JFrame window;
	private JTextField textFieldMonsterName;
	private GameEnvironment gameEnvironment;
	private Tools tools = new Tools();
	private ArrayList<Monster> monsters;
	private Inventory inventory;
	private Monster selectedMonster;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstMonsterSetupScreen window = new FirstMonsterSetupScreen();
					window.window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public FirstMonsterSetupScreen(GameEnvironment inputGameEnvironment) {
		gameEnvironment = inputGameEnvironment;
		inventory = gameEnvironment.getPlayer().getPlayerInventory();
		monsters = tools.generateManyRandomMonsters(gameEnvironment.getPlayer(), 4);
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		gameEnvironment.closeFirstMonsterSetupScreen(this);
	}

	/**
	 * Create the application.
	 */
	public FirstMonsterSetupScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.getContentPane().setBackground(SystemColor.info);
		window.setTitle("Pick your first monster");
		window.setBounds(100, 100, 750, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblPickYourFirst = new JLabel("Pick your first monster");
		lblPickYourFirst.setFont(new Font("Century Schoolbook L", Font.BOLD, 28));
		lblPickYourFirst.setBounds(28, 26, 458, 37);
		window.getContentPane().add(lblPickYourFirst);
		
		JLabel lblNameThisMonster = new JLabel("Name this monster");
		lblNameThisMonster.setFont(new Font("Century Schoolbook L", Font.BOLD, 20));
		lblNameThisMonster.setBounds(30, 98, 220, 26);
		window.getContentPane().add(lblNameThisMonster);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FirstMonsterSetupScreen.class.getResource("")));
		lblNewLabel.setBounds(405, 71, 183, 210);
		window.getContentPane().add(lblNewLabel);
		
		JLabel lblMonsterInfo = new JLabel("<html><div>Please select a monster first to view information.</div></html>");
		lblMonsterInfo.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		lblMonsterInfo.setBounds(405, 275, 305, 116);
		window.getContentPane().add(lblMonsterInfo);
		
		JButton buttonMonster1 = new JButton(monsters.get(0).getMonsterType().toString());
		buttonMonster1.setForeground(Color.WHITE);
		buttonMonster1.setBackground(new Color(0, 51, 153));
		buttonMonster1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		buttonMonster1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedMonster = monsters.get(0);
				lblMonsterInfo.setText("<html><div>" + tools.makeStringDescriptionFromMonsterInformation(monsters.get(0)) + "</div></html>");
				lblNewLabel.setIcon(new ImageIcon(FirstMonsterSetupScreen.class.getResource(selectedMonster.getEntityImagePath())));
			}
		});
		buttonMonster1.setBounds(30, 233, 165, 73);
		window.getContentPane().add(buttonMonster1);
		
		JButton btnMonster2 = new JButton(monsters.get(1).getMonsterType().toString());
		btnMonster2.setForeground(Color.WHITE);
		btnMonster2.setBackground(new Color(0, 51, 153));
		btnMonster2.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedMonster = monsters.get(1);
				lblMonsterInfo.setText("<html><div>" + tools.makeStringDescriptionFromMonsterInformation(monsters.get(1)) + "</div></html>");
				lblNewLabel.setIcon(new ImageIcon(FirstMonsterSetupScreen.class.getResource(selectedMonster.getEntityImagePath())));
				
			}
		});
		btnMonster2.setBounds(30, 318, 165, 73);
		window.getContentPane().add(btnMonster2);
		
		JButton btnMonster3 = new JButton(monsters.get(2).getMonsterType().toString());
		btnMonster3.setForeground(Color.WHITE);
		btnMonster3.setBackground(new Color(0, 51, 153));
		btnMonster3.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedMonster = monsters.get(2);
				lblMonsterInfo.setText("<html><div>" + tools.makeStringDescriptionFromMonsterInformation(monsters.get(2)) + "</div></html>");
				lblNewLabel.setIcon(new ImageIcon(FirstMonsterSetupScreen.class.getResource(selectedMonster.getEntityImagePath())));
			}
		});
		btnMonster3.setBounds(207, 233, 165, 73);
		window.getContentPane().add(btnMonster3);
		
		JButton btnMonster4 = new JButton(monsters.get(3).getMonsterType().toString());
		btnMonster4.setForeground(Color.WHITE);
		btnMonster4.setBackground(new Color(0, 51, 153));
		btnMonster4.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedMonster = monsters.get(3);
				lblMonsterInfo.setText("<html><div>" + tools.makeStringDescriptionFromMonsterInformation(monsters.get(3)) + "</div></html>");
				lblNewLabel.setIcon(new ImageIcon(FirstMonsterSetupScreen.class.getResource(selectedMonster.getEntityImagePath())));
			}
		});
		btnMonster4.setBounds(207, 318, 165, 73);
		window.getContentPane().add(btnMonster4);
		
		textFieldMonsterName = new JTextField(tools.generateRandomMonsterName());
		textFieldMonsterName.setForeground(Color.BLACK);
		textFieldMonsterName.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		textFieldMonsterName.setColumns(10);
		textFieldMonsterName.setBackground(new Color(230, 230, 250));
		textFieldMonsterName.setBounds(30, 136, 278, 33);
		window.getContentPane().add(textFieldMonsterName);
		
		JLabel lblThenSelectOne = new JLabel("Select a monster from below");
		lblThenSelectOne.setFont(new Font("Century Schoolbook L", Font.BOLD, 20));
		lblThenSelectOne.setBounds(30, 195, 296, 26);
		window.getContentPane().add(lblThenSelectOne);
		
		
		JButton btnConfirmMonsterChoice = new JButton("Next");
		btnConfirmMonsterChoice.setForeground(Color.WHITE);
		btnConfirmMonsterChoice.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnConfirmMonsterChoice.setBackground(Color.DARK_GRAY);
		btnConfirmMonsterChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					selectedMonster.setEntityName(textFieldMonsterName.getText());
					inventory.addMonster(selectedMonster);
					finishedWindow();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(window, "You need to select a monster!");
				}
			}
		});
		btnConfirmMonsterChoice.setBounds(599, 418, 109, 37);
		window.getContentPane().add(btnConfirmMonsterChoice);

		
	}
}
