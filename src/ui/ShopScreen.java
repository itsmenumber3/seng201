package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;

public class ShopScreen {

	private JFrame frmTheShop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopScreen window = new ShopScreen();
					window.frmTheShop.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShopScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTheShop = new JFrame();
		frmTheShop.setTitle("The Shop");
		frmTheShop.setBounds(100, 100, 750, 500);
		frmTheShop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTheShop.getContentPane().setLayout(null);
		
		JLabel lblNauMaiWelcome = new JLabel("Nau mai ki a The Shop");
		lblNauMaiWelcome.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNauMaiWelcome.setBounds(31, 20, 458, 37);
		frmTheShop.getContentPane().add(lblNauMaiWelcome);
		
		JLabel lblTodaysRange = new JLabel("Today's monster range");
		lblTodaysRange.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTodaysRange.setBounds(31, 56, 273, 30);
		frmTheShop.getContentPane().add(lblTodaysRange);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(31, 96, 165, 73);
		frmTheShop.getContentPane().add(btnNewButton);
		
		JButton btnTradeInYour = new JButton("Trade in monster");
		btnTradeInYour.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnTradeInYour.setBounds(154, 381, 196, 30);
		frmTheShop.getContentPane().add(btnTradeInYour);
		
		JButton btnVisitTheShops = new JButton("Buy food / potion");
		btnVisitTheShops.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnVisitTheShops.setBounds(154, 415, 196, 30);
		frmTheShop.getContentPane().add(btnVisitTheShops);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(206, 96, 165, 73);
		frmTheShop.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(31, 181, 165, 73);
		frmTheShop.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("New button");
		btnNewButton_2_1.setBounds(206, 181, 165, 73);
		frmTheShop.getContentPane().add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("New button");
		btnNewButton_2_1_1.setBounds(31, 266, 165, 73);
		frmTheShop.getContentPane().add(btnNewButton_2_1_1);
		
		JButton btnNewButton_2_1_1_1 = new JButton("New button");
		btnNewButton_2_1_1_1.setBounds(206, 266, 165, 73);
		frmTheShop.getContentPane().add(btnNewButton_2_1_1_1);
		
		JButton btnNewButton_2_1_1_1_1 = new JButton("Confirm purchase");
		btnNewButton_2_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnNewButton_2_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2_1_1_1_1.setBounds(411, 302, 273, 25);
		frmTheShop.getContentPane().add(btnNewButton_2_1_1_1_1);
		
		JTextPane txtpnSdsds = new JTextPane();
		txtpnSdsds.setText("Please select a monster to view information. After that, click Confirm Purchase to name the monster.");
		txtpnSdsds.setBounds(394, 82, 303, 257);
		frmTheShop.getContentPane().add(txtpnSdsds);
		
		JButton btnTopUpWeapon = new JButton("Top up weapon");
		btnTopUpWeapon.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnTopUpWeapon.setBounds(357, 381, 196, 30);
		frmTheShop.getContentPane().add(btnTopUpWeapon);
		
		JButton btnViewInventory = new JButton("View inventory");
		btnViewInventory.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnViewInventory.setBounds(357, 415, 196, 30);
		frmTheShop.getContentPane().add(btnViewInventory);
		
		JButton btnReturnToDashboard = new JButton("Dashboard");
		btnReturnToDashboard.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnReturnToDashboard.setBounds(562, 381, 135, 64);
		frmTheShop.getContentPane().add(btnReturnToDashboard);
		
		JPanel panelBackground = new JPanel();
		panelBackground.setLayout(null);
		panelBackground.setBackground(Color.WHITE);
		panelBackground.setBounds(0, 356, 748, 113);
		frmTheShop.getContentPane().add(panelBackground);
		
		JLabel lblActions = new JLabel("Actions");
		lblActions.setFont(new Font("Dialog", Font.BOLD, 18));
		lblActions.setBounds(32, 25, 106, 22);
		panelBackground.add(lblActions);
		
		JLabel lblYourBalance_1_1_1_1 = new JLabel("0 points");
		lblYourBalance_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblYourBalance_1_1_1_1.setBounds(32, 68, 101, 15);
		panelBackground.add(lblYourBalance_1_1_1_1);
		
		JLabel lblYourBalance_1_1_2 = new JLabel("0 golds");
		lblYourBalance_1_1_2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblYourBalance_1_1_2.setBounds(32, 53, 101, 15);
		panelBackground.add(lblYourBalance_1_1_2);
	}
}
