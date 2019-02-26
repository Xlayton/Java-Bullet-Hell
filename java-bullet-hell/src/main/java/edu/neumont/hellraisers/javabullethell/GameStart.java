package edu.neumont.hellraisers.javabullethell;

import edu.neumont.hellraisers.javabullethell.ui.MainView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class GameStart extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader().getResource("MainView.fxml"));
		loader.load();
		MainView viewControl = loader.getController();
		viewControl.setStage(arg0);
		
		GameController appControl = new GameController(viewControl);
		appControl.init();
	}
  
	public static void main(String[] args) {
		Application.launch(GameStart.class, args);
	}
}
