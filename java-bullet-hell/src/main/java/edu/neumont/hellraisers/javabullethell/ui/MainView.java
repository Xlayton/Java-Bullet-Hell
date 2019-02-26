package edu.neumont.hellraisers.javabullethell.ui;

import edu.neumont.hellraisers.javabullethell.GameController;
import edu.neumont.hellraisers.javabullethell.model.SceneSelection;
import javafx.stage.Stage;

public class MainView extends View {
	private GameController control;
	private Stage stage;
	
	private MainMenuView menuView;
	private GameView gameView;
	private GameOverView endView;
	private SettingsView optionView;
	
	public void switchScene(SceneSelection selection){
		switch(selection) {
		case END_VIEW:
			stage.setScene(endView.getView());
			break;
		case GAME_VIEW:
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
}
