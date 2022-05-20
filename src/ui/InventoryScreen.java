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
import javax.swing.ImageIcon;
import javax.swing.JTextField;

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
		
		JButton brnInFrontOfTeam = new JButton("<html><div>Set selected monster to front of team</div></html>");
		brnInFrontOfTeam.setEnabled(false);
		brnInFrontOfTeam.setForeground(Color.WHITE);
		brnInFrontOfTeam.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		brnInFrontOfTeam.setBackground(Color.RED);
		brnInFrontOfTeam.setBounds(407, 309, 300, 40);
		panelPurchaseMonster.add(brnInFrontOfTeam);
		
		JButton btnMonster1 = new JButton(monsters.get(0).getEntityName());
		btnMonster1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentClickMonster = monsters.get(0);
				lblMonsterInfo.setText(String.format(monsterDescriptionString, currentClickMonster.getMonsterAttackDamage(), currentClickMonster.getMonsterResistanceAbility(),
						currentClickMonster.getEntitySellValue()));
				brnInFrontOfTeam.setEnabled(true);
			}
		});
		btnMonster1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster1.setBackground(SystemColor.info);
		btnMonster1.setBounds(12, 224, 111, 25);
		panelPurchaseMonster.add(btnMonster1);
		
		JButton btnMonster2 = new JButton(monsters.get(1).getEntityName());
		btnMonster2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentClickMonster = monsters.get(1);
				lblMonsterInfo.setText(String.format(monsterDescriptionString, currentClickMonster.getMonsterAttackDamage(), currentClickMonster.getMonsterResistanceAbility(),
						currentClickMonster.getEntitySellValue()));
				brnInFrontOfTeam.setEnabled(true);
			}
		});
		btnMonster2.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster2.setBackground(SystemColor.info);
		btnMonster2.setBounds(155, 224, 111, 25);
		panelPurchaseMonster.add(btnMonster2);
		
		JButton btnMonster3 = new JButton("");
		btnMonster3.setEnabled(false);
		btnMonster3.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster3.setBackground(SystemColor.info);
		btnMonster3.setBounds(299, 224, 111, 25);
		panelPurchaseMonster.add(btnMonster3);
		
		JButton btnMonster4 = new JButton("");
		btnMonster4.setEnabled(false);
		btnMonster4.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnMonster4.setBackground(SystemColor.info);
		btnMonster4.setBounds(446, 224, 111, 25);
		panelPurchaseMonster.add(btnMonster4);
		
		JLabel lblMonster1Img = new JLabel("");
		lblMonster1Img.setIcon(new ImageIcon(InventoryScreen.class.getResource("/assets/ui/img/dragon-final.png")));
		lblMonster1Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster1Img.setBounds(12, 12, 111, 200);
		panelPurchaseMonster.add(lblMonster1Img);
		
		JLabel lblMonster1Img_1 = new JLabel("");
		lblMonster1Img_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster1Img_1.setBounds(155, 12, 111, 200);
		panelPurchaseMonster.add(lblMonster1Img_1);
		
		JLabel lblMonster1Img_1_1 = new JLabel("");
		lblMonster1Img_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster1Img_1_1.setBounds(299, 12, 111, 200);
		panelPurchaseMonster.add(lblMonster1Img_1_1);
		
		JLabel lblMonster1Img_1_1_1 = new JLabel("");
		lblMonster1Img_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster1Img_1_1_1.setBounds(446, 12, 111, 200);
		panelPurchaseMonster.add(lblMonster1Img_1_1_1);
		
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
		
		switch(player.getPlayerDifficulty()) {
		case 3:
			btnMonster4.setEnabled(true);
			btnMonster4.setText(monsters.get(3).getEntityName());
			btnMonster4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					currentClickMonster = monsters.get(3);
					lblMonsterInfo.setText(String.format(monsterDescriptionString, currentClickMonster.getMonsterAttackDamage(), currentClickMonster.getMonsterResistanceAbility(),
							currentClickMonster.getEntitySellValue()));
					brnInFrontOfTeam.setEnabled(true);
				}
			});
		case 2:
			btnMonster3.setEnabled(true);
			btnMonster3.setText(monsters.get(2).getEntityName());
			btnMonster3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					currentClickMonster = monsters.get(2);
					lblMonsterInfo.setText(String.format(monsterDescriptionString, currentClickMonster.getMonsterAttackDamage(), currentClickMonster.getMonsterResistanceAbility(),
							currentClickMonster.getEntitySellValue()));
				}
			});
		}
		
		JPanel panelBuyPotion = new JPanel();
		tabbedPane.addTab("Beverages", null, panelBuyPotion, null);
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
