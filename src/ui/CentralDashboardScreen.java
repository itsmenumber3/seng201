package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CentralDashboardScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CentralDashboardScreen window = new CentralDashboardScreen();
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
	public CentralDashboardScreen() {
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
		
		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setBounds(28, 25, 134, 15);
		frame.getContentPane().add(lblDashboard);
		
		JLabel lblActions = new JLabel("Actions");
		lblActions.setBounds(28, 82, 70, 15);
		frame.getContentPane().add(lblActions);
		
		JButton btnVisitShop = new JButton("Visit Shop");
		btnVisitShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnVisitShop.setBounds(28, 109, 117, 25);
		frame.getContentPane().add(btnVisitShop);
		
		JButton btnViewInventory = new JButton("View Inventory");
		btnViewInventory.setBounds(156, 109, 157, 25);
		frame.getContentPane().add(btnViewInventory);
		
		JLabel lblInformation = new JLabel("Overview");
		lblInformation.setBounds(28, 165, 117, 15);
		frame.getContentPane().add(lblInformation);
		
		JButton btnBedroom = new JButton("Bedroom");
		btnBedroom.setBounds(325, 109, 157, 25);
		frame.getContentPane().add(btnBedroom);
		
		JButton btnBattles = new JButton("Fight");
		btnBattles.setBounds(494, 109, 157, 25);
		frame.getContentPane().add(btnBattles);
	}

}
