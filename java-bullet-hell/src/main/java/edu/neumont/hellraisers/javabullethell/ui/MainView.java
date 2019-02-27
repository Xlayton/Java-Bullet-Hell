package edu.neumont.hellraisers.javabullethell.ui;

import edu.neumont.hellraisers.javabullethell.GameController;
import edu.neumont.hellraisers.javabullethell.model.SceneSelection;
import javafx.stage.Stage;

public class MainView {
	private GameController control;
	private Stage stage;
	
	private MainMenuView menuView;
	private GameView gameView;
	private EndView endView;
	private OptionView optionView;
	
	public void switchScene(SceneSelection selection){
		switch(selection) {
		case END_VIEW:
			stage.setScene(endView.getView());
			break;
		case GAME_VIEW:
			if (gameView == null) {
				gameView = new GameView();
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
