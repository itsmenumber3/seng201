package ui;

import assets.libraries.Tools;
import main.GameEnvironment;
import main.Inventory;
import main.Player;

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
import entities.items.consumables.Drink;
import entities.items.consumables.Food;
import entities.monsters.Monster;

import java.awt.SystemColor;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.HashMap;

public class InventoryScreen {

	private JFrame window;
	private GameEnvironment gameEnvironment;
	private Player player;
	private Battle battle;
	private Inventory inventory;
	private ArrayList<Monster> monsters;
	private HashMap<Food, Integer> inventoryFoods;
	private HashMap<Drink, Integer> inventoryDrinks;
	private double fuelAmount;
	private Monster currentClickMonster;
	private String monsterDescriptionString = "<html><div>Attack Damage: %2.f<br>Resistance Ability: %.2f<br>Current health: %.2f<br>Sellback Price: %d</div></html>";
	private String[] monsterNames;       
	private String[] foodNames = {"Apple", "Pasta"};
	private String[] drinkNames = {"Coffee", "Energy drink"};
	
	private JButton btnMonster4;
	private JButton btnMonster3;
	private JButton btnMonster2;
	private JButton btnMonster1;
	private JLabel lblMonsterInfo;
	private JButton btnInFrontOfTeam;
	
	private JLabel lblMonster1Img;
	private JLabel lblMonster2Img;
	private JLabel lblMonster3Img;
	private JLabel lblMonster4Img;
	private boolean nextWindowIsMap;
	private Tools tools = new Tools();
	
	public boolean getNextWindowIsMap() {
		return this.nextWindowIsMap;
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

	public InventoryScreen(GameEnvironment inputGameEnvironment) {
		this.gameEnvironment = inputGameEnvironment;
		this.player = gameEnvironment.getPlayer();
		this.inventory = player.getPlayerInventory();
		monsters = inventory.getMonsters();
		monsterNames = tools.getMonsterNames(player);
		inventoryFoods = inventory.getFoods();
		inventoryDrinks = inventory.getDrinks();
		fuelAmount = inventory.getFuelAmount();
		initialize();
		window.setVisible(true);
	}

	public void closeWindow() {
		window.dispose();
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
	
	public void updateMonsters() {
		switch(monsters.size()) {
		case 4:
			btnMonster4.setEnabled(true);
			btnMonster4.setText(monsters.get(3).getEntityName());
			lblMonster4Img.setIcon(new ImageIcon(InventoryScreen.class.getResource(monsters.get(3).getEntityImagePath())));
			btnMonster4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					currentClickMonster = monsters.get(3);
					lblMonsterInfo.setText(String.format(monsterDescriptionString, currentClickMonster.getMonsterAttackDamage(), currentClickMonster.getMonsterResistanceAbility(),
							currentClickMonster.getEntitySellValue()));
					btnInFrontOfTeam.setEnabled(true);
				}
			});
			lblMonster4Img.setIcon(new ImageIcon(InventoryScreen.class.getResource(monsters.get(3).getEntityImagePath())));
		case 3:
			btnMonster3.setEnabled(true);
			btnMonster3.setText(monsters.get(2).getEntityName());
			lblMonster3Img.setIcon(new ImageIcon(InventoryScreen.class.getResource(monsters.get(2).getEntityImagePath())));
			btnMonster3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					currentClickMonster = monsters.get(2);
					lblMonsterInfo.setText(String.format(monsterDescriptionString, currentClickMonster.getMonsterAttackDamage(), currentClickMonster.getMonsterResistanceAbility(),
							currentClickMonster.getEntitySellValue()));
					btnInFrontOfTeam.setEnabled(true);
				}
			});
			lblMonster3Img.setIcon(new ImageIcon(InventoryScreen.class.getResource(monsters.get(2).getEntityImagePath())));
		case 2:
			btnMonster2.setEnabled(true);
			btnMonster2.setText(monsters.get(1).getEntityName());
			lblMonster2Img.setIcon(new ImageIcon(InventoryScreen.class.getResource(monsters.get(1).getEntityImagePath())));
			btnMonster2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					currentClickMonster = monsters.get(1);
					lblMonsterInfo.setText(String.format(monsterDescriptionString, currentClickMonster.getMonsterAttackDamage(), currentClickMonster.getMonsterResistanceAbility(),
							currentClickMonster.getEntitySellValue()));
					btnInFrontOfTeam.setEnabled(true);
				}
			});
			lblMonster2Img.setIcon(new ImageIcon(InventoryScreen.class.getResource(monsters.get(1).getEntityImagePath())));
		default:
			btnMonster1.setEnabled(true);
			btnMonster1.setText(monsters.get(0).getEntityName());
			lblMonster1Img.setIcon(new ImageIcon(InventoryScreen.class.getResource(monsters.get(0).getEntityImagePath())));
			btnMonster1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					currentClickMonster = monsters.get(0);
					lblMonsterInfo.setText(String.format(monsterDescriptionString, currentClickMonster.getMonsterAttackDamage(), currentClickMonster.getMonsterResistanceAbility(),
							currentClickMonster.getEntitySellValue()));
					btnInFrontOfTeam.setEnabled(true);
				}
			});
			break;
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Inventory");
		window.setBounds(100, 100, 750, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblNauMaiWelcome = new JLabel("Inventory");
		lblNauMaiWelcome.setFont(new Font("Century Schoolbook L", Font.BOLD, 24));
		lblNauMaiWelcome.setBounds(12, 20, 261, 34);
		window.getContentPane().add(lblNauMaiWelcome);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 69, 724, 388);
		window.getContentPane().add(tabbedPane);
		
		JPanel panelMonsters = new JPanel();
		tabbedPane.addTab("Your Monsters", null, panelMonsters, "");
		tabbedPane.setEnabledAt(0, true);
		tabbedPane.setBackgroundAt(0, SystemColor.menu);
		panelMonsters.setLayout(null);
		
		JLabel lblMonsterInfo = new JLabel();
		lblMonsterInfo.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblMonsterInfo.setBounds(12, 261, 377, 88);
		panelMonsters.add(lblMonsterInfo);
		
		btnMonster1 = new JButton("");
		btnMonster1.setEnabled(false);
		btnMonster1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster1.setBackground(SystemColor.info);
		btnMonster1.setBounds(12, 224, 111, 25);
		panelMonsters.add(btnMonster1);
		
		btnMonster2 = new JButton("");
		btnMonster2.setEnabled(false);
		btnMonster2.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster2.setBackground(SystemColor.info);
		btnMonster2.setBounds(155, 224, 111, 25);
		panelMonsters.add(btnMonster2);
		
		btnMonster3 = new JButton("");
		btnMonster3.setEnabled(false);
		btnMonster3.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster3.setBackground(SystemColor.info);
		btnMonster3.setBounds(299, 224, 111, 25);
		panelMonsters.add(btnMonster3);
		
		btnMonster4 = new JButton("");
		btnMonster4.setEnabled(false);
		btnMonster4.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster4.setBackground(SystemColor.info);
		btnMonster4.setBounds(446, 224, 111, 25);
		panelMonsters.add(btnMonster4);
		
		JLabel lblMonster1Img = new JLabel("");
		lblMonster1Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster1Img.setBounds(12, 12, 111, 200);
		panelMonsters.add(lblMonster1Img);
		
		JLabel lblMonster2Img = new JLabel("");
		lblMonster2Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster2Img.setBounds(155, 12, 111, 200);
		panelMonsters.add(lblMonster2Img);
		
		JLabel lblMonster3Img = new JLabel("");
		lblMonster3Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster3Img.setBounds(299, 12, 111, 200);
		panelMonsters.add(lblMonster3Img);
		
		JLabel lblMonster4Img = new JLabel("");
		lblMonster4Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster4Img.setBounds(446, 12, 111, 200);
		panelMonsters.add(lblMonster4Img);
		
		updateMonsters();
		
		btnInFrontOfTeam = new JButton("<html><div>Set selected monster to front of team</div></html>");
		btnInFrontOfTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				monsters.remove(currentClickMonster);
				monsters.add(0, currentClickMonster);
				updateMonsters();
			}
		});
		btnInFrontOfTeam.setEnabled(false);
		btnInFrontOfTeam.setForeground(Color.WHITE);
		btnInFrontOfTeam.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnInFrontOfTeam.setBackground(Color.RED);
		btnInFrontOfTeam.setBounds(407, 309, 300, 40);
		panelMonsters.add(btnInFrontOfTeam);
		
		JPanel panelFood = new JPanel();
		tabbedPane.addTab("Food Chest", null, panelFood, null);
		panelFood.setLayout(null);
		
		JLabel lblSelectedMonster;
		
		JComboBox comboBoxMonster = new JComboBox(monsterNames);
		comboBoxMonster.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lblSelectedMonster.setText(String.format("<html><div>The health level of %s is %.2f/100.</div></html>", 
						monsters.get(comboBoxMonster.getSelectedIndex()).getEntityName(), 
						monsters.get(comboBoxMonster.getSelectedIndex()).getMonsterHealthLevel()
						)
				);
			}
		});
		comboBoxMonster.setBounds(157, 26, 210, 24);
		comboBoxMonster.setModel(new DefaultComboBoxModel(monsterNames));
		panelFood.add(comboBoxMonster);
		
		lblSelectedMonster = new JLabel(String.format("<html><div>The health level of %s is %.2f/100.</div></html>", 
				monsters.get(comboBoxMonster.getSelectedIndex()).getEntityName(), 
				monsters.get(comboBoxMonster.getSelectedIndex()).getMonsterHealthLevel()));
		
		lblSelectedMonster.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblSelectedMonster.setBounds(12, 109, 420, 47);
		panelFood.add(lblSelectedMonster);
		
		
		
		JLabel lblSelectedFood;
		JButton btnFeedNow;
		
		JComboBox comboBoxFood = new JComboBox(foodNames);
		comboBoxFood.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lblSelectedFood.setText(String.format("<html><div>You're selecting %s which adds %.2f/100 to a monster's health. You have %d of these in your inventory.</div></html>", 
						foodNames[comboBoxFood.getSelectedIndex()],
						player.getFoodRange().get(comboBoxFood.getSelectedIndex()).getHealthIncrease(),
						inventoryFoods.get(player.getFoodRange().get(comboBoxFood.getSelectedIndex()))
						)
				);
				if (inventoryFoods.get(player.getFoodRange().get(comboBoxFood.getSelectedIndex())) > 0) {
					btnFeedNow.setEnabled(true);
				}lblSelectedFood.setText(String.format("<html><div>You're selecting %s which adds %.2f/100 to a monster's health. You have %d of these in your inventory.</div></html>", 
						foodNames[comboBoxFood.getSelectedIndex()],
						player.getFoodRange().get(comboBoxFood.getSelectedIndex()).getHealthIncrease(),
						inventoryFoods.get(player.getFoodRange().get(comboBoxFood.getSelectedIndex()))
						)
				);
				if (inventoryFoods.get(player.getFoodRange().get(comboBoxFood.getSelectedIndex())) > 0) {
					btnFeedNow.setEnabled(true);
				}
			}
		});
		comboBoxFood.setModel(new DefaultComboBoxModel(foodNames));
		comboBoxFood.setBounds(157, 61, 210, 24);
		panelFood.add(comboBoxFood);
		
		lblSelectedFood = new JLabel(String.format("<html><div>You're selecting %s which adds %.2f/100 to a monster's health. You have %d of these in your inventory.</div></html>", 
				foodNames[comboBoxFood.getSelectedIndex()],
				player.getFoodRange().get(comboBoxFood.getSelectedIndex()).getHealthIncrease(),
				inventoryFoods.get(player.getFoodRange().get(comboBoxFood.getSelectedIndex()))
				));
		lblSelectedFood.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblSelectedFood.setBounds(12, 171, 420, 47);
		panelFood.add(lblSelectedFood);
		
		JLabel lblTellUserToSelectMonster = new JLabel("<html><div>Select a monster:</div></html>");
		lblTellUserToSelectMonster.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTellUserToSelectMonster.setBounds(15, 15, 124, 47);
		panelFood.add(lblTellUserToSelectMonster);
		
		JLabel lblTellUserToSelectFood = new JLabel("<html><div>Select food:</div></html>");
		lblTellUserToSelectFood.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTellUserToSelectFood.setBounds(15, 50, 124, 47);
		panelFood.add(lblTellUserToSelectFood);
		
		btnFeedNow = new JButton("<html><div>Feed</div></html>");
		btnFeedNow.setEnabled(false);
		btnFeedNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Food theFoodToFeed = player.getFoodRange().get(comboBoxFood.getSelectedIndex());
				Monster theMonsterToFeed = monsters.get(comboBoxMonster.getSelectedIndex());
				inventory.removeFood(theFoodToFeed);
				theMonsterToFeed.increaseMonsterHealthLevel(theFoodToFeed.getHealthIncrease());
				btnFeedNow.setEnabled(false);
			}
		});
		btnFeedNow.setForeground(Color.WHITE);
		btnFeedNow.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnFeedNow.setBackground(Color.RED);
		btnFeedNow.setBounds(12, 235, 353, 31);
		panelFood.add(btnFeedNow);
		
		// CHILLY BIN --------------
		
		JPanel panelDrinks = new JPanel();
		tabbedPane.addTab("Chilly Bin", null, panelDrinks, null);
		panelDrinks.setLayout(null);
		
		JLabel lblSelectedMonster_Drinks;
		
		JComboBox comboBoxMonster_Drinks = new JComboBox(monsterNames);
		comboBoxMonster_Drinks.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lblSelectedMonster_Drinks.setText(String.format("<html><div>The health level of %s is %.2f/100.</div></html>", 
						monsters.get(comboBoxMonster.getSelectedIndex()).getEntityName(), 
						monsters.get(comboBoxMonster.getSelectedIndex()).getMonsterHealthLevel()
						));
			}
		});
		comboBoxMonster_Drinks.setModel(new DefaultComboBoxModel(monsterNames));
		comboBoxMonster_Drinks.setBounds(157, 26, 210, 24);
		panelDrinks.add(comboBoxMonster_Drinks);
		
		lblSelectedMonster_Drinks = new JLabel(String.format("<html><div>The health level of %s is %.2f/100.</div></html>", 
				monsters.get(comboBoxMonster.getSelectedIndex()).getEntityName(), 
				monsters.get(comboBoxMonster.getSelectedIndex()).getMonsterHealthLevel()));
		lblSelectedMonster_Drinks.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblSelectedMonster_Drinks.setBounds(12, 109, 420, 47);
		panelDrinks.add(lblSelectedMonster_Drinks);
		
		JLabel lblSelectedDrink;
		JButton btnDrink;
		
		JComboBox comboBoxDrinks = new JComboBox(drinkNames);
		comboBoxDrinks.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lblSelectedDrink.setText(String.format("<html><div>You're selecting %s which adds %.2f/100 to a monster's health. You have %d of these in your inventory.</div></html>", 
						drinkNames[comboBoxDrinks.getSelectedIndex()],
						player.getDrinkRange().get(comboBoxDrinks.getSelectedIndex()).getHealthIncrease(),
						inventoryFoods.get(player.getDrinkRange().get(comboBoxDrinks.getSelectedIndex()))
						)
				);
				if (inventoryFoods.get(player.getDrinkRange().get(comboBoxDrinks.getSelectedIndex())) > 0) {
					btnDrink.setEnabled(true);
				}
			}
		});
		comboBoxDrinks.setModel(new DefaultComboBoxModel(drinkNames));
		comboBoxDrinks.setBounds(157, 61, 210, 24);
		panelDrinks.add(comboBoxDrinks);
		
		lblSelectedDrink = new JLabel(String.format("<html><div>You're selecting %s which adds %.2f/100 to a monster's health. You have %d of these in your inventory.</div></html>", 
				drinkNames[comboBoxDrinks.getSelectedIndex()],
				player.getDrinkRange().get(comboBoxDrinks.getSelectedIndex()).getHealthIncrease(),
				inventoryFoods.get(player.getDrinkRange().get(comboBoxDrinks.getSelectedIndex()))
				)
		);
		lblSelectedDrink.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblSelectedDrink.setBounds(12, 171, 420, 47);
		panelDrinks.add(lblSelectedDrink);
		
		JLabel lblTellUserToSelectMonster_Drinks = new JLabel("<html><div>Select a monster:</div></html>");
		lblTellUserToSelectMonster_Drinks.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTellUserToSelectMonster_Drinks.setBounds(15, 15, 124, 47);
		panelDrinks.add(lblTellUserToSelectMonster_Drinks);
		
		JLabel lblTellUserToSelectDrink = new JLabel("<html><div>Select a drink:</div></html>");
		lblTellUserToSelectDrink.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTellUserToSelectDrink.setBounds(15, 50, 124, 47);
		panelDrinks.add(lblTellUserToSelectDrink);
		
		btnDrink = new JButton("<html><div>Drink</div></html>");
		btnDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Drink theDrinkToDrink = player.getDrinkRange().get(comboBoxDrinks.getSelectedIndex());
				Monster theMonsterToDrink = monsters.get(comboBoxMonster_Drinks.getSelectedIndex());
				inventory.removeDrink(theDrinkToDrink);
				theMonsterToDrink.increaseMonsterHealthLevel(theDrinkToDrink.getHealthIncrease());
				btnDrink.setEnabled(false);
			}
		});
		btnDrink.setForeground(Color.WHITE);
		btnDrink.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnDrink.setEnabled(false);
		btnDrink.setBackground(Color.RED);
		btnDrink.setBounds(12, 235, 353, 31);
		panelDrinks.add(btnDrink);
		
		JPanel panelFuel = new JPanel();
		tabbedPane.addTab("Fuel", null, panelFuel, null);
		panelFuel.setLayout(null);
		
		JLabel lblFuelInformation = new JLabel(String.format("<html><div>You have %.2f/100.00 of fuel left. To travel between the North Island and the South Island, it takes 20% of your fuel. To travel within an island, it takes 10% of your fuel.</div></html>", inventory.getFuelAmount()));
		lblFuelInformation.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblFuelInformation.setBounds(27, 22, 420, 47);
		panelFuel.add(lblFuelInformation);
		
		JLabel lblBalance = new JLabel(String.format("%d gold coins", player.getPlayerGold()));
		lblBalance.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBalance.setBounds(254, 28, 101, 25);
		window.getContentPane().add(lblBalance);
		lblBalance.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		
		JButton btnReturnToMap = new JButton("Return to Map");
		btnReturnToMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nextWindowIsMap = true;
				finishedWindow();
			}
		});
		btnReturnToMap.setBackground(SystemColor.info);
		btnReturnToMap.setBounds(600, 28, 136, 25);
		window.getContentPane().add(btnReturnToMap);
		btnReturnToMap.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		
		JButton btnShop = new JButton(String.format("Visit %s", battle.getBattleShop().getShopName()));
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nextWindowIsMap = false;
				finishedWindow();
			}
		});
		btnShop.setBackground(SystemColor.info);
		btnShop.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnShop.setBounds(380, 28, 208, 25);
		window.getContentPane().add(btnShop);
	}
}
