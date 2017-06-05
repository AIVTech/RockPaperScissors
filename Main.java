import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static List<String> rps = new ArrayList<String>();
	public static List<Integer> values = new ArrayList<Integer>();
	public static String element;
	public static int elementValue;
	public static boolean playing = true;
	public static String computerElement;
	public static String playerElement;
	public static int playerValue;
	public static boolean playerChoosing = false;
	
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
	
	public static void playGame() {
		// main code goes in here
		System.out.println("\nWelcome to Rock/Paper/Scissors Game! \n");
		sleep(400);
		System.out.println("Press enter to continue: ");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		playerChoosing = true;
		while(playerChoosing) {
			computerElement = getRPS();
			getPlayerChoice();
		}
		sleep(700);
		chooseWinner();
		sleep(200);
		computerElement = null;
		//playing = false;
	}
	
	public static void chooseWinner() {
		if(playerValue == 0) { // if rock
			if(computerElement == "scissors") {
				System.out.println("You: " + playerElement + "  Opponent: " + computerElement + "\n");
				System.out.println("You won!\n");
			}
			if(computerElement == "paper") {
				System.out.println("You: " + playerElement + "  Opponent: " + computerElement + "\n");
				System.out.println("You lost!\n");
			} 
			if(computerElement == "rock") {
				System.out.println("You: " + playerElement + "  Opponent: " + computerElement + "\n");
				System.out.println("It is a tie!\n");
			}
		}
		if(playerValue == 1) { // if paper
			if(computerElement == "rock") {
				System.out.println("You: " + playerElement + "  Opponent: " + computerElement + "\n");
				System.out.println("You won!\n");
			}
			if(computerElement == "scissors") {
				System.out.println("You: " + playerElement + "  Opponent: " + computerElement + "\n");
				System.out.println("You lost!\n");
			} 
			if(computerElement == "paper") {
				System.out.println("You: " + playerElement + "  Opponent: " + computerElement + "\n");
				System.out.println("It is a tie!\n");
			}
		} 
		if(playerValue == 2) { // if scissors
			if(computerElement == "paper") {
				System.out.println("You: " + playerElement + "  Opponent: " + computerElement + "\n");
				System.out.println("You won!\n");
			}
			if(computerElement == "rock") {
				System.out.println("You: " + playerElement + "  Opponent: " + computerElement + "\n");
				System.out.println("You lost!\n");
			} 
			if(computerElement == "scissors") {
				System.out.println("You: " + playerElement + "  Opponent: " + computerElement + "\n");
				System.out.println("It is a tie!\n");
			}
		}
	}
	
	public static void getPlayerChoice() {
		System.out.println("What is your choice? \n1) rock\n2) paper\n3) scissors\nChoose your number\n");
		Scanner scanner = new Scanner(System.in);
		int playerChoice = scanner.nextInt();
		if(playerChoice == 1) {
			playerElement = "rock";
			playerValue = 0;
			playerChoosing = false;
		}
		if(playerChoice == 2) {
			playerElement = "paper";
			playerValue = 1;
			playerChoosing = false;
		} 
		if(playerChoice == 3) {
			playerElement = "scissors";
			playerValue = 2;
			playerChoosing = false;
		} 
		if(playerChoice != 1 && playerChoice != 2 && playerChoice != 3) {
			System.out.println("Sorry, invalid choice ... \n");
		}
	}
	
	public static void sleep(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		setup();
		while(playing) {
			playGame();
		}
	}
	
}
