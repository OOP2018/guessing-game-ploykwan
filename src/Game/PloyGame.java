package Game;
import java.util.Random;

/**
 * Game of guessing a secret number.
 * 
 * @author Kwankaew Uttama
 *
 */
public class PloyGame extends NumberGame {

	private int upperbound;
	private int secret;
	private String message;

	/**
	 * Initialize a new game.
	 * 
	 * @param upperbound
	 *            is the max value for the secret number (>1).
	 */
	public PloyGame(int upperbound) {
		this.upperbound = upperbound;
		this.secret = getRandom(upperbound);
		this.message = "T'm thinking of a number between 1 and " + upperbound;
		this.count = 0;
	}

	/**
	 * Check the number that the user input is correct or not.
	 * 
	 * @param number
	 *            is that user guess.
	 * 
	 * @return true if the answer correct, and false if the answer wrong.
	 */
	public boolean guess(int number) {
		this.count++;
		if (number == this.secret) {
			setMessage("Correct!, the secret number is " + number);
			setChanged();
			notifyObservers(number);
			return true;
		}
		if (number > this.secret) {
			setMessage("Sorry, too large.");
		} else {
			setMessage("Sorry, too small.");
		}
		setChanged();
		notifyObservers(number);
		return false;
	}

	/**
	 * 
	 * @return the upperbound for the solution.
	 */
	public int getUpperBound() {
		return this.upperbound;
	}

	/**
	 * 
	 * @return the message that you correct or not.
	 */
	public String toString() {
		return this.message;
	}

	/**
	 * Get the number of times that you use to guessed.
	 */
	public int getCount() {
		return this.count;
	}

	/**
	 * Random the secret number.
	 */
	public int getRandom(int upperBound) {
		// generate an unpredictable seed
		long seed = System.nanoTime();
		Random rand = new Random(seed);
		// get a random number between 0 and upperbound-1. Add 1 so the value is
		// 1 - upperbound.
		int value = rand.nextInt(upperBound) + 1;
		return value;
	}

}
