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
	private JTextField textFieldMonsterName;

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
		
		JLabel lblPickYourFirst = new JLabel("Pick your first monster");
		lblPickYourFirst.setFont(new Font("Dialog", Font.BOLD, 24));
		lblPickYourFirst.setBounds(28, 26, 458, 37);
		frmPickYourFirst.getContentPane().add(lblPickYourFirst);
		
		JLabel lblNameThisMonster = new JLabel("Name this monster");
		lblNameThisMonster.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNameThisMonster.setBounds(30, 98, 220, 26);
		frmPickYourFirst.getContentPane().add(lblNameThisMonster);
		
		JButton buttonMonster1 = new JButton("New button");
		buttonMonster1.setBounds(30, 233, 165, 73);
		frmPickYourFirst.getContentPane().add(buttonMonster1);
		
		JButton btnMonster2 = new JButton("New button");
		btnMonster2.setBounds(30, 318, 165, 73);
		frmPickYourFirst.getContentPane().add(btnMonster2);
		
		JButton btnMonster3 = new JButton("New button");
		btnMonster3.setBounds(207, 233, 165, 73);
		frmPickYourFirst.getContentPane().add(btnMonster3);
		
		JButton btnMonster4 = new JButton("New button");
		btnMonster4.setBounds(207, 318, 165, 73);
		frmPickYourFirst.getContentPane().add(btnMonster4);
		
		JLabel lblNameThisMonster_1 = new JLabel("");
		lblNameThisMonster_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNameThisMonster_1.setBounds(28, 301, 179, 26);
		frmPickYourFirst.getContentPane().add(lblNameThisMonster_1);
		
		textFieldMonsterName = new JTextField();
		textFieldMonsterName.setForeground(Color.BLACK);
		textFieldMonsterName.setFont(new Font("Dialog", Font.PLAIN, 18));
		textFieldMonsterName.setColumns(10);
		textFieldMonsterName.setBackground(new Color(230, 230, 250));
		textFieldMonsterName.setBounds(30, 136, 278, 33);
		frmPickYourFirst.getContentPane().add(textFieldMonsterName);
		
		JLabel lblThenSelectOne = new JLabel("Then select one from below");
		lblThenSelectOne.setFont(new Font("Dialog", Font.BOLD, 18));
		lblThenSelectOne.setBounds(30, 195, 296, 26);
		frmPickYourFirst.getContentPane().add(lblThenSelectOne);
		
		JButton btnConfirmMonsterChoice = new JButton("Confirm monster choice");
		btnConfirmMonsterChoice.setBounds(479, 400, 232, 37);
		frmPickYourFirst.getContentPane().add(btnConfirmMonsterChoice);
		
		JPanel panelBackground = new JPanel();
		panelBackground.setLayout(null);
		panelBackground.setBackground(Color.WHITE);
		panelBackground.setBounds(0, -11, 759, 492);
		frmPickYourFirst.getContentPane().add(panelBackground);
		
		JPanel panelBackgroundMonsterInformation = new JPanel();
		panelBackgroundMonsterInformation.setBounds(403, 98, 305, 299);
		panelBackground.add(panelBackgroundMonsterInformation);
		panelBackgroundMonsterInformation.setLayout(null);
		panelBackgroundMonsterInformation.setBackground(Color.GRAY);
	}
}
