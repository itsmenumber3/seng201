package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JPanel;

public class FirstMonsterSetupScreen {

	private JFrame frmPickYourFirst;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstMonsterSetupScreen window = new FirstMonsterSetupScreen();
					window.frmPickYourFirst.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FirstMonsterSetupScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPickYourFirst = new JFrame();
		frmPickYourFirst.setTitle("Pick your first monster");
		frmPickYourFirst.setBounds(100, 100, 750, 500);
		frmPickYourFirst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPickYourFirst.getContentPane().setLayout(null);
		
		JButton btnConfirmMonsterChoice = new JButton("Confirm monster choice");
		btnConfirmMonsterChoice.setBounds(479, 400, 232, 37);
		frmPickYourFirst.getContentPane().add(btnConfirmMonsterChoice);
		
		JLabel lblNameThisMonster = new JLabel("Name this monster");
		lblNameThisMonster.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNameThisMonster.setBounds(30, 98, 220, 26);
		frmPickYourFirst.getContentPane().add(lblNameThisMonster);
		
		JLabel lblPickYourFirst = new JLabel("Pick your first monster");
		lblPickYourFirst.setFont(new Font("Dialog", Font.BOLD, 24));
		lblPickYourFirst.setBounds(28, 26, 458, 37);
		frmPickYourFirst.getContentPane().add(lblPickYourFirst);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(30, 233, 165, 73);
		frmPickYourFirst.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(30, 318, 165, 73);
		frmPickYourFirst.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("New button");
		btnNewButton_1_1.setBounds(207, 233, 165, 73);
		frmPickYourFirst.getContentPane().add(btnNewButton_1_1);
		
		JTextPane txtpnSdsds = new JTextPane();
		txtpnSdsds.setText("Please select a monster to view information. Remember to give it a name before you confirm your choice.");
		txtpnSdsds.setBounds(408, 98, 303, 282);
		frmPickYourFirst.getContentPane().add(txtpnSdsds);
		
		JButton btnNewButton_1_1_1 = new JButton("New button");
		btnNewButton_1_1_1.setBounds(207, 318, 165, 73);
		frmPickYourFirst.getContentPane().add(btnNewButton_1_1_1);
		
		JLabel lblNameThisMonster_1 = new JLabel("");
		lblNameThisMonster_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNameThisMonster_1.setBounds(28, 301, 179, 26);
		frmPickYourFirst.getContentPane().add(lblNameThisMonster_1);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(230, 230, 250));
		textField_1.setBounds(28, 136, 278, 33);
		frmPickYourFirst.getContentPane().add(textField_1);
		
		JLabel lblThenSelectOne = new JLabel("Then select one from below");
		lblThenSelectOne.setFont(new Font("Dialog", Font.BOLD, 18));
		lblThenSelectOne.setBounds(30, 195, 296, 26);
		frmPickYourFirst.getContentPane().add(lblThenSelectOne);
		
		JPanel panelBackground = new JPanel();
		panelBackground.setLayout(null);
		panelBackground.setBackground(Color.WHITE);
		panelBackground.setBounds(0, -12, 759, 492);
		frmPickYourFirst.getContentPane().add(panelBackground);
	}
}
