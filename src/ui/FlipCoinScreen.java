package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import main.GameEnvironment;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JButton;

public class FlipCoinScreen {

	private JFrame frame;
	private GameEnvironment gameEnvironment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlipCoinScreen window = new FlipCoinScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FlipCoinScreen(GameEnvironment inputGameEnvironment) {
		this.gameEnvironment = inputGameEnvironment;
		initialize();
		frame.setVisible(true);
	}

	public void closeWindow() {
		frame.dispose();
	}

	public void finishedWindow() {
		gameEnvironment.closeFlipCoinScreen
	}

	/**
	 * Create the application.
	 */
	public FlipCoinScreen() {
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
		
		JLabel lblFlipACoin = new JLabel("Flip a Coin!");
		lblFlipACoin.setHorizontalAlignment(SwingConstants.CENTER);
		lblFlipACoin.setFont(new Font("Century Schoolbook L", Font.PLAIN, 25));
		lblFlipACoin.setBounds(197, 11, 356, 49);
		frame.getContentPane().add(lblFlipACoin);
		
		JLabel lblselectHeadsOr = new JLabel("<html><div>Select Heads or Tails below to see if you win this chance to attack</div></html>");
		lblselectHeadsOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblselectHeadsOr.setFont(new Font("Century Schoolbook L", Font.PLAIN, 18));
		lblselectHeadsOr.setBounds(72, 71, 606, 90);
		frame.getContentPane().add(lblselectHeadsOr);
		
		JLabel lblTailSymbol = new JLabel("");
		lblTailSymbol.setIcon(new ImageIcon(FlipCoinScreen.class.getResource("/assets/ui/img/Tails.jpg")));
		lblTailSymbol.setBounds(202, 194, 96, 96);
		frame.getContentPane().add(lblTailSymbol);
		
		JLabel lblHeadsSymbol = new JLabel("");
		lblHeadsSymbol.setIcon(new ImageIcon(FlipCoinScreen.class.getResource("/assets/ui/img/Heads.jpg")));
		lblHeadsSymbol.setBounds(452, 194, 96, 96);
		frame.getContentPane().add(lblHeadsSymbol);
		
		JToggleButton tglbtnHeads = new JToggleButton("Heads");
		tglbtnHeads.setBounds(452, 315, 96, 23);
		frame.getContentPane().add(tglbtnHeads);
		
		JToggleButton tglbtnTails = new JToggleButton("Tails");
		tglbtnTails.setBounds(202, 315, 96, 23);
		frame.getContentPane().add(tglbtnTails);
		
		JLabel lblSelectionDisplay = new JLabel("You've selected: <choice>");
		lblSelectionDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectionDisplay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectionDisplay.setBounds(248, 356, 204, 33);
		frame.getContentPane().add(lblSelectionDisplay);
		
		JButton btnFlipCoin = new JButton("Flip the Coin");
		btnFlipCoin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFlipCoin.setBounds(270, 400, 160, 42);
		frame.getContentPane().add(btnFlipCoin);
	}

}
