package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.SystemColor;

public class BattleScreen {

	private JFrame frmBattle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleScreen window = new BattleScreen();
					window.frmBattle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BattleScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBattle = new JFrame();
		frmBattle.setTitle("Battle");
		frmBattle.setBounds(100, 100, 750, 500);
		frmBattle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBattle.getContentPane().setLayout(null);
		
		JPanel panelItem = new JPanel();
		panelItem.setLayout(null);
		panelItem.setOpaque(true);
		panelItem.setBackground(new Color(0, 51, 153));
		panelItem.setBounds(0, 0, 434, 469);
		frmBattle.getContentPane().add(panelItem);
		
		JLabel lblNewLabel_1_1 = new JLabel("<html><div>Farewell Spit</div></html>");
		lblNewLabel_1_1.setBounds(34, 26, 329, 77);
		panelItem.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Century Schoolbook L", Font.BOLD, 24));
		
		JLabel lblNewLabel_1 = new JLabel("<html><div>Farewell Spit is home to Mud Monster, a dangerous monster that has taken many lives of tourists. Kill it, and you get rewarded with 1000 gold coins from the NZ Government, plus get to steal all of its stuff. Lose against it, and die at the hands of it and game is over. Are you ready?</div></html>");
		lblNewLabel_1.setBounds(34, 89, 329, 213);
		panelItem.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		
		JButton btnFarewellSpit_1_1 = new JButton("Travel to Farewell Spit");
		btnFarewellSpit_1_1.setBounds(34, 347, 364, 43);
		panelItem.add(btnFarewellSpit_1_1);
		btnFarewellSpit_1_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		btnFarewellSpit_1_1.setBackground(SystemColor.info);
		
		JButton btnFarewellSpit_1 = new JButton("Select another battle");
		btnFarewellSpit_1.setBounds(34, 402, 364, 25);
		panelItem.add(btnFarewellSpit_1);
		btnFarewellSpit_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		btnFarewellSpit_1.setBackground(SystemColor.info);
	}

}
