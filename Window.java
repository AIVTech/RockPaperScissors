import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Window {
	
	public static JRadioButton rock;
	public static JRadioButton paper;
	public static JRadioButton scissors;
	public static JButton hit;
	public static JLabel winner;
	
	private JFrame frame;
	
	public static final ImageIcon playerRock = new ImageIcon("res/playerRock.png");
	public static final ImageIcon playerPaper = new ImageIcon("res/playerPaper.png");
	public static final ImageIcon playerScissors = new ImageIcon("res/playerScissors.png");
	public static final ImageIcon computerRock = new ImageIcon("res/computerRock.png");
	public static final ImageIcon computerPaper = new ImageIcon("res/computerPaper.png");
	public static final ImageIcon computerScissors = new ImageIcon("res/computerScissors.png");
	
	public static List<String> rps = new ArrayList<String>();
	public static List<Integer> values = new ArrayList<Integer>();
	public static String element;
	public static int elementValue;
	public static boolean playing = true;
	public static String computerElement;
	public static String playerElement;
	public static int playerValue;
	public static boolean playerChoosing = false;
	private static JLabel lblOpponentsChoice;
	private static JLabel computerChoice;
	private JButton nextRound;
	private JLabel playerImage;
	private JLabel VSLabel;
	private JLabel computerImage;
	private JButton play;
	
	public static void setup() {
		rps.add("rock");
		rps.add("paper");
		rps.add("scissors");
		
	}
	
	public static String getRPS() {
		SecureRandom rand = new SecureRandom();
		int randomIndex = rand.nextInt(3);
		element = rps.get(randomIndex);
		return element;
	}
	
	public static void chooseWinner() {
		if(playerValue == 0) { // if rock
			if(computerElement == "scissors") {
				winner.setText("You");
			}
			if(computerElement == "paper") {
				winner.setText("Opponent");
			} 
			if(computerElement == "rock") {
				winner.setText("Tie!");
			}
		}
		if(playerValue == 1) { // if paper
			if(computerElement == "rock") {
				winner.setText("You");
			}
			if(computerElement == "scissors") {
				winner.setText("Opponent");
			} 
			if(computerElement == "paper") {
				winner.setText("Tie!");
			}
		} 
		if(playerValue == 2) { // if scissors
			if(computerElement == "paper") {
				winner.setText("You");
			}
			if(computerElement == "rock") {
				winner.setText("Opponent");
			} 
			if(computerElement == "scissors") {
				winner.setText("Tie!");
			}
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
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
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Rock/Paper/Scissors");
		frame.setBounds(260, 120, 750, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel title = new JLabel("");
		ImageIcon icon = new ImageIcon("res/mainTitle.png");
		title.setBounds(232, 21, 272, 132);
		frame.getContentPane().add(title);
		title.setIcon(icon);
		
		JLabel lblLetsPlay = new JLabel("Let's Play!");
		lblLetsPlay.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		lblLetsPlay.setForeground(Color.BLUE);
		lblLetsPlay.setBounds(75, 38, 101, 72);
		frame.getContentPane().add(lblLetsPlay);
		
		JLabel label = new JLabel("Let's Play!");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		label.setBounds(550, 38, 101, 72);
		frame.getContentPane().add(label);
		
		JLabel lblWinner = new JLabel("Winner:");
		lblWinner.setFont(new Font("KufiStandardGK", Font.PLAIN, 18));
		lblWinner.setBounds(75, 467, 87, 38);
		frame.getContentPane().add(lblWinner);
		
		winner = new JLabel("TBD");
		winner.setFont(new Font("Lao Sangam MN", Font.PLAIN, 18));
		winner.setBounds(164, 465, 142, 38);
		frame.getContentPane().add(winner);
		
		rock = new JRadioButton("Rock");
		rock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rock.isSelected()) {
					paper.setSelected(false);
					scissors.setSelected(false);
					hit.setEnabled(true);
					playerValue = 0;
					playerImage.setIcon(playerRock);
				} else {
					hit.setEnabled(false);
					playerImage.setIcon(null);
				}
			}
		});
		rock.setVisible(false);
		rock.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		rock.setBounds(51, 247, 141, 23);
		frame.getContentPane().add(rock);
		
		paper = new JRadioButton("Paper");
		paper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(paper.isSelected()) {
					rock.setSelected(false);
					scissors.setSelected(false);
					hit.setEnabled(true);
					playerValue = 1;
					playerImage.setIcon(playerPaper);
				} else {
					hit.setEnabled(false);
					playerImage.setIcon(null);
				}
			}
		});
		paper.setVisible(false);
		paper.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		paper.setBounds(51, 282, 141, 23);
		frame.getContentPane().add(paper);
		
		scissors = new JRadioButton("Scissors");
		scissors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(scissors.isSelected()) {
					rock.setSelected(false);
					paper.setSelected(false);
					hit.setEnabled(true);
					playerValue = 2;
					playerImage.setIcon(playerScissors);
				} else {
					hit.setEnabled(false);
					playerImage.setIcon(null);
				}
			}
		});
		scissors.setVisible(false);
		scissors.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		scissors.setBounds(51, 317, 141, 23);
		frame.getContentPane().add(scissors);
		
		hit = new JButton("GO");
		hit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // PLAYING THE ROUND
				computerElement = getRPS();
				if(computerElement == "rock") {
					computerImage.setIcon(computerRock);
				}
				if(computerElement == "paper") {
					computerImage.setIcon(computerPaper);
				}
				if(computerElement == "scissors") {
					computerImage.setIcon(computerScissors);
				}
				chooseWinner();
				computerChoice.setText(computerElement);
				hit.setEnabled(false);
				nextRound.setVisible(true);
			}
		});
		hit.setBounds(305, 467, 117, 29);
		frame.getContentPane().add(hit);
		hit.setEnabled(false);
		
		play = new JButton("PLAY");
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rock.setVisible(true);
				paper.setVisible(true);
				scissors.setVisible(true);
				play.setEnabled(false);
			}
		});
		play.setFont(new Font("Lantinghei TC", Font.PLAIN, 16));
		play.setBounds(305, 181, 117, 29);
		frame.getContentPane().add(play);
		
		lblOpponentsChoice = new JLabel("Opponents Choice:");
		lblOpponentsChoice.setFont(new Font("Lao Sangam MN", Font.PLAIN, 16));
		lblOpponentsChoice.setBounds(305, 240, 147, 38);
		frame.getContentPane().add(lblOpponentsChoice);
		
		computerChoice = new JLabel("? ? ?");
		computerChoice.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		computerChoice.setBounds(464, 251, 108, 16);
		frame.getContentPane().add(computerChoice);
		
		nextRound = new JButton("Next Round");
		nextRound.setVisible(false);
		nextRound.addActionListener(new ActionListener() { // NEXT ROUND
			public void actionPerformed(ActionEvent e) {
				nextRound.setVisible(false);
				rock.setSelected(false);
				paper.setSelected(false);
				scissors.setSelected(false);
				computerChoice.setText("? ? ?");
				playerImage.setIcon(null);
				computerImage.setIcon(null);
				winner.setText("TBD");
			}
		});
		nextRound.setBounds(434, 467, 117, 29);
		frame.getContentPane().add(nextRound);
		
		playerImage = new JLabel("\t\t          ?\n");
		playerImage.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		playerImage.setBounds(243, 304, 108, 96);
		frame.getContentPane().add(playerImage);
		
		VSLabel = new JLabel("V.S.");
		VSLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 20));
		VSLabel.setBounds(363, 305, 75, 96);
		frame.getContentPane().add(VSLabel);
		
		computerImage = new JLabel("?\n");
		computerImage.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		computerImage.setBounds(434, 304, 124, 96);
		frame.getContentPane().add(computerImage);
		
	}
}
