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
		 int guess = (1+(game.getUpperBound()-1)/2)-1;
		 int num = guess/2;
		 int lastguess;
		 while(!game.guess(guess)){
				System.out.print("Your answer? ");
				System.out.println(guess);
				System.out.println( game.getMessage() );
				lastguess = guess ;
				if( game.getMessage().contains("too small")){
					guess = guess + num;
				}
				else if( game.getMessage().contains("too large")){
					guess = guess - num;
				}	
				if( num > 1){
					num /=2 ;
				}
				if( lastguess == guess ){
					guess++;
				}
			}
		 System.out.print("Your answer? ");
		 System.out.println(guess);
		 System.out.println( game.getMessage() );
	 	return guess;
	 }
}
