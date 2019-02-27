package edu.neumont.hellraisers.javabullethell.ui;

import java.io.IOException;

import edu.neumont.hellraisers.javabullethell.GameController;
import edu.neumont.hellraisers.javabullethell.model.SceneSelection;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainView {
	private GameController control;
	private Stage stage;
	
	private MainMenuView menuView;
	private GameView gameView;
	private EndView endView;
	private OptionView optionView;
	
	public void init() throws IOException {
		FXMLLoader optionLoad = new FXMLLoader(this.getClass().getClassLoader().getResource("OptionView.fxml"));
		Parent optionParent = optionLoad.load();
		this.optionView = optionLoad.getController();
		optionView.setView(new Scene(optionParent));
		optionView.registerController(control);
	}
	
	public void switchScene(SceneSelection selection){
		switch(selection) {
		case END_VIEW:
			stage.setScene(endView.getView());
			break;
		case GAME_VIEW:
			if (gameView == null) {
				gameView = new GameView();
				gameView.updateController(control);
				gameView.createCanvas(control.getBoard());
			}
			stage.setScene(gameView.getView());
			break;
		case MENU_VIEW:
			stage.setScene(menuView.getView());
			break;
		case OPTION_VIEW:
			stage.setScene(optionView.getView());
			break;
		default:
			break;
		}
	}
	
	public void registerController(GameController control) {
		this.control = control;
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public Stage getStage() {
		return stage;
	}
}
