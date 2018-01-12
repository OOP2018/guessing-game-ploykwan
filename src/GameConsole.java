import java.util.Scanner;

/** 
 *  Play guessing game on the console.
 */
public class GameConsole {

	/** play the game. */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);
		
		// input answer until the answer is equal to secret number.
		System.out.println( game.toString() );
		int guess;
		do{
			System.out.println( game.getMessage() );
			System.out.print("Your answer? ");
			guess = console.nextInt();
		}while(!game.guess(guess));
		
		return guess;
	}
}
