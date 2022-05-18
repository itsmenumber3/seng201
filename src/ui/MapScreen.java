package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.html.HTML;

import assets.enums.MonsterType;
import assets.libraries.Tools;
import battles.Battle;
import battles.CanterburyWetlands;
import battles.LakeTaupo;
import battles.MountCook;
import battles.NinetyMilesBeach;
import battles.SouthlandFarm;
import entities.monsters.battle_monsters.MudMonster;
import main.GameEnvironment;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;

public class MapScreen {

	private JFrame window;
	private GameEnvironment gameEnvironment;
	private Tools tools = new Tools();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MapScreen window = new MapScreen();
					window.window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MapScreen(GameEnvironment inputGameEnvironment) {
		gameEnvironment = inputGameEnvironment;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		gameEnvironment.closeMapScreen(this);
	}

	/**
	 * Create the application.
	 */
	public MapScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Battles");
		window.setBounds(100, 100, 592, 750);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JButton btnMtCook = new JButton("Mt Cook");
		btnMtCook.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		btnMtCook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Battle battle = new MountCook();
				battle.setBattleMonster(tools.generateRandomBattleMonster(MonsterType.SNOW_MONSTER, gameEnvironment.getPlayer()));
				gameEnvironment.getPlayer().setPlayerSelectedBattle(battle);
				finishedWindow();
			}
		});
		
		JButton btnMilesBeach = new JButton("90 Miles Beach");
		btnMilesBeach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Battle battle = new NinetyMilesBeach();
				battle.setBattleMonster(tools.generateRandomBattleMonster(MonsterType.SAND_MONSTER, gameEnvironment.getPlayer()));
				gameEnvironment.getPlayer().setPlayerSelectedBattle(battle);
				finishedWindow();
			}
		});
		btnMilesBeach.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		btnMilesBeach.setBackground(SystemColor.info);
		btnMilesBeach.setBounds(358, 111, 119, 25);
		window.getContentPane().add(btnMilesBeach);
		
		JButton btnLakeTaupo = new JButton("Lake Taupo");
		btnLakeTaupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Battle battle = new LakeTaupo();
				battle.setBattleMonster(tools.generateRandomBattleMonster(MonsterType.WATER_MONSTER, gameEnvironment.getPlayer()));
				gameEnvironment.getPlayer().setPlayerSelectedBattle(battle);
				finishedWindow();
			}
		});
		btnLakeTaupo.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		btnLakeTaupo.setBackground(SystemColor.info);
		btnLakeTaupo.setBounds(413, 248, 106, 25);
		window.getContentPane().add(btnLakeTaupo);
		
		JButton btnCanterburyWetlands = new JButton("<html><div>Canterbury Wetlands</div></html>");
		btnCanterburyWetlands.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Battle battle = new CanterburyWetlands();
				battle.setBattleMonster(tools.generateRandomBattleMonster(MonsterType.MUD_MONSTER, gameEnvironment.getPlayer()));
				gameEnvironment.getPlayer().setPlayerSelectedBattle(battle);
				finishedWindow();
			}
		});
		btnCanterburyWetlands.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		btnCanterburyWetlands.setBackground(SystemColor.info);
		btnCanterburyWetlands.setBounds(333, 401, 97, 42);
		window.getContentPane().add(btnCanterburyWetlands);
		btnMtCook.setBackground(SystemColor.info);
		btnMtCook.setBounds(130, 457, 97, 25);
		window.getContentPane().add(btnMtCook);
		
		JButton btnSouthlandFarm = new JButton("Southland Farm");
		btnSouthlandFarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Battle battle = new SouthlandFarm();
				battle.setBattleMonster(tools.generateRandomBattleMonster(MonsterType.GRASS_MONSTER, gameEnvironment.getPlayer()));
				gameEnvironment.getPlayer().setPlayerSelectedBattle(battle);
				finishedWindow();
			}
		});
		btnSouthlandFarm.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		btnSouthlandFarm.setBackground(SystemColor.info);
		btnSouthlandFarm.setBounds(163, 574, 126, 25);
		window.getContentPane().add(btnSouthlandFarm);
		
		JButton btnFarewellSpit_1_1_2 = new JButton("End Game");
		btnFarewellSpit_1_1_2.setBounds(458, 665, 97, 25);
		window.getContentPane().add(btnFarewellSpit_1_1_2);
		btnFarewellSpit_1_1_2.setForeground(Color.WHITE);
		btnFarewellSpit_1_1_2.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		btnFarewellSpit_1_1_2.setBackground(Color.RED);
		
		JPanel panelItem = new JPanel();
		panelItem.setLayout(null);
		panelItem.setOpaque(true);
		panelItem.setBackground(new Color(0, 51, 153));
		panelItem.setBounds(29, 39, 231, 255);
		window.getContentPane().add(panelItem);
		
		JLabel lblNewLabel_1 = new JLabel("<html><div>" + "Your monsters are currently at " + "Wellington" + ". Please select your next battle location to travel to." + "</div></html>");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(12, 49, 207, 106);
		panelItem.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1 = new JLabel("<html><div>" + "Gold: " + "0" + " coins. Points: " + "0" + "</div></html>");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(12, 23, 182, 44);
		panelItem.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		
		JLabel lblDay = new JLabel(String.format("<html><div>Current day: %d of %d days</div></html>", 1, 15));
		lblDay.setForeground(Color.WHITE);
		lblDay.setBounds(12, 12, 207, 25);
		panelItem.add(lblDay);
		lblDay.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		
		JButton btnFarewellSpit_1_1 = new JButton("Visit FreshChoice Takaka");
		btnFarewellSpit_1_1.setForeground(Color.WHITE);
		btnFarewellSpit_1_1.setBounds(12, 189, 207, 25);
		panelItem.add(btnFarewellSpit_1_1);
		btnFarewellSpit_1_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		btnFarewellSpit_1_1.setBackground(Color.RED);
		
		JButton btnFarewellSpit_1 = new JButton("Randomly select next battle");
		btnFarewellSpit_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		btnFarewellSpit_1.setBackground(SystemColor.info);
		btnFarewellSpit_1.setBounds(12, 153, 207, 25);
		panelItem.add(btnFarewellSpit_1);
		
		JButton btnFarewellSpit_1_1_1 = new JButton("My inventory");
		btnFarewellSpit_1_1_1.setForeground(Color.WHITE);
		btnFarewellSpit_1_1_1.setBounds(12, 216, 207, 25);
		panelItem.add(btnFarewellSpit_1_1_1);
		btnFarewellSpit_1_1_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		btnFarewellSpit_1_1_1.setBackground(new Color(0, 153, 51));
		
		JLabel lblMapCover = new JLabel("");
		lblMapCover.setIcon(new ImageIcon(MapScreen.class.getResource("/assets/ui/img/CookMapResized.jpg")));
		lblMapCover.setBounds(0, 0, 590, 720);
		window.getContentPane().add(lblMapCover);
	}
}
