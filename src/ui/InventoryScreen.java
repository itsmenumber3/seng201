package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;

public class InventoryScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryScreen window = new InventoryScreen();
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
	public InventoryScreen() {
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
		
		JLabel lblInventory = new JLabel("Inventory");
		lblInventory.setFont(new Font("Dialog", Font.BOLD, 24));
		lblInventory.setBounds(30, 24, 458, 37);
		frame.getContentPane().add(lblInventory);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(30, 92, 165, 73);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(207, 92, 165, 73);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("New button");
		btnNewButton_1_1.setBounds(30, 177, 165, 73);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("New button");
		btnNewButton_1_1_1.setBounds(207, 177, 165, 73);
		frame.getContentPane().add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton("New button");
		btnNewButton_1_1_2.setBounds(30, 262, 165, 73);
		frame.getContentPane().add(btnNewButton_1_1_2);
		
		JButton btnNewButton_1_1_2_1 = new JButton("New button");
		btnNewButton_1_1_2_1.setBounds(207, 262, 165, 73);
		frame.getContentPane().add(btnNewButton_1_1_2_1);
		
		JPanel panelBackground_1 = new JPanel();
		panelBackground_1.setLayout(null);
		panelBackground_1.setBackground(Color.WHITE);
		panelBackground_1.setBounds(397, 85, 313, 250);
		frame.getContentPane().add(panelBackground_1);
		
		JPanel panelBackground = new JPanel();
		panelBackground.setLayout(null);
		panelBackground.setBackground(Color.WHITE);
		panelBackground.setBounds(0, 356, 748, 113);
		frame.getContentPane().add(panelBackground);
		
		JLabel lblActions = new JLabel("Actions");
		lblActions.setFont(new Font("Dialog", Font.BOLD, 18));
		lblActions.setBounds(32, 25, 106, 37);
		panelBackground.add(lblActions);
		
		JLabel lblYourBalance_1_1_2 = new JLabel("0 golds");
		lblYourBalance_1_1_2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblYourBalance_1_1_2.setBounds(32, 59, 101, 15);
		panelBackground.add(lblYourBalance_1_1_2);
		
		JLabel lblYourBalance_1_1_1_1 = new JLabel("0 points");
		lblYourBalance_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblYourBalance_1_1_1_1.setBounds(32, 74, 101, 15);
		panelBackground.add(lblYourBalance_1_1_1_1);
		
		JButton btnReturnToDashboard_2 = new JButton("Return to dashboard");
		btnReturnToDashboard_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnReturnToDashboard_2.setBounds(502, 25, 203, 64);
		panelBackground.add(btnReturnToDashboard_2);
		
		JButton btnVisitTheShop = new JButton("Visit The Shop");
		btnVisitTheShop.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnVisitTheShop.setBounds(329, 25, 161, 64);
		panelBackground.add(btnVisitTheShop);
	}

}
