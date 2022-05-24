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
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.HashMap;
import java.util.List;

public class InventoryScreen {

	private JFrame window;
	private GameEnvironment gameEnvironment;
	private Player player;
	private Battle battle;
	private Inventory inventory;
	private ArrayList<Monster> monsters;
	private ArrayList<Integer> inventoryFoods;
	private ArrayList<Integer> inventoryDrinks;
	private double fuelAmount;
	private Monster currentClickMonster;
	private String monsterDescriptionString = "<html><div>Attack Damage: %.2f<br>Resistance Ability: %.2f<br>Current health: %.2f<br>Sellback Price: %d</div></html>";
	private List<String> monsterNames;       
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

	private int comboBoxIndex;
	
	
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
		battle = player.getPlayerSelectedBattle();
		monsters = inventory.getMonsters();
		monsterNames = new ArrayList<String>();
		for (Monster monster : monsters) {
			monsterNames.add(monster.getEntityName());
		}
		
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
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.getContentPane().setBackground(Color.DARK_GRAY);
		window.setTitle("Inventory");
		window.setBounds(100, 100, 750, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblNauMaiWelcome = new JLabel("Inventory");
		lblNauMaiWelcome.setForeground(Color.WHITE);
		lblNauMaiWelcome.setFont(new Font("Century Schoolbook L", Font.BOLD, 24));
		lblNauMaiWelcome.setBounds(24, 20, 261, 34);
		window.getContentPane().add(lblNauMaiWelcome);
		
		JLabel lblBalance = new JLabel(String.format("%d gold coins", player.getPlayerGold()));
		lblBalance.setForeground(Color.WHITE);
		lblBalance.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBalance.setBounds(254, 28, 101, 25);
		window.getContentPane().add(lblBalance);
		lblBalance.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 69, 748, 400);
		window.getContentPane().add(tabbedPane);
		
		JPanel panelMonsters = new JPanel();
		panelMonsters.setBackground(Color.WHITE);
		tabbedPane.addTab("Your Monsters", null, panelMonsters, "");
		tabbedPane.setEnabledAt(0, true);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		panelMonsters.setLayout(null);
		
		
		
		JLabel lblMonsterInfo = new JLabel("");
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
		
		lblMonster1Img = new JLabel("");
		lblMonster1Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster1Img.setBounds(12, 12, 111, 200);
		panelMonsters.add(lblMonster1Img);
		
		lblMonster2Img = new JLabel("");
		lblMonster2Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster2Img.setBounds(155, 12, 111, 200);
		panelMonsters.add(lblMonster2Img);
		
		lblMonster3Img = new JLabel("");
		lblMonster3Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster3Img.setBounds(299, 12, 111, 200);
		panelMonsters.add(lblMonster3Img);
		
		lblMonster4Img = new JLabel("");
		lblMonster4Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonster4Img.setBounds(446, 12, 111, 200);
		panelMonsters.add(lblMonster4Img);
		
	
		
		btnInFrontOfTeam = new JButton("<html><div>Set selected monster to front</div></html>");
		btnInFrontOfTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				monsters.remove(currentClickMonster);
				monsters.add(0, currentClickMonster);
				switch(monsters.size()) {
				case 4:
					btnMonster4.setEnabled(true);
					btnMonster4.setText(monsters.get(3).getEntityName());
					lblMonster4Img.setIcon(new ImageIcon(InventoryScreen.class.getResource(monsters.get(3).getEntityImagePath())));
					btnMonster4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							currentClickMonster = monsters.get(3);
							lblMonsterInfo.setText(String.format(monsterDescriptionString,
									currentClickMonster.getMonsterAttackDamage(),
									currentClickMonster.getMonsterResistanceAbility(),
									currentClickMonster.getMonsterHealthLevel(),
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
							lblMonsterInfo.setText(String.format(monsterDescriptionString,
									currentClickMonster.getMonsterAttackDamage(),
									currentClickMonster.getMonsterResistanceAbility(),
									currentClickMonster.getMonsterHealthLevel(),
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
							lblMonsterInfo.setText(String.format(monsterDescriptionString,
									currentClickMonster.getMonsterAttackDamage(),
									currentClickMonster.getMonsterResistanceAbility(),
									currentClickMonster.getMonsterHealthLevel(),
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
							lblMonsterInfo.setText(String.format(monsterDescriptionString,
									currentClickMonster.getMonsterAttackDamage(),
									currentClickMonster.getMonsterResistanceAbility(),
									currentClickMonster.getMonsterHealthLevel(),
									currentClickMonster.getEntitySellValue()));
							btnInFrontOfTeam.setEnabled(true);
						}
					});
					break;
				}
			}
		});
		btnInFrontOfTeam.setEnabled(false);
		btnInFrontOfTeam.setForeground(Color.WHITE);
		btnInFrontOfTeam.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnInFrontOfTeam.setBackground(Color.GRAY);
		btnInFrontOfTeam.setBounds(541, 289, 166, 60);
		panelMonsters.add(btnInFrontOfTeam);
		
		JButton btnInFrontOfTeam_1 = new JButton("<html><div>Sell back</div></html>");
		btnInFrontOfTeam_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (currentClickMonster != null) {
					if (inventory.getMonsters().size() > 1) {
						inventory.getMonsters().remove(currentClickMonster);
						player.incrementPlayerGoldBy(currentClickMonster.getEntitySellValue());
						JOptionPane.showMessageDialog(window, "Successfully sold back");
						lblBalance.setText(String.format("%s gold coins", player.getPlayerGold()));
						switch(monsters.size()) {
						case 3:
							btnMonster4.setEnabled(false);
							btnMonster4.setText("");
							lblMonster4Img.setIcon(new ImageIcon(InventoryScreen.class.getResource("")));
							break;
						case 2:
							btnMonster3.setEnabled(false);
							btnMonster3.setText("");
							lblMonster3Img.setIcon(new ImageIcon(InventoryScreen.class.getResource("")));
							break;
						case 1:
							btnMonster2.setEnabled(false);
							btnMonster2.setText("");
							lblMonster2Img.setIcon(new ImageIcon(InventoryScreen.class.getResource("")));
							break;
						}
						
						switch(monsters.size()) {
						case 4:
							btnMonster4.setEnabled(true);
							btnMonster4.setText(monsters.get(3).getEntityName());
							lblMonster4Img.setIcon(new ImageIcon(InventoryScreen.class.getResource(monsters.get(3).getEntityImagePath())));
							btnMonster4.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									currentClickMonster = monsters.get(3);
									lblMonsterInfo.setText(String.format(monsterDescriptionString,
											currentClickMonster.getMonsterAttackDamage(),
											currentClickMonster.getMonsterResistanceAbility(),
											currentClickMonster.getMonsterHealthLevel(),
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
									lblMonsterInfo.setText(String.format(monsterDescriptionString,
											currentClickMonster.getMonsterAttackDamage(),
											currentClickMonster.getMonsterResistanceAbility(),
											currentClickMonster.getMonsterHealthLevel(),
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
									lblMonsterInfo.setText(String.format(monsterDescriptionString,
											currentClickMonster.getMonsterAttackDamage(),
											currentClickMonster.getMonsterResistanceAbility(),
											currentClickMonster.getMonsterHealthLevel(),
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
									lblMonsterInfo.setText(String.format(monsterDescriptionString,
											currentClickMonster.getMonsterAttackDamage(),
											currentClickMonster.getMonsterResistanceAbility(),
											currentClickMonster.getMonsterHealthLevel(),
											currentClickMonster.getEntitySellValue()));
									btnInFrontOfTeam.setEnabled(true);
								}
							});
							break;
						}
					}else  {
						JOptionPane.showMessageDialog(window, "You can't sell back your one and only monster");
					}}
					else {
						JOptionPane.showMessageDialog(window, "Please select a monster to sell bacK");
					}
					
					
			}
		});
		btnInFrontOfTeam_1.setForeground(Color.WHITE);
		btnInFrontOfTeam_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnInFrontOfTeam_1.setBackground(Color.GRAY);
		btnInFrontOfTeam_1.setBounds(423, 289, 111, 60);
		panelMonsters.add(btnInFrontOfTeam_1);
		
		
		switch(monsters.size()) {
		case 4:
			btnMonster4.setEnabled(true);
			btnMonster4.setText(monsters.get(3).getEntityName());
			lblMonster4Img.setIcon(new ImageIcon(InventoryScreen.class.getResource(monsters.get(3).getEntityImagePath())));
			btnMonster4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					currentClickMonster = monsters.get(3);
					lblMonsterInfo.setText(String.format(monsterDescriptionString,
							currentClickMonster.getMonsterAttackDamage(),
							currentClickMonster.getMonsterResistanceAbility(),
							currentClickMonster.getMonsterHealthLevel(),
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
					lblMonsterInfo.setText(String.format(monsterDescriptionString,
							currentClickMonster.getMonsterAttackDamage(),
							currentClickMonster.getMonsterResistanceAbility(),
							currentClickMonster.getMonsterHealthLevel(),
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
					lblMonsterInfo.setText(String.format(monsterDescriptionString,
							currentClickMonster.getMonsterAttackDamage(),
							currentClickMonster.getMonsterResistanceAbility(),
							currentClickMonster.getMonsterHealthLevel(),
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
					lblMonsterInfo.setText(String.format(monsterDescriptionString,
							currentClickMonster.getMonsterAttackDamage(),
							currentClickMonster.getMonsterResistanceAbility(),
							currentClickMonster.getMonsterHealthLevel(),
							currentClickMonster.getEntitySellValue()));
					btnInFrontOfTeam.setEnabled(true);
				}
			});
			break;
		}
		
		JPanel panelFood = new JPanel();
		panelFood.setBackground(Color.WHITE);
		tabbedPane.addTab("Food Chest", null, panelFood, null);
		tabbedPane.setBackgroundAt(1, Color.WHITE);
		panelFood.setLayout(null);
		
		JLabel lblSelectedMonster;
		lblSelectedMonster = new JLabel(String.format("<html><div>The health level of %s is %.2f/100.</div></html>",
				monsters.get(0).getEntityName(),
				monsters.get(0).getMonsterHealthLevel()));

		lblSelectedMonster.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblSelectedMonster.setBounds(157, 143, 420, 47);
		panelFood.add(lblSelectedMonster);
		
		
		JComboBox comboBoxMonster = new JComboBox();
		comboBoxMonster.setBackground(Color.WHITE);
		comboBoxMonster.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		comboBoxMonster.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lblSelectedMonster.setText(String.format("<html><div>The health level of %s is %.2f/100.</div></html>", 
						monsters.get(comboBoxMonster.getSelectedIndex()).getEntityName(), 
						monsters.get(comboBoxMonster.getSelectedIndex()).getMonsterHealthLevel()
						)
				);
			}
		});
		for (int i = 0; i < monsterNames.size(); i++) {
			    comboBoxMonster.addItem(monsterNames.get(i));
		}
		comboBoxMonster.setBounds(302, 60, 210, 24);
		panelFood.add(comboBoxMonster);
		
		JLabel lblSelectedFood;
		lblSelectedFood = new JLabel(String.format("<html><div>You're selecting %s which adds %.2f/100 to a monster's health. You have %d of these in your inventory.</div></html>",
				foodNames[0],
				player.getFoodRange()[0].getConsumableHealValue(),
				inventoryFoods.get(0)
		));
		lblSelectedFood.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblSelectedFood.setBounds(157, 205, 420, 47);
		panelFood.add(lblSelectedFood);
		
		JComboBox comboBoxFood;
		comboBoxFood = new JComboBox(foodNames);
		comboBoxFood.setBackground(Color.WHITE);
		comboBoxFood.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		comboBoxFood.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBoxIndex = comboBoxFood.getSelectedIndex();
				lblSelectedFood.setText(String.format("<html><div>You're selecting %s which adds %.2f/100 to a monster's health. You have %d of these in your inventory.</div></html>",
						foodNames[comboBoxFood.getSelectedIndex()],
						player.getFoodRange()[comboBoxFood.getSelectedIndex()].getConsumableHealValue(),
						inventoryFoods.get(comboBoxFood.getSelectedIndex())
						)
				);
			}
		});
		comboBoxFood.setModel(new DefaultComboBoxModel(foodNames));
		comboBoxFood.setBounds(302, 95, 210, 24);
		panelFood.add(comboBoxFood);
		
		

		


		JButton btnFeedNow = new JButton("<html><div>Feed</div></html>");
		btnFeedNow = new JButton("<html><div>Feed</div></html>");
		JButton finalBtnFeedNow = btnFeedNow;
		btnFeedNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Food theFoodToFeed = player.getFoodRange()[comboBoxIndex];
				Monster theMonsterToFeed = monsters.get(comboBoxIndex);
				boolean successStatus = inventory.removeFood(theFoodToFeed);
				if (successStatus) {
					if (theMonsterToFeed.getMonsterHealthLevel() < 100) {
						JOptionPane.showMessageDialog(window, "Yummy!!");
						theMonsterToFeed.increaseMonsterHealthLevel(theFoodToFeed.getConsumableHealValue());
					}  else {
						JOptionPane.showMessageDialog(window, "I'm already full - my health is 100%.");
					}
				} else {
					JOptionPane.showMessageDialog(window, "You don't have enough of this food.");
				}
				lblSelectedFood.setText(String.format("<html><div>You're selecting %s which adds %.2f/100 to a monster's health. You have %d of these in your inventory.</div></html>",
						foodNames[comboBoxFood.getSelectedIndex()],
						player.getFoodRange()[comboBoxFood.getSelectedIndex()].getConsumableHealValue(),
						inventoryFoods.get(comboBoxFood.getSelectedIndex())
						)
				);
			}
		});
		
		
		

		
		JLabel lblTellUserToSelectMonster = new JLabel("<html><div>Select a monster:</div></html>");
		lblTellUserToSelectMonster.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTellUserToSelectMonster.setBounds(160, 49, 124, 47);
		panelFood.add(lblTellUserToSelectMonster);
		
		JLabel lblTellUserToSelectFood = new JLabel("<html><div>Select food:</div></html>");
		lblTellUserToSelectFood.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTellUserToSelectFood.setBounds(160, 84, 124, 47);
		panelFood.add(lblTellUserToSelectFood);
		

		btnFeedNow.setForeground(Color.WHITE);
		btnFeedNow.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnFeedNow.setBackground(Color.RED);
		btnFeedNow.setBounds(157, 269, 353, 31);
		panelFood.add(btnFeedNow);
		
		// CHILLY BIN --------------
		
		JPanel panelDrinks = new JPanel();
		panelDrinks.setBackground(Color.WHITE);
		tabbedPane.addTab("Chilly Bin", null, panelDrinks, null);
		tabbedPane.setBackgroundAt(2, Color.WHITE);
		panelDrinks.setLayout(null);
		
		JLabel lblSelectedMonster_Drinks;
		lblSelectedMonster_Drinks = new JLabel(String.format("<html><div>The health level of %s is %.2f/100.</div></html>",
				monsters.get(0).getEntityName(),
				monsters.get(0).getMonsterHealthLevel()));
		lblSelectedMonster_Drinks.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblSelectedMonster_Drinks.setBounds(159, 145, 420, 47);
		panelDrinks.add(lblSelectedMonster_Drinks);
		
		JComboBox comboBoxMonster_Drinks = new JComboBox();
		comboBoxMonster_Drinks.setBackground(Color.WHITE);
		comboBoxMonster_Drinks.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		comboBoxMonster_Drinks.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lblSelectedMonster_Drinks.setText(String.format("<html><div>The health level of %s is %.2f/100.</div></html>",
						monsters.get(comboBoxMonster.getSelectedIndex()).getEntityName(), 
						monsters.get(comboBoxMonster.getSelectedIndex()).getMonsterHealthLevel()
						));
			}
		});
		for (int i = 0; i < monsterNames.size(); i++) {
		    comboBoxMonster_Drinks.addItem(monsterNames.get(i));
	}
		comboBoxMonster_Drinks.setBounds(304, 62, 210, 24);
		panelDrinks.add(comboBoxMonster_Drinks);
		

		
		JLabel lblSelectedDrink;
		lblSelectedDrink = new JLabel(String.format("<html><div>You're selecting %s which adds %.2f/100 to a monster's health. You have %d of these in your inventory.</div></html>",
				drinkNames[0],
				player.getDrinkRange()[0].getConsumableHealValue(),
				inventoryDrinks.get(0)
		)
		);
		lblSelectedDrink.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblSelectedDrink.setBounds(159, 207, 420, 47);
		panelDrinks.add(lblSelectedDrink);

		JButton btnDrink = new JButton("<html><div>Drink</div></html>");
		
		JComboBox comboBoxDrinks = new JComboBox(drinkNames);
		comboBoxDrinks.setBackground(Color.WHITE);
		comboBoxDrinks.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		comboBoxDrinks.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lblSelectedDrink.setText(String.format("<html><div>You're selecting %s which adds %.2f/100 to a monster's health. You have %d of these in your inventory.</div></html>",
						drinkNames[comboBoxDrinks.getSelectedIndex()],
						player.getDrinkRange()[comboBoxDrinks.getSelectedIndex()].getConsumableHealValue(),
						inventoryDrinks.get(comboBoxDrinks.getSelectedIndex())
						)
				);
			}
		});
		comboBoxDrinks.setModel(new DefaultComboBoxModel(drinkNames));
		comboBoxDrinks.setBounds(304, 97, 210, 24);
		panelDrinks.add(comboBoxDrinks);
		

		
		JLabel lblTellUserToSelectMonster_Drinks = new JLabel("<html><div>Select a monster:</div></html>");
		lblTellUserToSelectMonster_Drinks.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTellUserToSelectMonster_Drinks.setBounds(162, 51, 124, 47);
		panelDrinks.add(lblTellUserToSelectMonster_Drinks);
		
		JLabel lblTellUserToSelectDrink = new JLabel("<html><div>Select a drink:</div></html>");
		lblTellUserToSelectDrink.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblTellUserToSelectDrink.setBounds(162, 86, 124, 47);
		panelDrinks.add(lblTellUserToSelectDrink);
		

		btnDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Drink theDrinkToDrink = player.getDrinkRange()[comboBoxDrinks.getSelectedIndex()];
				Monster theMonsterToDrink = monsters.get(comboBoxMonster_Drinks.getSelectedIndex());
				Boolean successStatus = inventory.removeDrink(theDrinkToDrink);
				if (successStatus) {
					JOptionPane.showMessageDialog(window, "Yummy!!");
					theMonsterToDrink.increaseMonsterHealthLevel(theDrinkToDrink.getConsumableHealValue());
				} else {
					JOptionPane.showMessageDialog(window, "You don't have enough of this drink.");
				}
				lblSelectedDrink.setText(String.format("<html><div>You're selecting %s which adds %.2f/100 to a monster's health. You have %d of these in your inventory.</div></html>",
						drinkNames[comboBoxDrinks.getSelectedIndex()],
						player.getDrinkRange()[comboBoxDrinks.getSelectedIndex()].getConsumableHealValue(),
						inventoryDrinks.get(comboBoxDrinks.getSelectedIndex())
						));
			
			}
		});
		btnDrink.setForeground(Color.WHITE);
		btnDrink.setFont(new Font("Century Schoolbook L", Font.PLAIN, 16));
		btnDrink.setBackground(Color.RED);
		btnDrink.setBounds(159, 271, 353, 31);
		panelDrinks.add(btnDrink);
		
		JPanel panelFuel = new JPanel();
		panelFuel.setBackground(Color.WHITE);
		tabbedPane.addTab("Fuel", null, panelFuel, null);
		tabbedPane.setBackgroundAt(3, Color.WHITE);
		panelFuel.setLayout(null);
		
		JLabel lblFuelInformation = new JLabel(String.format("<html><div>You have %.2f/100.00 of fuel left. To travel between the North Island and the South Island, it takes 20 units of your fuel. To travel within an island, it takes 10 units of your fuel.</div></html>", 
				inventory.getFuelAmount()));
		lblFuelInformation.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		lblFuelInformation.setBounds(27, 22, 420, 148);
		panelFuel.add(lblFuelInformation);
		
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
		btnShop.setEnabled(true);
		if (battle.getBattleName() == "Wellington") {
			btnShop.setText("Shop Unavailable");
			btnShop.setEnabled(false);
		}
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
