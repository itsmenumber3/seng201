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

public class CafeteriaScreen {

	private JFrame frmTheShop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CafeteriaScreen window = new CafeteriaScreen();
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
	public CafeteriaScreen() {
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
		
		JLabel lblNauMaiWelcome = new JLabel("Player's Dashboard");
		lblNauMaiWelcome.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNauMaiWelcome.setBounds(31, 20, 458, 30);
		frmTheShop.getContentPane().add(lblNauMaiWelcome);
		
		JLabel lblTodaysRange = new JLabel("Day 1 of 5");
		lblTodaysRange.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTodaysRange.setBounds(582, 26, 115, 30);
		frmTheShop.getContentPane().add(lblTodaysRange);
		
		JButton btnTradeInYour = new JButton("Inventory");
		btnTradeInYour.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnTradeInYour.setBounds(154, 381, 161, 64);
		frmTheShop.getContentPane().add(btnTradeInYour);
		
		JButton btnReturnToDashboard = new JButton("Visit The Shop");
		btnReturnToDashboard.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnReturnToDashboard.setBounds(494, 381, 203, 64);
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
		
		JLabel lblYourBalance_1_1 = new JLabel("0 golds");
		lblYourBalance_1_1.setBounds(32, 59, 101, 15);
		panelBackground.add(lblYourBalance_1_1);
		lblYourBalance_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JLabel lblYourBalance_1_1_1 = new JLabel("0 points");
		lblYourBalance_1_1_1.setBounds(32, 74, 101, 15);
		panelBackground.add(lblYourBalance_1_1_1);
		lblYourBalance_1_1_1.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JButton btnTopUpWeapon = new JButton("Bedroom");
		btnTopUpWeapon.setBounds(325, 25, 161, 64);
		panelBackground.add(btnTopUpWeapon);
		btnTopUpWeapon.setFont(new Font("Dialog", Font.PLAIN, 12));
		
		JButton btnTradeInYour_1 = new JButton("Inventory");
		btnTradeInYour_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTradeInYour_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnTradeInYour_1.setBounds(31, 111, 192, 69);
		frmTheShop.getContentPane().add(btnTradeInYour_1);
		
		JLabel lblChooseABattle = new JLabel("Choose a battle");
		lblChooseABattle.setFont(new Font("Dialog", Font.BOLD, 18));
		lblChooseABattle.setBounds(31, 62, 458, 37);
		frmTheShop.getContentPane().add(lblChooseABattle);
		
		JButton btnTradeInYour_1_1 = new JButton("Inventory");
		btnTradeInYour_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnTradeInYour_1_1.setBounds(31, 179, 192, 69);
		frmTheShop.getContentPane().add(btnTradeInYour_1_1);
		
		JButton btnTradeInYour_1_1_1 = new JButton("Inventory");
		btnTradeInYour_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnTradeInYour_1_1_1.setBounds(31, 242, 192, 69);
		frmTheShop.getContentPane().add(btnTradeInYour_1_1_1);
		
		JPanel panelBackground_1 = new JPanel();
		panelBackground_1.setLayout(null);
		panelBackground_1.setBackground(Color.WHITE);
		panelBackground_1.setBounds(235, 109, 498, 201);
		frmTheShop.getContentPane().add(panelBackground_1);
		
		JButton btnTradeInYour_1_1_2 = new JButton("Start the game");
		btnTradeInYour_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnTradeInYour_1_1_2.setBounds(324, 155, 162, 34);
		panelBackground_1.add(btnTradeInYour_1_1_2);
	}
}
