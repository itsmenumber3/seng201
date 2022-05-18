package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InventoryDraft {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryDraft window = new InventoryDraft();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InventoryDraft() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInventory = new JLabel("Inventory");
		lblInventory.setFont(new Font("Dialog", Font.BOLD, 24));
		lblInventory.setBounds(30, 24, 458, 37);
		frame.getContentPane().add(lblInventory);
		
		JLabel lblYourBalance_1_1_2 = new JLabel("0 golds");
		lblYourBalance_1_1_2.setBounds(536, 31, 101, 15);
		frame.getContentPane().add(lblYourBalance_1_1_2);
		lblYourBalance_1_1_2.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JButton btnReturnToDashboard = new JButton("Return to Map");
		btnReturnToDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnReturnToDashboard.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnReturnToDashboard.setBackground(SystemColor.info);
		btnReturnToDashboard.setBounds(179, 205, 136, 25);
		frame.getContentPane().add(btnReturnToDashboard);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 73, 724, 388);
		frame.getContentPane().add(tabbedPane);
		
		JButton btnReturnToDashboard_1 = new JButton("Return to Map");
		btnReturnToDashboard_1.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		btnReturnToDashboard_1.setBackground(SystemColor.info);
		btnReturnToDashboard_1.setBounds(600, 24, 136, 25);
		frame.getContentPane().add(btnReturnToDashboard_1);
	}
}
