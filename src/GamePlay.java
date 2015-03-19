/**
 * This class simply launches the program, calling GuessGame's methods.
 * The program as a whole is a random number guessing game.
 * @author Richard Barney
 * @version 1.0.0 November 2012
 */
public class GamePlay {
	/**
	 * main method as required by JVM
	 * @param  args   standard command line parameters as a string array.
	 */
	public static void main(String[] args) {
		// create GuessGame object and call class methods to play game
		GuessGame player = new GuessGame();
		System.out.println("Welcome to the Number Guessing Game!"
							+"\nIn this game, the computer will pick a random number between 1 and 1000, and you have to guess it!"
							+"\nGood luck!\n");
		player.getInputFromUser();
		player.playRoundOfGame();
	} // end method main
} // end class GamePlay
