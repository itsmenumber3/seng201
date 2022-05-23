package ui;

import entities.Entity;
import entities.items.Fuel;
import entities.items.LottoTicket;
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

import assets.enums.DrinkType;
import assets.enums.FoodType;
import assets.libraries.Tools;
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
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ShopScreen {

	private JFrame window;
	private GameEnvironment gameEnvironment;
	private Player player;
	private Inventory inventory;
	private Battle battle;
	private Shop shop;
	private String displayInfo;
	private Monster selectedMonster;
	private int fuelPrice;
	private JButton btnSelectedMonster;

	private Food selectedFood;

	private Drink selectedDrink;

	private final ArrayList<String> foodNameList = new ArrayList<>();
	private final ArrayList<String> drinkNameList = new ArrayList<>();
	
	private String[] foodNames = {"Apple", "Pasta"};
	private String[] drinkNames = {"Coffee", "Energy drink"};
	
	private boolean nextWindowIsInventory;
	private JTextField textField;
	
	private Tools tools = new Tools();
	
	public boolean getNextWindowIsInventory() {
		return nextWindowIsInventory;
	}

	

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
		this.selectedFood = new Food(FoodType.APPLE);
		this.selectedDrink = new Drink(DrinkType.COFFEE);
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
	
	public String getMonsterDisplayInfo(Monster monster) {
		String tempName = monster.getEntityName();
		double tempAttackVal = monster.getMonsterAttackDamage();
		double tempResistanceVal = monster.getMonsterResistanceAbility();
		int tempPurchasePrice = monster.getEntityPurchaseValue();

		return String.format("<html><div>Selected monster details:<br>Monster Type: %s<br>Attack Damage: %.2f<br>Resistance Ability: %.2f<br>Price: %d gold coins.</div></html>",
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
		lblShopName.setBounds(23, 20, 346, 34);
		window.getContentPane().add(lblShopName);
		
		JLabel lblYourBalance_1_1_2 = new JLabel(String.format("%d gold coins", player.getPlayerGold()));
		lblYourBalance_1_1_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblYourBalance_1_1_2.setBounds(368, 28, 101, 25);
		window.getContentPane().add(lblYourBalance_1_1_2);
		lblYourBalance_1_1_2.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 69, 748, 400);
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
						JOptionPane.showMessageDialog(window, "Purchased successfully.");
						selectedMonster.setEntityName(textField.getText());
						btnSelectedMonster.setEnabled(false);
						lblYourBalance_1_1_2.setText(String.format("%d gold coins", player.getPlayerGold()));
					} else {
						inventory.getMonsters().remove(selectedMonster);
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
		lblTip.setBounds(12, 358, 361, 15);
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
		
		textField = new JTextField(tools.generateRandomMonsterName());
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBackground(new Color(230, 230, 250));
		textField.setBounds(575, 277, 132, 33);
		panelPurchaseMonster.add(textField);
		
		JLabel lblNameThisMonster = new JLabel("Name this monster");
		lblNameThisMonster.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		lblNameThisMonster.setBounds(447, 288, 120, 15);
		panelPurchaseMonster.add(lblNameThisMonster);

		// FIRST TAB (BUY MONSTERS) ------------------------------------------------

		// SECOND TAB (DELI) -------------------------------------------------------
		
		JPanel panelBuyFood = new JPanel();
		tabbedPane.addTab("Delicatessen", null, panelBuyFood, null);
		panelBuyFood.setLayout(null);
		
		JLabel lblIntroductionDeli = new JLabel(String.format("<html><div>Welcome to %s's Service Deli. Please select the food you would like to buy.</div></html>", shop.getShopName()));
		lblIntroductionDeli.setBounds(176, 66, 352, 58);
		lblIntroductionDeli.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		panelBuyFood.add(lblIntroductionDeli);
		
		JLabel lblSelectFood = new JLabel("<html><div>Select food:</div></html>");
		lblSelectFood.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblSelectFood.setBounds(176, 136, 124, 47);
		panelBuyFood.add(lblSelectFood);
		
		JLabel lblYourCurrentFoodSelection;
		lblYourCurrentFoodSelection = new JLabel(String.format("<html><div>You're selecting %s which adds %.2f/100 to a monster's health. The price is %d gold coins.</div></html>",
				foodNames[0],
				selectedFood.getConsumableHealValue(),
				selectedFood.getEntityPurchaseValue()
		)
		);
		lblYourCurrentFoodSelection.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblYourCurrentFoodSelection.setBounds(176, 195, 358, 47);
		panelBuyFood.add(lblYourCurrentFoodSelection);

		JButton btnPurchaseAndStoreFood;
		btnPurchaseAndStoreFood = new JButton("<html><div>Purchase</div></html>");
		btnPurchaseAndStoreFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean successStatusPurchaseEntity = player.playerPurchaseEntity(selectedFood);
				if (successStatusPurchaseEntity){
					JOptionPane.showMessageDialog(window, "Purchased successfully.");
					inventory.addFood(selectedFood);
					lblYourBalance_1_1_2.setText(String.format("%d gold coins", player.getPlayerGold()));
				} else {
					JOptionPane.showMessageDialog(window, "Insufficient funds.");
				}
			}
		});
		btnPurchaseAndStoreFood.setForeground(Color.WHITE);
		btnPurchaseAndStoreFood.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnPurchaseAndStoreFood.setBackground(Color.RED);
		btnPurchaseAndStoreFood.setBounds(176, 260, 353, 31);
		panelBuyFood.add(btnPurchaseAndStoreFood);
		
		JComboBox comboBoxFood = new JComboBox(foodNames);
		comboBoxFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedFood = player.getFoodRange()[comboBoxFood.getSelectedIndex()];
				lblYourCurrentFoodSelection.setText(String.format("<html><div>You're selecting %s which adds %.2f/100 to a monster's health. The price is %d gold coins.</div></html>", 
						foodNames[comboBoxFood.getSelectedIndex()],
						selectedFood.getConsumableHealValue(),
						selectedFood.getEntityPurchaseValue()
						)
				);
				
				
			}
		});
		comboBoxFood.setModel(new DefaultComboBoxModel(foodNames));
		comboBoxFood.setBounds(318, 147, 210, 24);
		panelBuyFood.add(comboBoxFood);	

		
		JPanel panelBuyCafe = new JPanel();
		tabbedPane.addTab("Cafe", null, panelBuyCafe, null);
		panelBuyCafe.setLayout(null);

		
		JLabel lblIntroductionCafe = new JLabel(String.format("<html><div>Welcome to %s's Cafe. Please select the drink you would like to buy.</div></html>", shop.getShopName()));
		lblIntroductionCafe.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblIntroductionCafe.setBounds(171, 60, 352, 58);
		panelBuyCafe.add(lblIntroductionCafe);
		
		JLabel lblselectADrink = new JLabel("<html><div>Select a drink:</div></html>");
		lblselectADrink.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblselectADrink.setBounds(171, 130, 124, 47);
		panelBuyCafe.add(lblselectADrink);
		
		JLabel lblYourCurrentDrinkSelection;
		lblYourCurrentDrinkSelection = new JLabel(String.format("<html><div>You're selecting %s which adds %.2f/100 to a monster's health. The price is %d gold coins.</div></html>",
				drinkNames[0],
				selectedDrink.getConsumableHealValue(),
				selectedDrink.getEntityPurchaseValue()
		)
		);
		lblYourCurrentDrinkSelection.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblYourCurrentDrinkSelection.setBounds(171, 189, 358, 47);
		panelBuyCafe.add(lblYourCurrentDrinkSelection);

		JButton btnPurchaseAndStoreDrink;
		
		JComboBox comboBoxDrinks = new JComboBox(drinkNames);
		comboBoxDrinks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedDrink = player.getDrinkRange()[comboBoxDrinks.getSelectedIndex()];
				lblYourCurrentDrinkSelection.setText(String.format("<html><div>You're selecting %s which adds %.2f/100 to a monster's health. The price is %d gold coins.</div></html>", 
						drinkNames[comboBoxDrinks.getSelectedIndex()],
						selectedDrink.getConsumableHealValue(),
						selectedDrink.getEntityPurchaseValue()
						));
			}
		});
		comboBoxDrinks.setModel(new DefaultComboBoxModel(drinkNames));
		comboBoxDrinks.setBounds(313, 141, 210, 24);
		panelBuyCafe.add(comboBoxDrinks);
		

		
		btnPurchaseAndStoreDrink = new JButton("<html><div>Purchase</div></html>");
		btnPurchaseAndStoreDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (player.playerPurchaseEntity(selectedDrink)){
					JOptionPane.showMessageDialog(window, "Purchased successfully.");
					inventory.addDrink(selectedDrink);
					lblYourBalance_1_1_2.setText(String.format("%d gold coins", player.getPlayerGold()));
				} else {
					JOptionPane.showMessageDialog(window, "Insufficient funds.");
				}
			}
		});
		btnPurchaseAndStoreDrink.setForeground(Color.WHITE);
		btnPurchaseAndStoreDrink.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnPurchaseAndStoreDrink.setBackground(Color.RED);
		btnPurchaseAndStoreDrink.setBounds(171, 254, 353, 31);
		panelBuyCafe.add(btnPurchaseAndStoreDrink);
		
		JPanel panelLottoCounter = new JPanel();
		tabbedPane.addTab("Lotto Counter", null, panelLottoCounter, null);
		panelLottoCounter.setLayout(null);
		
		JSlider sliderLotto = new JSlider();
		sliderLotto.setValue(1);
		sliderLotto.setSnapToTicks(true);
		sliderLotto.setPaintTicks(true);
		sliderLotto.setPaintLabels(true);
		sliderLotto.setOpaque(false);
		sliderLotto.setMinorTickSpacing(1);
		sliderLotto.setMinimum(1);
		sliderLotto.setMaximum(10);
		sliderLotto.setMajorTickSpacing(1);
		sliderLotto.setForeground(Color.BLACK);
		sliderLotto.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		sliderLotto.setBounds(198, 222, 279, 50);
		panelLottoCounter.add(sliderLotto);
		
		JLabel lblLottoLogo = new JLabel("");
		lblLottoLogo.setIcon(new ImageIcon(ShopScreen.class.getResource("/assets/ui/img/LottoLogo.png")));
		lblLottoLogo.setBounds(12, 12, 376, 168);
		panelLottoCounter.add(lblLottoLogo);
		
		JLabel lblIntroductionLotto = new JLabel("<html><div>Welcome to Lotto NZ. Please play responsibly. Each ticket costs 30 coins, and you can select your own number from 0 to 10. A lotto ticket increases your chance of having positive events occuring overnight.</div></html>");
		lblIntroductionLotto.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblIntroductionLotto.setBounds(413, 12, 294, 168);
		panelLottoCounter.add(lblIntroductionLotto);
		
		JButton btnPurchaseTicket = new JButton("Purchase ticket");
		btnPurchaseTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (inventory.getLottoTicket() != null) {
					JOptionPane.showMessageDialog(window, "You've already bought a lotto ticket for today. Too much gambling is bad.");
				} else {
					LottoTicket lotto = new LottoTicket();
					lotto.setEntityPurchaseValue(30);
					lotto.setLottoTicketNumber(sliderLotto.getValue());
					boolean successStatusPurchaseEntity = player.playerPurchaseEntity(lotto);
					if (successStatusPurchaseEntity){
						JOptionPane.showMessageDialog(window, "Purchased successfully.");
						inventory.setLottoTicket(lotto);
						lblYourBalance_1_1_2.setText(String.format("%d gold coins", player.getPlayerGold()));
					} else {
						JOptionPane.showMessageDialog(window, "Insufficient funds.");
					}
				}
				
			}
		});
		btnPurchaseTicket.setForeground(Color.WHITE);
		btnPurchaseTicket.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnPurchaseTicket.setBackground(Color.RED);
		btnPurchaseTicket.setBounds(198, 284, 167, 33);
		panelLottoCounter.add(btnPurchaseTicket);
		
		JLabel lblPrompt = new JLabel("<html><div>Choose a number between 0 and 10: </div></html>");
		lblPrompt.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblPrompt.setBounds(198, 164, 243, 64);
		panelLottoCounter.add(lblPrompt);
		
		JPanel panelServo = new JPanel();
		tabbedPane.addTab("Service Station", null, panelServo, null);
		panelServo.setLayout(null);
		
		JLabel lblIntroduction_1 = new JLabel("");
		lblIntroduction_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblIntroduction_1.setBounds(199, 145, 352, 50);
		panelServo.add(lblIntroduction_1);
		
		JLabel lblIntroduction = new JLabel(String.format("<html><div>Welcome to the Service Station. Please indicate how much fuel you need to top up, and we'll quote the amount in gold coins."
				+ "<br><br>You currently have %.2f/100 in your fuel tank.</div></html>", inventory.getFuelAmount()));
		lblIntroduction.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblIntroduction.setBounds(199, 35, 352, 111);
		panelServo.add(lblIntroduction);
		
		JSlider sliderNumberofDays = new JSlider();
		sliderNumberofDays.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				fuelPrice = sliderNumberofDays.getValue();
				lblIntroduction_1.setText(String.format("<html><div>Your selected amount costs %d gold coins.</div></html>", fuelPrice));
			}
		});
		sliderNumberofDays.setValue(10);
		sliderNumberofDays.setSnapToTicks(true);
		sliderNumberofDays.setPaintTicks(true);
		sliderNumberofDays.setPaintLabels(true);
		sliderNumberofDays.setOpaque(false);
		sliderNumberofDays.setMinorTickSpacing(10);
		sliderNumberofDays.setMinimum(10);
		sliderNumberofDays.setMajorTickSpacing(10);
		sliderNumberofDays.setForeground(Color.BLACK);
		sliderNumberofDays.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		sliderNumberofDays.setBounds(194, 200, 347, 50);
		panelServo.add(sliderNumberofDays);
		
		JButton btnPurchaseFuel = new JButton("Purchase fuel");
		btnPurchaseFuel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (inventory.getFuelAmount() >= 100) {
					JOptionPane.showMessageDialog(window, "You've already got 100% fuel.");
				} else {
					Fuel fuel = new Fuel();
					fuel.setEntityPurchaseValue(sliderNumberofDays.getValue());
					boolean successStatusPurchaseEntity = player.playerPurchaseEntity(fuel);
					if (successStatusPurchaseEntity){
						JOptionPane.showMessageDialog(window, "Purchased successfully.");
						inventory.refillFuel(sliderNumberofDays.getValue());
						lblYourBalance_1_1_2.setText(String.format("%d gold coins", player.getPlayerGold()));
					} else {
						JOptionPane.showMessageDialog(window, "Insufficient funds.");
					}
				}
			}
		});
		btnPurchaseFuel.setForeground(Color.WHITE);
		btnPurchaseFuel.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnPurchaseFuel.setBackground(Color.RED);
		btnPurchaseFuel.setBounds(194, 262, 226, 33);
		panelServo.add(btnPurchaseFuel);
		
		JButton btnReturnToDashboard = new JButton("Return to Map");
		btnReturnToDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nextWindowIsInventory = false;
				finishedWindow();
			}
		});
		btnReturnToDashboard.setBackground(SystemColor.info);
		btnReturnToDashboard.setBounds(589, 28, 136, 25);
		window.getContentPane().add(btnReturnToDashboard);
		btnReturnToDashboard.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nextWindowIsInventory = true;
				finishedWindow();
			}
		});
		btnInventory.setBackground(SystemColor.info);
		btnInventory.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnInventory.setBounds(487, 28, 101, 25);
		window.getContentPane().add(btnInventory);
	}
}
