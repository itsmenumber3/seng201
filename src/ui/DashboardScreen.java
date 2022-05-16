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

public class DashboardScreen {

	private JFrame frmTheShop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardScreen window = new DashboardScreen();
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
	public DashboardScreen() {
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
		
		JLabel lblNauMaiWelcome = new JLabel("Cafeteria Area");
		lblNauMaiWelcome.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNauMaiWelcome.setBounds(31, 20, 458, 37);
		frmTheShop.getContentPane().add(lblNauMaiWelcome);
		
		JLabel lblTodaysRange = new JLabel("Choose a monster to start feeding");
		lblTodaysRange.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTodaysRange.setBounds(31, 69, 406, 30);
		frmTheShop.getContentPane().add(lblTodaysRange);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(31, 102, 117, 73);
		frmTheShop.getContentPane().add(btnNewButton);
		
		JButton btnTradeInYour = new JButton("Trade in monster");
		btnTradeInYour.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnTradeInYour.setBounds(154, 381, 196, 30);
		frmTheShop.getContentPane().add(btnTradeInYour);
		
		JButton btnVisitTheShops = new JButton("Buy monsters");
		btnVisitTheShops.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnVisitTheShops.setBounds(154, 415, 196, 30);
		frmTheShop.getContentPane().add(btnVisitTheShops);
		
		JButton btnNewButton_2_1_1_1_1 = new JButton("Feed me!");
		btnNewButton_2_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnNewButton_2_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2_1_1_1_1.setBounds(526, 302, 171, 25);
		frmTheShop.getContentPane().add(btnNewButton_2_1_1_1_1);
		
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
		lblActions.setBounds(32, 25, 106, 37);
		panelBackground.add(lblActions);
		
		JLabel lblYourBalance_1_1_1 = new JLabel("0 points");
		lblYourBalance_1_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblYourBalance_1_1_1.setBounds(596, 42, 101, 15);
		frmTheShop.getContentPane().add(lblYourBalance_1_1_1);
		
		JLabel lblYourBalance_1_1 = new JLabel("0 golds");
		lblYourBalance_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblYourBalance_1_1.setBounds(596, 28, 101, 15);
		frmTheShop.getContentPane().add(lblYourBalance_1_1);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(160, 102, 117, 73);
		frmTheShop.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("New button");
		btnNewButton_1_1.setBounds(289, 102, 117, 73);
		frmTheShop.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("New button");
		btnNewButton_1_1_1.setBounds(418, 102, 117, 73);
		frmTheShop.getContentPane().add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("New button");
		btnNewButton_1_1_1_1.setBounds(546, 102, 117, 73);
		frmTheShop.getContentPane().add(btnNewButton_1_1_1_1);
	}
}
