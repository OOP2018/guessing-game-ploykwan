package ui;

import java.util.Observable;
import java.util.Observer;

import Game.NumberGame;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GuessedView extends Stage implements Observer {
	/** the stage (top-level window) for showing scene */
	private Stage stage;
	/** a counter to show value of */
	private NumberGame game;
	/** the label that shows the counter value. */
	private Label label;
	
	/**
	 * Initialize a CounterView, which shows value of a counter.
	 * @param counter the Counter to show.
	 */
	public GuessedView(NumberGame game) {
		this.game = game;
		initComponents();
	}
	
	private void initComponents() {
		stage = this;
		// components and containers for our window
		HBox root = new HBox();
		//Set some padding around the HBox
		root.setPadding(new Insets(10));
		//Align components in center of the HBox
		root.setAlignment(Pos.CENTER);
		// The label that will show the counter value.
		label = new Label("   ");
		// make the label big enough
		label.setPrefWidth(144);
		//Make the text BIG. Use setFont to create a font.
		//Be careful to import the correct Font class (not java.awt.Font).
		label.setFont(new Font("Arial", 80.0));
		//Set the text alignment to CENTER
		label.setAlignment(Pos.CENTER);
		// Add the label to the HBox.  You can all more components, too.
		root.getChildren().add(label);
		// Create a Scene using HBox as the root element
		Scene scene = new Scene(root);
		// show the scene on the stage
		stage.setScene(scene);
		stage.setTitle("Your guessed");
		stage.sizeToScene();
	}
	
	/** Show the window and update the counter value. */
	public void run() {
		stage.show();
		displayNumber(0);
	}
	
	public void displayNumber(int number) {
		label.setText( String.format("%2d", number) );
	}

	@Override
	public void update(Observable o, Object arg) {
		int number = (int) arg;
		displayNumber(number);
	}	
}
