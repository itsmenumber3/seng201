package ui;

import main.GameEnvironment;
import main.Inventory;
import main.Player;

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

import battles.Battle;

import java.awt.SystemColor;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTable;

public class ShopScreen {

	private JFrame window;
	private JTextField textField;
	private JTable table;
	private GameEnvironment gameEnvironment;
	private Player player;
	private Inventory inventory;
	private Battle battle;

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

	public ShopScreen(GameEnvironment inputGameEnvironment) {
		this.gameEnvironment = inputGameEnvironment;
		this.player = gameEnvironment.getPlayer();
		this.inventory = player.getPlayerInventory();
		this.battle = player.getPlayerSelectedBattle();
		initialize();
		window.setVisible(true);
	}

	public void closeWindow() {
		window.dispose();
	}

	public void finishedWindow() {
		gameEnvironment.closeShopScreen(this);
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
		window.setTitle(battle.getBattleShop().getShopName());
		window.setBounds(100, 100, 750, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblShopName = new JLabel(battle.getBattleShop().getShopName());
		lblShopName.setFont(new Font("Century Schoolbook L", Font.BOLD, 24));
		lblShopName.setBounds(23, 20, 261, 34);
		window.getContentPane().add(lblShopName);
		
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
		
		JButton btnMonster1 = new JButton("Monster 1");
		btnMonster1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMonster1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster1.setBackground(SystemColor.info);
		btnMonster1.setBounds(12, 224, 111, 25);
		panelPurchaseMonster.add(btnMonster1);
		
		JButton btnMonster2 = new JButton("Monster 1");
		btnMonster2.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster2.setBackground(SystemColor.info);
		btnMonster2.setBounds(155, 224, 111, 25);
		panelPurchaseMonster.add(btnMonster2);
		
		JButton btnMonster3 = new JButton("Monster 1");
		btnMonster3.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster3.setBackground(SystemColor.info);
		btnMonster3.setBounds(299, 224, 111, 25);
		panelPurchaseMonster.add(btnMonster3);
		
		JButton btnMonster4 = new JButton("Monster 1");
		btnMonster4.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster4.setBackground(SystemColor.info);
		btnMonster4.setBounds(446, 224, 111, 25);
		panelPurchaseMonster.add(btnMonster4);
		
		JButton btnMonster5 = new JButton("Monster 1");
		btnMonster5.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster5.setBackground(SystemColor.info);
		btnMonster5.setBounds(596, 224, 111, 25);
		panelPurchaseMonster.add(btnMonster5);
		
		JLabel lblYourCurrentSelection = new JLabel("Your current selection:");
		lblYourCurrentSelection.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblYourCurrentSelection.setBounds(12, 275, 258, 47);
		panelPurchaseMonster.add(lblYourCurrentSelection);
		
		JLabel lblTip = new JLabel("Tip: click to view properties, then press Purchase this monster.");
		lblTip.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		lblTip.setBounds(12, 334, 361, 15);
		panelPurchaseMonster.add(lblTip);
		
		JLabel lblMonster1Img = new JLabel("");
		lblMonster1Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster1Img.setIcon(new ImageIcon(ShopScreen.class.getResource("/assets/ui/img/dragon-final.png")));
		lblMonster1Img.setBounds(12, 12, 111, 200);
		panelPurchaseMonster.add(lblMonster1Img);
		
		JLabel lblMonster2Img = new JLabel("");
		lblMonster2Img.setIcon(new ImageIcon(ShopScreen.class.getResource("/assets/ui/img/skeleton-final.jpg")));
		lblMonster2Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster2Img.setBounds(155, 12, 111, 200);
		panelPurchaseMonster.add(lblMonster2Img);
		
		JLabel lblMonster3Img = new JLabel("");
		lblMonster3Img.setIcon(new ImageIcon(ShopScreen.class.getResource("/assets/ui/img/spirit-final.jpg")));
		lblMonster3Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster3Img.setBounds(299, 12, 111, 200);
		panelPurchaseMonster.add(lblMonster3Img);
		
		JLabel lblMonster4Img = new JLabel("");
		lblMonster4Img.setIcon(new ImageIcon(ShopScreen.class.getResource("/assets/ui/img/troll-final.png")));
		lblMonster4Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster4Img.setBounds(446, 12, 111, 200);
		panelPurchaseMonster.add(lblMonster4Img);
		
		JLabel lblMonster5Img = new JLabel("");
		lblMonster5Img.setIcon(new ImageIcon(ShopScreen.class.getResource("/assets/ui/img/zombie-final.jpg")));
		lblMonster5Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster5Img.setBounds(596, 12, 111, 200);
		panelPurchaseMonster.add(lblMonster5Img);
		
		JPanel panelBuyFood = new JPanel();
		tabbedPane.addTab("Delicatessen", null, panelBuyFood, null);
		panelBuyFood.setLayout(null);
		
		JLabel lblIntroduction = new JLabel("<html><div>Welcome to New World Kaitaia's Service Deli. Please select a monster you would like to feed, then select the food you would like to buy.</div></html>");
		lblIntroduction.setBounds(12, 12, 352, 58);
		lblIntroduction.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		panelBuyFood.add(lblIntroduction);
		
		JComboBox comboBoxMonster = new JComboBox();
		comboBoxMonster.setBounds(154, 93, 210, 24);
		panelBuyFood.add(comboBoxMonster);
		
		JLabel lblSelectAMonster = new JLabel("<html><div>Select a monster:</div></html>");
		lblSelectAMonster.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblSelectAMonster.setBounds(12, 82, 124, 47);
		panelBuyFood.add(lblSelectAMonster);
		
		JLabel lblSelectFood = new JLabel("<html><div>Select food:</div></html>");
		lblSelectFood.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblSelectFood.setBounds(12, 117, 124, 47);
		panelBuyFood.add(lblSelectFood);
		
		JComboBox comboBoxFood = new JComboBox();
		comboBoxFood.setBounds(154, 128, 210, 24);
		panelBuyFood.add(comboBoxFood);
		
		JLabel lblYourCurrentFoodSelection = new JLabel("<html><div>You're selecting Pasta. Pasta increases adds 10% to the monster's health. Pasta costs 20 coins. </div></html>");
		lblYourCurrentFoodSelection.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblYourCurrentFoodSelection.setBounds(12, 171, 420, 47);
		panelBuyFood.add(lblYourCurrentFoodSelection);
		
		JButton btnPurchaseAndFeed = new JButton("<html><div>Purchase and feed monster</div></html>");
		btnPurchaseAndFeed.setForeground(Color.WHITE);
		btnPurchaseAndFeed.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnPurchaseAndFeed.setBackground(Color.RED);
		btnPurchaseAndFeed.setBounds(12, 235, 353, 31);
		panelBuyFood.add(btnPurchaseAndFeed);
		
		JButton btnPurchaseAndStore = new JButton("<html><div>Purchase and store in inventory</div></html>");
		btnPurchaseAndStore.setForeground(Color.WHITE);
		btnPurchaseAndStore.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnPurchaseAndStore.setBackground(Color.RED);
		btnPurchaseAndStore.setBounds(12, 278, 353, 31);
		panelBuyFood.add(btnPurchaseAndStore);
		
		JPanel panelBuyPotion = new JPanel();
		tabbedPane.addTab("Cafe", null, panelBuyPotion, null);
		panelBuyPotion.setLayout(null);
		
		JPanel panelBuyFood_1 = new JPanel();
		panelBuyFood_1.setLayout(null);
		panelBuyFood_1.setBounds(0, 0, 719, 361);
		panelBuyPotion.add(panelBuyFood_1);
		
		JLabel lblIntroduction_1 = new JLabel("<html><div>Welcome to New World Kaitaia's Cafe. Please select a monster you would like to feed, then select the food you would like to buy.</div></html>");
		lblIntroduction_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblIntroduction_1.setBounds(12, 12, 352, 58);
		panelBuyFood_1.add(lblIntroduction_1);
		
		JComboBox comboBoxMonster_1 = new JComboBox();
		comboBoxMonster_1.setBounds(154, 93, 210, 24);
		panelBuyFood_1.add(comboBoxMonster_1);
		
		JLabel lblSelectAMonster_1 = new JLabel("<html><div>Select a monster:</div></html>");
		lblSelectAMonster_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblSelectAMonster_1.setBounds(12, 82, 124, 47);
		panelBuyFood_1.add(lblSelectAMonster_1);
		
		JLabel lblSelectFood_1 = new JLabel("<html><div>Select food:</div></html>");
		lblSelectFood_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblSelectFood_1.setBounds(12, 117, 124, 47);
		panelBuyFood_1.add(lblSelectFood_1);
		
		JComboBox comboBoxFood_1 = new JComboBox();
		comboBoxFood_1.setBounds(154, 128, 210, 24);
		panelBuyFood_1.add(comboBoxFood_1);
		
		JLabel lblYourCurrentFoodSelection_1 = new JLabel("<html><div>You're selecting Pasta. Pasta increases adds 10% to the monster's health. Pasta costs 20 coins. </div></html>");
		lblYourCurrentFoodSelection_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblYourCurrentFoodSelection_1.setBounds(12, 171, 420, 47);
		panelBuyFood_1.add(lblYourCurrentFoodSelection_1);
		
		JButton btnPurchaseAndFeed_1 = new JButton("<html><div>Purchase and feed monster</div></html>");
		btnPurchaseAndFeed_1.setForeground(Color.WHITE);
		btnPurchaseAndFeed_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnPurchaseAndFeed_1.setBackground(Color.RED);
		btnPurchaseAndFeed_1.setBounds(12, 235, 353, 31);
		panelBuyFood_1.add(btnPurchaseAndFeed_1);
		
		JButton btnPurchaseAndStore_1 = new JButton("<html><div>Purchase and store in inventory</div></html>");
		btnPurchaseAndStore_1.setForeground(Color.WHITE);
		btnPurchaseAndStore_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnPurchaseAndStore_1.setBackground(Color.RED);
		btnPurchaseAndStore_1.setBounds(12, 278, 353, 31);
		panelBuyFood_1.add(btnPurchaseAndStore_1);
		
		JPanel panelTradeInMonster = new JPanel();
		panelTradeInMonster.setLayout(null);
		tabbedPane.addTab("Trade in monsters", null, panelTradeInMonster, null);
		
		JButton btnPurchaseThisMonster_1 = new JButton("Sell back this monster");
		btnPurchaseThisMonster_1.setForeground(Color.WHITE);
		btnPurchaseThisMonster_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnPurchaseThisMonster_1.setBackground(Color.RED);
		btnPurchaseThisMonster_1.setBounds(502, 320, 205, 29);
		panelTradeInMonster.add(btnPurchaseThisMonster_1);
		
		JLabel lblTipClickTo_1_4 = new JLabel("<html><div>New World Kaitaia would like to buy these monsters from you, for these listed prices.</div></html>");
		lblTipClickTo_1_4.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		lblTipClickTo_1_4.setBounds(12, 12, 386, 54);
		panelTradeInMonster.add(lblTipClickTo_1_4);
		
		table = new JTable();
		table.setBounds(12, 75, 456, 106);
		panelTradeInMonster.add(table);
		
		JPanel panelLottoCounter = new JPanel();
		tabbedPane.addTab("Lotto Counter", null, panelLottoCounter, null);
		panelLottoCounter.setLayout(null);
		
		JLabel lblLottoLogo = new JLabel("");
		lblLottoLogo.setIcon(new ImageIcon(ShopScreen.class.getResource("/assets/ui/img/LottoLogo.png")));
		lblLottoLogo.setBounds(12, 49, 376, 168);
		panelLottoCounter.add(lblLottoLogo);
		
		JLabel lblIntroductionLotto = new JLabel("<html><div>Welcome to Lotto NZ. Please play responsibly. Each ticket costs 30 coins, and you can select your own number from 0 to 10. A lotto ticket increases your chance of having positive events occuring overnight.</div></html>");
		lblIntroductionLotto.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblIntroductionLotto.setBounds(413, 49, 294, 168);
		panelLottoCounter.add(lblIntroductionLotto);
		
		JButton btnPurchaseTicket = new JButton("Purchase ticket");
		btnPurchaseTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPurchaseTicket.setForeground(Color.WHITE);
		btnPurchaseTicket.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnPurchaseTicket.setBackground(Color.RED);
		btnPurchaseTicket.setBounds(436, 244, 167, 33);
		panelLottoCounter.add(btnPurchaseTicket);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBackground(Color.YELLOW);
		textField.setBounds(349, 244, 75, 33);
		panelLottoCounter.add(textField);
		
		JLabel lblPrompt = new JLabel("<html><div>Enter a number between 0 and 10: </div></html>");
		lblPrompt.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblPrompt.setBounds(108, 229, 243, 64);
		panelLottoCounter.add(lblPrompt);
		
		JLabel lblYourBalance_1_1_2 = new JLabel("0 gold coins");
		lblYourBalance_1_1_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblYourBalance_1_1_2.setBounds(368, 28, 101, 25);
		window.getContentPane().add(lblYourBalance_1_1_2);
		lblYourBalance_1_1_2.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		
		JButton btnReturnToDashboard = new JButton("Return to Map");
		btnReturnToDashboard.setBackground(SystemColor.info);
		btnReturnToDashboard.setBounds(589, 28, 136, 25);
		window.getContentPane().add(btnReturnToDashboard);
		btnReturnToDashboard.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.setBackground(SystemColor.info);
		btnInventory.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnInventory.setBounds(487, 28, 101, 25);
		window.getContentPane().add(btnInventory);
	}
}
