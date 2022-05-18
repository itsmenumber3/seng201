package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class QuizScreen {

	private JFrame frmMonsterQuiz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizScreen window = new QuizScreen();
					window.frmMonsterQuiz.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QuizScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMonsterQuiz = new JFrame();
		frmMonsterQuiz.setTitle("Monster Quiz");
		frmMonsterQuiz.setBounds(100, 100, 708, 500);
		frmMonsterQuiz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMonsterQuiz.getContentPane().setLayout(null);
		
		JLabel lblWhatIs = new JLabel("<html><div>The name of the first female Prime Minister of New Zealand</div></html>");
		lblWhatIs.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblWhatIs.setBounds(35, 44, 450, 95);
		frmMonsterQuiz.getContentPane().add(lblWhatIs);
		
		JButton btnJacindaArdern = new JButton("Jacinda Ardern");
		btnJacindaArdern.setBounds(12, 339, 166, 106);
		frmMonsterQuiz.getContentPane().add(btnJacindaArdern);
		
		JButton btnJudithCollins = new JButton("Judith Collins");
		btnJudithCollins.setBounds(181, 339, 166, 106);
		frmMonsterQuiz.getContentPane().add(btnJudithCollins);
		
		JButton btnJacindaArdern_1_1 = new JButton("Helen Clark");
		btnJacindaArdern_1_1.setBounds(350, 339, 166, 106);
		frmMonsterQuiz.getContentPane().add(btnJacindaArdern_1_1);
		
		JButton btnJacindaArdern_1_1_1 = new JButton("Jenny Shipley");
		btnJacindaArdern_1_1_1.setBounds(520, 339, 166, 106);
		frmMonsterQuiz.getContentPane().add(btnJacindaArdern_1_1_1);
	}

}
