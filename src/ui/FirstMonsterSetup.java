package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class FirstMonsterSetup {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstMonsterSetup window = new FirstMonsterSetup();
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
	public FirstMonsterSetup() {
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
		
		JLabel lblPickYourFirst = new JLabel("Pick your first monster!");
		lblPickYourFirst.setBounds(44, 48, 260, 15);
		frame.getContentPane().add(lblPickYourFirst);
		
		JButton btnNewButton = new JButton("Dragon");
		btnNewButton.setBounds(44, 292, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnZombie = new JButton("Zombie");
		btnZombie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnZombie.setBounds(186, 292, 117, 25);
		frame.getContentPane().add(btnZombie);
		
		JButton btnSpirit = new JButton("Spirit");
		btnSpirit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSpirit.setBounds(328, 292, 117, 25);
		frame.getContentPane().add(btnSpirit);
		
		JButton btnTroll = new JButton("Troll");
		btnTroll.setBounds(465, 292, 117, 25);
		frame.getContentPane().add(btnTroll);
		
		JButton btnSkeleton = new JButton("Skeleton");
		btnSkeleton.setBounds(594, 292, 117, 25);
		frame.getContentPane().add(btnSkeleton);
		
		JButton btnConfirmMonsterChoice = new JButton("Confirm monster choice");
		btnConfirmMonsterChoice.setBounds(479, 418, 232, 25);
		frame.getContentPane().add(btnConfirmMonsterChoice);
		
		JLabel lblNameThisMonster = new JLabel("Name this monster");
		lblNameThisMonster.setBounds(44, 97, 179, 8);
		frame.getContentPane().add(lblNameThisMonster);
		
		textField = new JTextField();
		textField.setBounds(47, 130, 114, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
