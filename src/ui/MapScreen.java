package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.html.HTML;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;

public class MapScreen {

	private JFrame frmBattles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MapScreen window = new MapScreen();
					window.frmBattles.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		frmBattles = new JFrame();
		frmBattles.setTitle("Battles");
		frmBattles.setBounds(100, 100, 592, 744);
		frmBattles.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBattles.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Mt Cook");
		btnNewButton.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnMilesBeach = new JButton("90 Miles Beach");
		btnMilesBeach.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		btnMilesBeach.setBackground(SystemColor.info);
		btnMilesBeach.setBounds(358, 111, 119, 25);
		frmBattles.getContentPane().add(btnMilesBeach);
		
		JButton btnLakeTaupo = new JButton("Lake Taupo");
		btnLakeTaupo.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		btnLakeTaupo.setBackground(SystemColor.info);
		btnLakeTaupo.setBounds(413, 248, 106, 25);
		frmBattles.getContentPane().add(btnLakeTaupo);
		
		JButton btnFarewellSpit = new JButton("<html><div>Canterbury Wetlands</div></html>");
		btnFarewellSpit.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		btnFarewellSpit.setBackground(SystemColor.info);
		btnFarewellSpit.setBounds(333, 401, 97, 42);
		frmBattles.getContentPane().add(btnFarewellSpit);
		btnNewButton.setBackground(SystemColor.info);
		btnNewButton.setBounds(130, 457, 97, 25);
		frmBattles.getContentPane().add(btnNewButton);
		
		JButton btnSouthlandFarm = new JButton("Southland Farm");
		btnSouthlandFarm.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		btnSouthlandFarm.setBackground(SystemColor.info);
		btnSouthlandFarm.setBounds(163, 574, 126, 25);
		frmBattles.getContentPane().add(btnSouthlandFarm);
		
		JPanel panelItem = new JPanel();
		panelItem.setLayout(null);
		panelItem.setOpaque(true);
		panelItem.setBackground(new Color(0, 51, 153));
		panelItem.setBounds(29, 39, 231, 219);
		frmBattles.getContentPane().add(panelItem);
		
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
		btnFarewellSpit_1_1.setBounds(12, 179, 207, 25);
		panelItem.add(btnFarewellSpit_1_1);
		btnFarewellSpit_1_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		btnFarewellSpit_1_1.setBackground(SystemColor.info);
		
		JButton btnFarewellSpit_1 = new JButton("Randomly select next battle");
		btnFarewellSpit_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		btnFarewellSpit_1.setBackground(SystemColor.info);
		btnFarewellSpit_1.setBounds(12, 153, 207, 25);
		panelItem.add(btnFarewellSpit_1);
		
		JLabel lblMapCover = new JLabel("");
		lblMapCover.setIcon(new ImageIcon(MapScreen.class.getResource("/assets/ui/img/CookMapResized.jpg")));
		lblMapCover.setBounds(0, 0, 590, 720);
		frmBattles.getContentPane().add(lblMapCover);
	}
}
