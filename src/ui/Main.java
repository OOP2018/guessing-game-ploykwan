package ui;

import java.net.URL;

import Game.NumberGame;
import Game.PloyGame;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.fxml.FXMLLoader;

/**
 * Create a JavaFX user interface with 1 input view
 * and 2 observers that show the counter value, so that all
 * the views refer to the same Counter object.
 * 
 */
public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		// Create the Counter object (the "model" part of our app)
		//Counter counter = new Counter();
		int upperBound = 20;
		NumberGame game = new PloyGame(upperBound);
		
		try {
			URL url = getClass().getResource("GameUI.fxml");
			if (url == null) {
				System.out.println("Couldn't find file: GameUI.fxml");
				Platform.exit();
			}
			// Load the FXML and get reference to the loader
			FXMLLoader loader = new FXMLLoader(url);
			// Create the UI. This will instantiate the controller object, too.
			Parent root = loader.load();
			// Now we can get the controller object from the FXMLloader.
			// This is interesting -- we don't need to use a cast!
			GameController controller = loader.getController();
			
			// Dependency Injection:
			// Set the Counter object we want the view to update.
			controller.setGuess((PloyGame) game);
			//TODO set a reference to Counter in the controller

			// Build and show the scene
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.setTitle("Guessing Game");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
		// Add an observer that displays the Counter value on console.
		// Dependency Injection: 
		// We set a reference to the counter using the constructor.
		
		//TODO Create a ConsoleView with dependency injection.
		ConsoleView view = new ConsoleView(game);
		//TODO Add ConsoleView as an observer of Counter
		game.addObserver(view);
		
		CounterView view2 = new CounterView(game);
		game.addObserver(view2);
		view2.run();
		
		GuessedView view3 = new GuessedView(game);
		game.addObserver(view3);
		view3.run();

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

