//import statements
import java.util.Scanner;
import java.util.Random;
/**
 * This class holds all the data and math for the guessing game. The program will
 * generate a random number and the player has to guess that number.
 * @author Richard Barney
 * @version 1.0.0 November 2012
 */
public class GuessGame {

	/**
	 * integer to hold the number the user entered.
	 */
	private int nGuessNumber;
	/**
	 * integer to hold the number of guesses.
	 */
	private int nNumberOfGuesses;
	/**
	 * Random object to generate random numbers.
	 */
	Random randomNumber = new Random();

	/**
	 * Default constructor.
	 */
	public GuessGame() {
		nGuessNumber = 0;
		nNumberOfGuesses = 0;
	}
	
	/**
	 * Get method that returns the number guessed.
	 * @return the number guessed as an integer.
	 */
	public int getGuessNumber() { return nGuessNumber; }
	/**
	 * Get method that returns the number of guesses.
	 * @return the number of guesses as an integer.
	 */
	public int getNumberOfGuesses() { return nNumberOfGuesses; }
	
	/**
	 * Set method that sets the number guessed.
	 * @param	nGuessNumber	number guessed as an integer.	
	 */
	public void setGuessNumBer(int nGuessNumber) {
		this.nGuessNumber = nGuessNumber;
	}
	/**
	 * Set method that sets the number of guesses.
	 * @param	nGuessNumber	number of guesses as an integer.	
	 */
	public void setNumberOfTries(int nNumberOfGuesses) {
		this.nNumberOfGuesses = nNumberOfGuesses;
	}
	
	/**
	 * Creates a random number between 1 and 1000.
	 * @return a random number between 1 and 1000.
	 */
	public int randomNumber() {
		int random = randomNumber.nextInt(1000) + 1;
		return random;
	}
	
	/**
	 * Void method that gets input from the user (a num between 1 and 1000).
	 */
	public void getInputFromUser() {
		Scanner input = new Scanner (System.in);
		do {
			System.out.print("Enter a number between 1 and 1000: ");
			nGuessNumber = input.nextInt();
			++nNumberOfGuesses; // increment the number of guesses
		} while( nGuessNumber < 1 || nGuessNumber > 1000);
	}
	
	/**
	 * Void method that does all the calculations for the game.
	 */
	public void playRoundOfGame() {
		Scanner input = new Scanner(System.in);
		int nPlayAgain = 1; // int used for if player wants to play again
		int nRandomNum = randomNumber(); // generate the random number

		// loop the program as long as nPlayAgain equals 1
		while(nPlayAgain == 1) {
			// tell the user if he guessed too high
			if (getGuessNumber() > nRandomNum) {
				System.out.println("You guessed too high!");
			}
			
			// tell the user if he guessed too low
			if (getGuessNumber() < nRandomNum) {
				System.out.println("You guessed too low!");
			}
	
			// if the player guesses the correct number, display the
			// win message and ask the player if he wants to play again
			if (getGuessNumber() == nRandomNum) {
				System.out.println("Nice job! You guessed the correct number ("
								 +nRandomNum
								 +")!"
								 + "\nIt took you "
								 +getNumberOfGuesses()
								 +" tries to guess the correct number.");
				
				// ask user if they want to play again, 1 is yes 2 is no
				do {
					System.out.print("If you want to play again, enter 1. If you want to quit, enter 2: ");
					nPlayAgain = input.nextInt();
				} while (nPlayAgain < 1 || nPlayAgain > 2);
				
				// if player does not play again, say goodbye
				// else generate a new number to be guessed
				if (nPlayAgain == 2) {
					System.out.print("Exiting game... Goodbye!");
					return;
				}
				else {
					nNumberOfGuesses = 0; // reset the number of guesses
					nRandomNum = randomNumber(); // generate new random number
					System.out.println("Alright! Let's play again!"
										+"\nA new number has been generated!");
				}
			} // end if
			
			getInputFromUser(); // get user input again
		} // end while
	} // end method playRoundOfGame
} // end class GuessGame