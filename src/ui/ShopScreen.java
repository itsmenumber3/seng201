package ui;

import entities.Entity;
import entities.items.consumables.Drink;
import entities.items.consumables.Food;
import main.GameEnvironment;
import main.Inventory;
import main.Player;
import main.Shop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import battles.Battle;
import entities.monsters.Monster;

import java.awt.SystemColor;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JSpinner;

public class ShopScreen {

	private JFrame window;
	private JTextField textField;
	private JTable table;
	private GameEnvironment gameEnvironment;
	private Player player;
	private Inventory inventory;
	private Battle battle;
	private Shop shop;
	private String displayInfo;
	private Monster selectedMonster;

	private JButton btnSelectedMonster;

	private String selectedFoodMonsterName;
	private Monster selectedFoodMonster;
	private String selectedDrinkMonsterName;
	private Monster selectedDrinkMonster;
	private String selectedFoodName;
	private Food selectedFood;
	private String selectedDrinkName;

	private Drink selectedDrink;
	private final ArrayList<String> monsterNameList = new ArrayList<>();
	private final ArrayList<String> foodNameList = new ArrayList<>();
	private final ArrayList<String> drinkNameList = new ArrayList<>();

	

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
		this.shop = battle.getBattleShop();
		setMonsterNameList();
		setFoodNameList();
		setDrinkNameList();
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
	
	public void setMonsterNameList(){
		int monsterLength = inventory.getMonsters().size();
		
		for (int i = 0; (i < monsterLength); i++) {
			monsterNameList.add(inventory.getMonsters().get(i).getEntityName());
		}
	}

	public Monster getMonsterFromName(String selectedMonsterName){
		int monsterIndex = monsterNameList.indexOf(selectedMonsterName);
		return inventory.getMonsters().get(monsterIndex);
	}
	
	public void setFoodNameList() {
		int foodLength = player.getFoodRange().size();
		
		for (int i = 0; (i < foodLength); i++) {
			foodNameList.add(player.getFoodRange().get(i).getEntityName());
		}
	}

	public Food getFoodFromName(){
		int foodIndex = foodNameList.indexOf(selectedFoodName);
		return player.getFoodRange().get(foodIndex);
	}
	
	public void setDrinkNameList() {
		int drinkLength = player.getDrinkRange().size();
		
		for (int i = 0; (i < drinkLength);i++) {
			drinkNameList.add(player.getDrinkRange().get(i).getEntityName());
		}
	}

	public Drink getDrinkFromName(){
		int drinkIndex = drinkNameList.indexOf(selectedDrinkName);
		return player.getDrinkRange().get(drinkIndex);
	}
	
	public String getMonsterDisplayInfo(Monster monster) {
		String tempName = monster.getEntityName();
		double tempAttackVal = monster.getMonsterAttackDamage();
		double tempResistanceVal = monster.getMonsterResistanceAbility();
		int tempPurchasePrice = monster.getEntityPurchaseValue();

		return String.format("<html><div>Selected monster details:<br>Name: %s<br>Attack Damage: %.2f<br>Resistance Ability: %.2f<br>Price: $%.2f</div></html>",
				tempName, tempAttackVal, tempResistanceVal, tempPurchasePrice);
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

		// FIRST TAB (BUY MONSTERS) ------------------------------------------------
		JPanel panelPurchaseMonster = new JPanel();
		tabbedPane.addTab("Buy Monsters", null, panelPurchaseMonster, "");
		tabbedPane.setEnabledAt(0, true);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		panelPurchaseMonster.setLayout(null);
		
		JLabel lblYourCurrentSelection = new JLabel();
		lblYourCurrentSelection.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		lblYourCurrentSelection.setBounds(12, 249, 258, 89);
		panelPurchaseMonster.add(lblYourCurrentSelection);
		
		JButton btnPurchaseThisMonster = new JButton("Purchase this monster");
		btnPurchaseThisMonster.setEnabled(false);
		btnPurchaseThisMonster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean successStatusAddMonster = inventory.addMonster(selectedMonster);
				if (successStatusAddMonster) {
					boolean successStatusPurchaseEntity = player.playerPurchaseEntity(selectedMonster);
					if (successStatusPurchaseEntity){
						inventory.addMonster(selectedMonster);
						btnSelectedMonster.setEnabled(false);
					} else {

						JOptionPane.showMessageDialog(window, "Insufficient funds.");

					}
				} else {
					JOptionPane.showMessageDialog(window, "You've already got the maximum number of monsters allowed.");
				}
			}

		});
		btnPurchaseThisMonster.setForeground(Color.WHITE);
		btnPurchaseThisMonster.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnPurchaseThisMonster.setBackground(Color.RED);
		btnPurchaseThisMonster.setBounds(508, 320, 199, 29);
		panelPurchaseMonster.add(btnPurchaseThisMonster);
		
		JButton btnMonster1 = new JButton(shop.getShopMonsterRange().get(0).getEntityName());
		btnMonster1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSelectedMonster = btnMonster1;
				selectedMonster = shop.getShopMonsterRange().get(0);
				displayInfo = getMonsterDisplayInfo(selectedMonster);
				lblYourCurrentSelection.setText(displayInfo);
				btnPurchaseThisMonster.setEnabled(true);
			}
		});
		btnMonster1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster1.setBackground(SystemColor.info);
		btnMonster1.setBounds(12, 224, 111, 25);
		panelPurchaseMonster.add(btnMonster1);
		
		JButton btnMonster2 = new JButton(shop.getShopMonsterRange().get(1).getEntityName());
		btnMonster2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSelectedMonster = btnMonster2;
				selectedMonster = shop.getShopMonsterRange().get(1);
				displayInfo = getMonsterDisplayInfo(selectedMonster);
				lblYourCurrentSelection.setText(displayInfo);
				btnPurchaseThisMonster.setEnabled(true);
			}
		});
		btnMonster2.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster2.setBackground(SystemColor.info);
		btnMonster2.setBounds(155, 224, 111, 25);
		panelPurchaseMonster.add(btnMonster2);
		
		JButton btnMonster3 = new JButton(shop.getShopMonsterRange().get(2).getEntityName());
		btnMonster3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSelectedMonster = btnMonster3;
				selectedMonster = shop.getShopMonsterRange().get(2);
				displayInfo = getMonsterDisplayInfo(selectedMonster);
				lblYourCurrentSelection.setText(displayInfo);
				btnPurchaseThisMonster.setEnabled(true);
			}
		});
		btnMonster3.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster3.setBackground(SystemColor.info);
		btnMonster3.setBounds(299, 224, 111, 25);
		panelPurchaseMonster.add(btnMonster3);
		
		JButton btnMonster4 = new JButton(shop.getShopMonsterRange().get(3).getEntityName());
		btnMonster4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSelectedMonster = btnMonster4;
				selectedMonster = shop.getShopMonsterRange().get(3);
				displayInfo = getMonsterDisplayInfo(selectedMonster);
				lblYourCurrentSelection.setText(displayInfo);
				btnPurchaseThisMonster.setEnabled(true);
			}
		});
		btnMonster4.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster4.setBackground(SystemColor.info);
		btnMonster4.setBounds(446, 224, 111, 25);
		panelPurchaseMonster.add(btnMonster4);
		
		JButton btnMonster5 = new JButton(shop.getShopMonsterRange().get(4).getEntityName());
		btnMonster5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSelectedMonster = btnMonster5;
				selectedMonster = shop.getShopMonsterRange().get(4);
				displayInfo = getMonsterDisplayInfo(selectedMonster);
				lblYourCurrentSelection.setText(displayInfo);
				btnPurchaseThisMonster.setEnabled(true);
			}
		});
		btnMonster5.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster5.setBackground(SystemColor.info);
		btnMonster5.setBounds(596, 224, 111, 25);
		panelPurchaseMonster.add(btnMonster5);
		
		JLabel lblTip = new JLabel("Tip: click to view properties, then press Purchase this monster.");
		lblTip.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		lblTip.setBounds(12, 350, 361, 15);
		panelPurchaseMonster.add(lblTip);
		
		JLabel lblMonster1Img = new JLabel("");
		lblMonster1Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster1Img.setIcon(new ImageIcon(ShopScreen.class.getResource(shop.getShopMonsterRange().get(0).getEntityImagePath())));
		lblMonster1Img.setBounds(12, 12, 111, 200);
		panelPurchaseMonster.add(lblMonster1Img);
		
		JLabel lblMonster2Img = new JLabel("");
		lblMonster2Img.setIcon(new ImageIcon(ShopScreen.class.getResource(shop.getShopMonsterRange().get(1).getEntityImagePath())));
		lblMonster2Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster2Img.setBounds(155, 12, 111, 200);
		panelPurchaseMonster.add(lblMonster2Img);
		
		JLabel lblMonster3Img = new JLabel("");
		lblMonster3Img.setIcon(new ImageIcon(ShopScreen.class.getResource(shop.getShopMonsterRange().get(2).getEntityImagePath())));
		lblMonster3Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster3Img.setBounds(299, 12, 111, 200);
		panelPurchaseMonster.add(lblMonster3Img);
		
		JLabel lblMonster4Img = new JLabel("");
		lblMonster4Img.setIcon(new ImageIcon(ShopScreen.class.getResource(shop.getShopMonsterRange().get(3).getEntityImagePath())));
		lblMonster4Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster4Img.setBounds(446, 12, 111, 200);
		panelPurchaseMonster.add(lblMonster4Img);
		
		JLabel lblMonster5Img = new JLabel("");
		lblMonster5Img.setIcon(new ImageIcon(ShopScreen.class.getResource(shop.getShopMonsterRange().get(4).getEntityImagePath())));
		lblMonster5Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster5Img.setBounds(596, 12, 111, 200);
		panelPurchaseMonster.add(lblMonster5Img);
		
		JPanel panelBuyFood = new JPanel();
		tabbedPane.addTab("Delicatessen", null, panelBuyFood, null);
		panelBuyFood.setLayout(null);
		
		JLabel lblIntroductionDeli = new JLabel(String.format("<html><div>Welcome to %s's Service Deli. Please select a monster you would like to feed, then select the food you would like to buy.</div></html>", shop.getShopName()));
		lblIntroductionDeli.setBounds(12, 12, 352, 58);
		lblIntroductionDeli.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		panelBuyFood.add(lblIntroductionDeli);
		
		JComboBox comboBoxMonsterFood = new JComboBox((ComboBoxModel) monsterNameList);
		comboBoxMonsterFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedFoodMonsterName = comboBoxMonsterFood.getSelectedItem();
				selectedFoodMonster = getMonsterFromName(selectedFoodMonsterName);
			}
		});
		comboBoxMonsterFood.setBounds(154, 93, 210, 24);
		panelBuyFood.add(comboBoxMonsterFood);
		
		JLabel lblSelectAMonsterFood = new JLabel("<html><div>Select a monster:</div></html>");
		lblSelectAMonsterFood.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblSelectAMonsterFood.setBounds(12, 82, 124, 47);
		panelBuyFood.add(lblSelectAMonsterFood);
		
		JLabel lblSelectFood = new JLabel("<html><div>Select food:</div></html>");
		lblSelectFood.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblSelectFood.setBounds(12, 117, 124, 47);
		panelBuyFood.add(lblSelectFood);
		
		JComboBox comboBoxFood = new JComboBox((ComboBoxModel) foodNameList);
		comboBoxFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedFoodName = comboBoxFood.getSelectedItem();
				selectedFood = getFoodFromName();
			}
		});
		comboBoxFood.setBounds(154, 128, 210, 24);
		panelBuyFood.add(comboBoxFood);
		
		JLabel lblYourCurrentFoodSelection = new JLabel(String.format("<html><div>You're selecting %1$s. %1$s increases adds %:.2f% to the monster's health. %1$s costs %:.2f coins. </div></html>",
				selectedFood.getEntityName(), selectedFood.getHealthIncrease(), selectedFood.getEntitySellValue()));
		lblYourCurrentFoodSelection.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblYourCurrentFoodSelection.setBounds(12, 171, 420, 47);
		panelBuyFood.add(lblYourCurrentFoodSelection);
		
		JButton btnPurchaseAndFeed = new JButton("<html><div>Purchase and feed monster</div></html>");
		btnPurchaseAndFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (player.playerPurchaseEntity(selectedFood)){
					//inventory.getMonsters().get selectedFood.getHealthIncrease();
				}
				else{
					JOptionPane.showMessageDialog(window, "Error: Insufficient Funds");
				}
			}
		});
		btnPurchaseAndFeed.setForeground(Color.WHITE);
		btnPurchaseAndFeed.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnPurchaseAndFeed.setBackground(Color.RED);
		btnPurchaseAndFeed.setBounds(12, 235, 353, 31);
		panelBuyFood.add(btnPurchaseAndFeed);
		
		JButton btnPurchaseAndStoreFood = new JButton("<html><div>Purchase and store in inventory</div></html>");
		btnPurchaseAndStoreFood.setForeground(Color.WHITE);
		btnPurchaseAndStoreFood.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnPurchaseAndStoreFood.setBackground(Color.RED);
		btnPurchaseAndStoreFood.setBounds(12, 278, 353, 31);
		panelBuyFood.add(btnPurchaseAndStoreFood);
		
		JPanel panelBuyCafe = new JPanel();
		tabbedPane.addTab("Cafe", null, panelBuyCafe, null);
		panelBuyCafe.setLayout(null);

		
		JLabel lblIntroductionCafe = new JLabel(String.format("<html><div>Welcome to %s's Cafe. Please select a monster you would like to hydrate, then select the drink you would like to buy.</div></html>", shop.getShopName()));
		lblIntroductionCafe.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblIntroductionCafe.setBounds(12, 12, 352, 58);
		panelBuyCafe.add(lblIntroductionCafe);
		
		JComboBox comboBoxMonsterDrink = new JComboBox((ComboBoxModel) monsterNameList);
		comboBoxMonsterDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedDrinkMonsterName = comboBoxMonsterDrink.getSelectedItem();
				selectedDrinkMonster = getMonsterFromName(selectedDrinkMonsterName);
			}
		});
		comboBoxMonsterDrink.setBounds(154, 93, 210, 24);
		panelBuyCafe.add(comboBoxMonsterDrink);
		
		JLabel lblSelectAMonsterCafe = new JLabel("<html><div>Select a monster:</div></html>");
		lblSelectAMonsterCafe.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblSelectAMonsterCafe.setBounds(12, 82, 124, 47);
		panelBuyCafe.add(lblSelectAMonsterCafe);
		
		JLabel lblSelectDrink = new JLabel("<html><div>Select food:</div></html>");
		lblSelectDrink.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblSelectDrink.setBounds(12, 117, 124, 47);
		panelBuyCafe.add(lblSelectDrink);
		
		JComboBox comboBoxDrink = new JComboBox((ComboBoxModel) drinkNameList);
		comboBoxDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedDrinkName = comboBoxDrink.getSelectedItem();
				selectedDrink = getDrinkFromName();
			}
		});
		comboBoxDrink.setBounds(154, 128, 210, 24);
		panelBuyCafe.add(comboBoxDrink);
		
		JLabel lblYourCurrentDrinkSelection = new JLabel(String.format("<html><div>You're selecting %1$s. %1$s increases adds %:.2f% to the monster's health. %1$s costs %:.2f coins. </div></html>",
				selectedDrink.getEntityName(), selectedDrink.getHealthIncrease(), selectedDrink.getEntitySellValue()));
		lblYourCurrentDrinkSelection.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblYourCurrentDrinkSelection.setBounds(12, 171, 420, 47);
		panelBuyCafe.add(lblYourCurrentDrinkSelection);
		
		JButton btnPurchaseAndDrink = new JButton("<html><div>Purchase and feed monster</div></html>");
		btnPurchaseAndDrink.setForeground(Color.WHITE);
		btnPurchaseAndDrink.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnPurchaseAndDrink.setBackground(Color.RED);
		btnPurchaseAndDrink.setBounds(12, 235, 353, 31);
		panelBuyCafe.add(btnPurchaseAndDrink);
		
		JButton btnPurchaseAndStoreDrink = new JButton("<html><div>Purchase and store in inventory</div></html>");
		btnPurchaseAndStoreDrink.setForeground(Color.WHITE);
		btnPurchaseAndStoreDrink.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnPurchaseAndStoreDrink.setBackground(Color.RED);
		btnPurchaseAndStoreDrink.setBounds(12, 278, 353, 31);
		panelBuyCafe.add(btnPurchaseAndStoreDrink);
		
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
