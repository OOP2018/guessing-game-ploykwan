import java.util.Scanner;

/**
 * Automatically find the secret to any NumberGame.
 */

public class GameSolver {

	/**
	 * Play a NumberGame and return the solution.
	 * The NumberGame object must provide messages (getMessage)
	 * containing the phrase "too small" if a guess is too small
	 * and "too large" if a guess is too large, for efficient
	 * solution.
	 *
	 * @param game is the NumberGame to solve
	 * @return the correct answer.
	 */
	 public int play(NumberGame game){
		 System.out.println( game.toString() );
		 int num = game.getUpperBound()/4;
		 int guess = game.getUpperBound()/2;
		 while(!game.guess(guess)){
				System.out.print("Your answer? ");
				System.out.println(guess);
				System.out.println( game.getMessage() );
				if( game.getMessage().contains("too small")){
					guess = guess + num;
				}
				else if( game.getMessage().contains("too large")){
					guess = guess - num;
				}	
				if( num > 1){
					num /=2 ;
				}
			}
		 System.out.print("Your answer? ");
		 System.out.println(guess);
		 System.out.println( game.getMessage() );
	 	return guess;
	 }
}
