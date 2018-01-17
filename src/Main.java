/**
 * A main class for the GuessingGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 */
public class Main {
	public static void main(String[] args) {
		// upper limit for secret number in guessing game
		int upperBound = 100;
		NumberGame game = new PittayutGame(upperBound);
		//GameConsole ui = new GameConsole( );
		GameSolver ui = new GameSolver( );
		int solution = ui.play( game );
		
		System.out.println("play() returned "+solution);
		
		System.out.println("You guessed "+(game.getCount())+" times.");
	}
}
