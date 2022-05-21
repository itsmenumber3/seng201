package ui;

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

public class InventoryScreen {

	private JFrame window;
	private GameEnvironment gameEnvironment;
	private boolean isPreviousWindowMapWindow;
	private Player player;
	private Battle battle;
	private Inventory inventory;
	private ArrayList<Monster> monsters;
	private ArrayList<Food> foods;
	private ArrayList<Drink> drinks;
	private double fuelAmount;
	private Monster currentClickMonster;
	private String monsterDescriptionString = "<html><div>Attack Damage: %2.f<br>Resistance Ability: %.2f<br>Current health: %.2f<br>Sellback Price: %d</div></html>";
	private String[] monsterNames;       
	private String[] foodNames;
	private String[] drinkNames;
	
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
		this.player = gameEnvironment.getPlayer();
		this.inventory = player.getPlayerInventory();
		monsters = inventory.getMonsters();
		foods = inventory.getFoods();
		drinks = inventory.getDrinks();
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
		
		JLabel lblMonsterInfo = new JLabel();
		lblMonsterInfo.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblMonsterInfo.setBounds(12, 261, 377, 88);
		panelPurchaseMonster.add(lblMonsterInfo);
		
		btnMonster1 = new JButton("");
		btnMonster1.setEnabled(false);
		btnMonster1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster1.setBackground(SystemColor.info);
		btnMonster1.setBounds(12, 224, 111, 25);
		panelPurchaseMonster.add(btnMonster1);
		
		btnMonster2 = new JButton("");
		btnMonster2.setEnabled(false);
		btnMonster2.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster2.setBackground(SystemColor.info);
		btnMonster2.setBounds(155, 224, 111, 25);
		panelPurchaseMonster.add(btnMonster2);
		
		btnMonster3 = new JButton("");
		btnMonster3.setEnabled(false);
		btnMonster3.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster3.setBackground(SystemColor.info);
		btnMonster3.setBounds(299, 224, 111, 25);
		panelPurchaseMonster.add(btnMonster3);
		
		btnMonster4 = new JButton("");
		btnMonster4.setEnabled(false);
		btnMonster4.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster4.setBackground(SystemColor.info);
		btnMonster4.setBounds(446, 224, 111, 25);
		panelPurchaseMonster.add(btnMonster4);
		
		JLabel lblMonster1Img = new JLabel("");
		lblMonster1Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster1Img.setBounds(12, 12, 111, 200);
		panelPurchaseMonster.add(lblMonster1Img);
		
		JLabel lblMonster2Img = new JLabel("");
		lblMonster2Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster2Img.setBounds(155, 12, 111, 200);
		panelPurchaseMonster.add(lblMonster2Img);
		
		JLabel lblMonster3Img = new JLabel("");
		lblMonster3Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster3Img.setBounds(299, 12, 111, 200);
		panelPurchaseMonster.add(lblMonster3Img);
		
		JLabel lblMonster4Img = new JLabel("");
		lblMonster4Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster4Img.setBounds(446, 12, 111, 200);
		panelPurchaseMonster.add(lblMonster4Img);
		
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
		panelPurchaseMonster.add(btnInFrontOfTeam);
		
		JPanel panelDiningRoom = new JPanel();
		tabbedPane.addTab("Dining Room", null, panelDiningRoom, null);
		panelDiningRoom.setLayout(null);
		
		ArrayList<String> monsterNameArrayList= new ArrayList<>();
		
		for (int index = 0; index < monsters.size(); index++) {
			monsterNameArrayList.add(monsters.get(index).getEntityName());
		}
		monsterNames = (String[]) monsterNameArrayList.toArray();
		
		JComboBox comboBoxMonster = new JComboBox(monsterNames);
		comboBoxMonster.setBounds(157, 26, 210, 24);
		comboBoxMonster.setModel(new DefaultComboBoxModel(monsterNames));
		panelDiningRoom.add(comboBoxMonster);
		
		JLabel lblSelectedMonster = new JLabel("<html><div>You're selecting Pasta. Pasta increases adds 10% to the monster's health. Pasta costs 20 coins. </div></html>");
		lblSelectedMonster.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblSelectedMonster.setBounds(12, 109, 420, 47);
		panelDiningRoom.add(lblSelectedMonster);
		
		JLabel lblSelectedFood = new JLabel("<html><div>You're selecting Pasta. Pasta increases adds 10% to the monster's health. Pasta costs 20 coins. </div></html>");
		lblSelectedFood.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblSelectedFood.setBounds(12, 171, 420, 47);
		panelDiningRoom.add(lblSelectedFood);
		
		JLabel lblTellUserToSelectMonster = new JLabel("<html><div>Select a monster:</div></html>");
		lblTellUserToSelectMonster.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTellUserToSelectMonster.setBounds(15, 15, 124, 47);
		panelDiningRoom.add(lblTellUserToSelectMonster);
		
		JLabel lblTellUserToSelectFood = new JLabel("<html><div>Select food:</div></html>");
		lblTellUserToSelectFood.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTellUserToSelectFood.setBounds(15, 50, 124, 47);
		panelDiningRoom.add(lblTellUserToSelectFood);
		
		ArrayList<String> foodNameArrayList = new ArrayList<>(); 
		
		for (int index = 0; index < monsters.size(); index++) {
			foodNameArrayList.add(foods.get(index).getEntityName());
		}
		foodNames = (String[]) foodNameArrayList.toArray();
		
		JComboBox comboBoxFood = new JComboBox();
		comboBoxFood.setModel(new DefaultComboBoxModel(foodNames));
		comboBoxFood.setBounds(157, 61, 210, 24);
		panelDiningRoom.add(comboBoxFood);
		
		JButton btnFeedNow = new JButton("<html><div>Feed</div></html>");
		btnFeedNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String monsterNameInQuestion = (String) comboBoxMonster.getSelectedItem();
				String foodInQuestion = (String) comboBoxFood.getSelectedItem();
				// comboBoxFood.getSe
			}
		});
		btnFeedNow.setForeground(Color.WHITE);
		btnFeedNow.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnFeedNow.setBackground(Color.RED);
		btnFeedNow.setBounds(12, 235, 353, 31);
		panelDiningRoom.add(btnFeedNow);
		

		
		JPanel panelBuyPotion = new JPanel();
		tabbedPane.addTab("Beverages", null, panelBuyPotion, null);
		panelBuyPotion.setLayout(null);
		
		JLabel lblTipClickTo_1_1_2 = new JLabel("<html><div>Select a monster:</div></html>");
		lblTipClickTo_1_1_2.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTipClickTo_1_1_2.setBounds(15, 12, 124, 47);
		panelBuyPotion.add(lblTipClickTo_1_1_2);
		
		JLabel lblTipClickTo_1_1_1_1 = new JLabel("<html><div>Select a drink:</div></html>");
		lblTipClickTo_1_1_1_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTipClickTo_1_1_1_1.setBounds(15, 47, 124, 47);
		panelBuyPotion.add(lblTipClickTo_1_1_1_1);
		
		JComboBox comboBoxMonster_1 = new JComboBox(new Object[]{});
		comboBoxMonster_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
			}
		});
		comboBoxMonster_1.setBounds(157, 23, 210, 24);
		panelBuyPotion.add(comboBoxMonster_1);
		
		JComboBox comboBoxFood_1 = new JComboBox();
		comboBoxFood_1.setBounds(157, 58, 210, 24);
		panelBuyPotion.add(comboBoxFood_1);
		
		JLabel lblTipClickTo_1_3_3_1 = new JLabel("<html><div>You're selecting Pasta. Pasta increases adds 10% to the monster's health. Pasta costs 20 coins. </div></html>");
		lblTipClickTo_1_3_3_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTipClickTo_1_3_3_1.setBounds(12, 106, 420, 47);
		panelBuyPotion.add(lblTipClickTo_1_3_3_1);
		
		JLabel lblTipClickTo_1_3_1 = new JLabel("<html><div>You're selecting Pasta. Pasta increases adds 10% to the monster's health. Pasta costs 20 coins. </div></html>");
		lblTipClickTo_1_3_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTipClickTo_1_3_1.setBounds(12, 168, 420, 47);
		panelBuyPotion.add(lblTipClickTo_1_3_1);
		
		JButton btnPurchaseAndFeed_1 = new JButton("<html><div>Feed</div></html>");
		btnPurchaseAndFeed_1.setForeground(Color.WHITE);
		btnPurchaseAndFeed_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnPurchaseAndFeed_1.setBackground(Color.RED);
		btnPurchaseAndFeed_1.setBounds(12, 232, 353, 31);
		panelBuyPotion.add(btnPurchaseAndFeed_1);
		
		JPanel panelFuel = new JPanel();
		tabbedPane.addTab("Fuel", null, panelFuel, null);
		panelFuel.setLayout(null);
		
		JLabel lblTipClickTo_1_3_2 = new JLabel(String.format("<html><div>You have %.2f/100.00 of fuel left. To travel between the North Island and the South Island, it takes 20% of your fuel. To travel within an island, it takes 10% of your fuel.</div></html>", inventory.getFuelAmount()));
		lblTipClickTo_1_3_2.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTipClickTo_1_3_2.setBounds(27, 22, 420, 47);
		panelFuel.add(lblTipClickTo_1_3_2);
		
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
