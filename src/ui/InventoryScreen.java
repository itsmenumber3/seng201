package ui;

import main.GameEnvironment;

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
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class InventoryScreen {

	private JFrame window;
	private GameEnvironment gameEnvironment;
	private boolean isPreviousWindowMapWindow;

	public boolean getIsPreviousWindowMapWindow() {
		return this.isPreviousWindowMapWindow;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryScreen window = new InventoryScreen();
					window.window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InventoryScreen(GameEnvironment inputGameEnvironment, boolean inputIsPreviousWindowMapWindow) {
		this.gameEnvironment = inputGameEnvironment;
		this.isPreviousWindowMapWindow = inputIsPreviousWindowMapWindow;
		initialize();
		window.setVisible(true);
	}

	public void closeWindow() {
		frame.dispose();
	}

	public void finishedWindow() {
		gameEnvironment.closeInventoryScreen(this);
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
		window = new JFrame();
		window.setTitle("New World Kaitaia");
		window.setBounds(100, 100, 750, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblNauMaiWelcome = new JLabel("Player's Inventory");
		lblNauMaiWelcome.setFont(new Font("Century Schoolbook L", Font.BOLD, 24));
		lblNauMaiWelcome.setBounds(12, 20, 261, 34);
		window.getContentPane().add(lblNauMaiWelcome);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 69, 724, 388);
		window.getContentPane().add(tabbedPane);
		
		JPanel panelPurchaseMonster = new JPanel();
		tabbedPane.addTab("Player's Monsters", null, panelPurchaseMonster, "");
		tabbedPane.setEnabledAt(0, true);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		panelPurchaseMonster.setLayout(null);
		
		JButton btnPurchaseThisMonster = new JButton("Reorder Monster");
		btnPurchaseThisMonster.setForeground(Color.WHITE);
		btnPurchaseThisMonster.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnPurchaseThisMonster.setBackground(Color.RED);
		btnPurchaseThisMonster.setBounds(549, 320, 158, 29);
		panelPurchaseMonster.add(btnPurchaseThisMonster);
		
		JButton btnTradeInMonster = new JButton("Monster 1");
		btnTradeInMonster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTradeInMonster.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnTradeInMonster.setBackground(SystemColor.info);
		btnTradeInMonster.setBounds(12, 224, 111, 25);
		panelPurchaseMonster.add(btnTradeInMonster);
		
		JButton btnTradeInMonster_1 = new JButton("Monster 1");
		btnTradeInMonster_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnTradeInMonster_1.setBackground(SystemColor.info);
		btnTradeInMonster_1.setBounds(155, 224, 111, 25);
		panelPurchaseMonster.add(btnTradeInMonster_1);
		
		JButton btnTradeInMonster_1_1 = new JButton("Monster 1");
		btnTradeInMonster_1_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnTradeInMonster_1_1.setBackground(SystemColor.info);
		btnTradeInMonster_1_1.setBounds(299, 224, 111, 25);
		panelPurchaseMonster.add(btnTradeInMonster_1_1);
		
		JButton btnTradeInMonster_1_1_1 = new JButton("Monster 1");
		btnTradeInMonster_1_1_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnTradeInMonster_1_1_1.setBackground(SystemColor.info);
		btnTradeInMonster_1_1_1.setBounds(446, 224, 111, 25);
		panelPurchaseMonster.add(btnTradeInMonster_1_1_1);
		
		JPanel panelBuyFood = new JPanel();
		tabbedPane.addTab("Dining Room", null, panelBuyFood, null);
		panelBuyFood.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(155, 85, 210, 24);
		panelBuyFood.add(comboBox);
		
		JLabel lblTipClickTo_1_1 = new JLabel("<html><div>Select a monster:</div></html>");
		lblTipClickTo_1_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTipClickTo_1_1.setBounds(13, 74, 124, 47);
		panelBuyFood.add(lblTipClickTo_1_1);
		
		JLabel lblTipClickTo_1_1_1 = new JLabel("<html><div>Select food:</div></html>");
		lblTipClickTo_1_1_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTipClickTo_1_1_1.setBounds(13, 109, 124, 47);
		panelBuyFood.add(lblTipClickTo_1_1_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(155, 120, 210, 24);
		panelBuyFood.add(comboBox_1);
		
		JButton btnPurchaseAndFeed = new JButton("<html><div>Purchase and feed monster</div></html>");
		btnPurchaseAndFeed.setForeground(Color.WHITE);
		btnPurchaseAndFeed.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnPurchaseAndFeed.setBackground(Color.RED);
		btnPurchaseAndFeed.setBounds(12, 235, 353, 31);
		panelBuyFood.add(btnPurchaseAndFeed);
		
		JLabel lblTipClickTo_1_3 = new JLabel("<html><div>You're selecting Pasta. Pasta increases adds 10% to the monster's health. Pasta costs 20 coins. </div></html>");
		lblTipClickTo_1_3.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTipClickTo_1_3.setBounds(12, 171, 420, 47);
		panelBuyFood.add(lblTipClickTo_1_3);
		
		JPanel panelBuyPotion = new JPanel();
		tabbedPane.addTab("Potion Fridge", null, panelBuyPotion, null);
		panelBuyPotion.setLayout(null);
		
		JLabel lblTipClickTo_1_1_2 = new JLabel("<html><div>Select a monster:</div></html>");
		lblTipClickTo_1_1_2.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTipClickTo_1_1_2.setBounds(12, 33, 124, 47);
		panelBuyPotion.add(lblTipClickTo_1_1_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(154, 44, 210, 24);
		panelBuyPotion.add(comboBox_2);
		
		JLabel lblTipClickTo_1_1_1_1 = new JLabel("<html><div>Select food:</div></html>");
		lblTipClickTo_1_1_1_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTipClickTo_1_1_1_1.setBounds(12, 68, 124, 47);
		panelBuyPotion.add(lblTipClickTo_1_1_1_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(154, 79, 210, 24);
		panelBuyPotion.add(comboBox_1_1);
		
		JButton btndrinkPotionNow = new JButton("<html><div>Drink potion now</div></html>");
		btndrinkPotionNow.setForeground(Color.WHITE);
		btndrinkPotionNow.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btndrinkPotionNow.setBackground(Color.RED);
		btndrinkPotionNow.setBounds(12, 179, 353, 31);
		panelBuyPotion.add(btndrinkPotionNow);
		
		JLabel lblTipClickTo_1_3_1 = new JLabel("<html><div>You're selecting Pasta. Pasta increases adds 10% to the monster's health. Pasta costs 20 coins. </div></html>");
		lblTipClickTo_1_3_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTipClickTo_1_3_1.setBounds(12, 115, 420, 47);
		panelBuyPotion.add(lblTipClickTo_1_3_1);
		
		JLabel lblYourBalance_1_1_2 = new JLabel("0 gold coins");
		lblYourBalance_1_1_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblYourBalance_1_1_2.setBounds(254, 28, 101, 25);
		window.getContentPane().add(lblYourBalance_1_1_2);
		lblYourBalance_1_1_2.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		
		JButton btnReturnToDashboard = new JButton("Return to Map");
		btnReturnToDashboard.setBackground(SystemColor.info);
		btnReturnToDashboard.setBounds(600, 28, 136, 25);
		window.getContentPane().add(btnReturnToDashboard);
		btnReturnToDashboard.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		
		JButton btnInventory = new JButton("Visit New World Kaitaia");
		btnInventory.setBackground(SystemColor.info);
		btnInventory.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnInventory.setBounds(380, 28, 208, 25);
		window.getContentPane().add(btnInventory);
	}
}
