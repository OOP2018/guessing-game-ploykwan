package ui;

import Game.NumberGame;
import Game.PloyGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GameController {
	@FXML
	private Label prompt;
	@FXML
	private TextField textfield;

	private NumberGame guess;
	private int answer;

	public void setGuess(NumberGame guess) {
		this.guess = guess;
	}

	public void handleAnswer(ActionEvent event) {
		String text = textfield.getText().trim();
		answer = Integer.parseInt(text);
		boolean check = guess.guess(answer);
		prompt.setText(guess.getMessage());
		if(check == false) textfield.clear();;
	}

}
