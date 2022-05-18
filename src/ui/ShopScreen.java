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
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class ShopScreen {

	private JFrame window;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopScreen window = new ShopScreen();
					window.window.setVisible(true);
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
		window = new JFrame();
		window.setTitle("New World Kaitaia");
		window.setBounds(100, 100, 750, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblNauMaiWelcome = new JLabel("New World Kaitaia");
		lblNauMaiWelcome.setFont(new Font("Century Schoolbook L", Font.BOLD, 24));
		lblNauMaiWelcome.setBounds(12, 20, 261, 34);
		window.getContentPane().add(lblNauMaiWelcome);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 69, 724, 388);
		window.getContentPane().add(tabbedPane);
		
		JPanel panelPurchaseMonster = new JPanel();
		tabbedPane.addTab("Buy Monster", null, panelPurchaseMonster, "");
		tabbedPane.setEnabledAt(0, true);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		panelPurchaseMonster.setLayout(null);
		
		JButton btnPurchaseThisMonster = new JButton("Purchase this monster");
		btnPurchaseThisMonster.setForeground(Color.WHITE);
		btnPurchaseThisMonster.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnPurchaseThisMonster.setBackground(Color.RED);
		btnPurchaseThisMonster.setBounds(508, 320, 199, 29);
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
		
		JButton btnTradeInMonster_1_1_1_1 = new JButton("Monster 1");
		btnTradeInMonster_1_1_1_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnTradeInMonster_1_1_1_1.setBackground(SystemColor.info);
		btnTradeInMonster_1_1_1_1.setBounds(596, 224, 111, 25);
		panelPurchaseMonster.add(btnTradeInMonster_1_1_1_1);
		
		JLabel lblYourCurrentSelection = new JLabel("Your current selection:");
		lblYourCurrentSelection.setBounds(12, 275, 451, 15);
		panelPurchaseMonster.add(lblYourCurrentSelection);
		
		JLabel lblTipClickTo = new JLabel("Tip: click to view properties, then press Purchase this monster.");
		lblTipClickTo.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		lblTipClickTo.setBounds(12, 334, 451, 15);
		panelPurchaseMonster.add(lblTipClickTo);
		
		JLabel lblTipClickTo_1_4_1 = new JLabel("<html><div>Fresh new monsters of the day</div></html>");
		lblTipClickTo_1_4_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		lblTipClickTo_1_4_1.setBounds(12, 0, 386, 54);
		panelPurchaseMonster.add(lblTipClickTo_1_4_1);
		
		JPanel panelBuyFood = new JPanel();
		tabbedPane.addTab("Delicatessen", null, panelBuyFood, null);
		panelBuyFood.setLayout(null);
		
		JLabel lblTipClickTo_1 = new JLabel("<html><div>Welcome to New World Kaitaia's Service Deli. Please select a monster you would like to feed, then select the food you would like to buy.</div></html>");
		lblTipClickTo_1.setBounds(12, 12, 352, 58);
		lblTipClickTo_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		panelBuyFood.add(lblTipClickTo_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(154, 93, 210, 24);
		panelBuyFood.add(comboBox);
		
		JLabel lblTipClickTo_1_1 = new JLabel("<html><div>Select a monster:</div></html>");
		lblTipClickTo_1_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTipClickTo_1_1.setBounds(12, 82, 124, 47);
		panelBuyFood.add(lblTipClickTo_1_1);
		
		JLabel lblTipClickTo_1_1_1 = new JLabel("<html><div>Select food:</div></html>");
		lblTipClickTo_1_1_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTipClickTo_1_1_1.setBounds(12, 117, 124, 47);
		panelBuyFood.add(lblTipClickTo_1_1_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(154, 128, 210, 24);
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
		
		JButton btnPurchaseAndFeed_1 = new JButton("<html><div>Purchase and store in inventory</div></html>");
		btnPurchaseAndFeed_1.setForeground(Color.WHITE);
		btnPurchaseAndFeed_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnPurchaseAndFeed_1.setBackground(Color.RED);
		btnPurchaseAndFeed_1.setBounds(12, 278, 353, 31);
		panelBuyFood.add(btnPurchaseAndFeed_1);
		
		JPanel panelBuyPotion = new JPanel();
		tabbedPane.addTab("Cafe", null, panelBuyPotion, null);
		
		JPanel panelTradeInMonster = new JPanel();
		panelTradeInMonster.setLayout(null);
		tabbedPane.addTab("Trade in monsters", null, panelTradeInMonster, null);
		
		JButton btnPurchaseThisMonster_1 = new JButton("Sell back this monster");
		btnPurchaseThisMonster_1.setForeground(Color.WHITE);
		btnPurchaseThisMonster_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnPurchaseThisMonster_1.setBackground(Color.RED);
		btnPurchaseThisMonster_1.setBounds(502, 320, 205, 29);
		panelTradeInMonster.add(btnPurchaseThisMonster_1);
		
		JButton btnTradeInMonster_1_2 = new JButton("Monster 1");
		btnTradeInMonster_1_2.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnTradeInMonster_1_2.setBackground(SystemColor.info);
		btnTradeInMonster_1_2.setBounds(155, 224, 111, 25);
		panelTradeInMonster.add(btnTradeInMonster_1_2);
		
		JButton btnTradeInMonster_1_1_1_2 = new JButton("Monster 1");
		btnTradeInMonster_1_1_1_2.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnTradeInMonster_1_1_1_2.setBackground(SystemColor.info);
		btnTradeInMonster_1_1_1_2.setBounds(446, 224, 111, 25);
		panelTradeInMonster.add(btnTradeInMonster_1_1_1_2);
		
		JLabel lblYourCurrentSelection_1 = new JLabel("Your current selection:");
		lblYourCurrentSelection_1.setBounds(12, 275, 451, 15);
		panelTradeInMonster.add(lblYourCurrentSelection_1);
		
		JLabel lblTipClickTo_2 = new JLabel("Tip: click to view properties, then press Purchase this monster.");
		lblTipClickTo_2.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		lblTipClickTo_2.setBounds(12, 334, 451, 15);
		panelTradeInMonster.add(lblTipClickTo_2);
		
		JLabel lblTipClickTo_1_4 = new JLabel("<html><div>New World Kaitaia would like to buy these monsters from you, for these listed prices.</div></html>");
		lblTipClickTo_1_4.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		lblTipClickTo_1_4.setBounds(12, 12, 386, 54);
		panelTradeInMonster.add(lblTipClickTo_1_4);
		
		JPanel panelLottoCounter = new JPanel();
		tabbedPane.addTab("Lotto Counter", null, panelLottoCounter, null);
		panelLottoCounter.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ShopScreen.class.getResource("/assets/ui/img/LottoLogo.png")));
		lblNewLabel.setBounds(12, 12, 376, 168);
		panelLottoCounter.add(lblNewLabel);
		
		JButton btnPurchaseTicket = new JButton("Purchase ticket");
		btnPurchaseTicket.setForeground(Color.WHITE);
		btnPurchaseTicket.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnPurchaseTicket.setBackground(Color.RED);
		btnPurchaseTicket.setBounds(402, 268, 167, 33);
		panelLottoCounter.add(btnPurchaseTicket);
		
		JLabel lblTipClickTo_1_2 = new JLabel("<html><div>Welcome to Lotto NZ. Please play responsibly. Each ticket costs 30 coins, and you can select your own number from 0 to 10 inclusive. Results will be available overnight and notified to you.</div></html>");
		lblTipClickTo_1_2.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTipClickTo_1_2.setBounds(12, 192, 468, 64);
		panelLottoCounter.add(lblTipClickTo_1_2);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBackground(Color.YELLOW);
		textField.setBounds(253, 268, 137, 33);
		panelLottoCounter.add(textField);
		
		JLabel lblTipClickTo_1_2_1 = new JLabel("<html><div>Enter a number between 0 and 10: </div></html>");
		lblTipClickTo_1_2_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTipClickTo_1_2_1.setBounds(12, 253, 468, 64);
		panelLottoCounter.add(lblTipClickTo_1_2_1);
		
		JLabel lblYourBalance_1_1_2 = new JLabel("0 gold coins");
		lblYourBalance_1_1_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblYourBalance_1_1_2.setBounds(341, 28, 101, 25);
		window.getContentPane().add(lblYourBalance_1_1_2);
		lblYourBalance_1_1_2.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		
		JButton btnReturnToDashboard = new JButton("Return to Map");
		btnReturnToDashboard.setBackground(SystemColor.info);
		btnReturnToDashboard.setBounds(600, 28, 136, 25);
		window.getContentPane().add(btnReturnToDashboard);
		btnReturnToDashboard.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.setBackground(SystemColor.info);
		btnInventory.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnInventory.setBounds(487, 28, 101, 25);
		window.getContentPane().add(btnInventory);
	}
}
