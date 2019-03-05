package edu.neumont.hellraisers.javabullethell.ui;

import java.io.IOException;

import edu.neumont.hellraisers.javabullethell.GameController;
import edu.neumont.hellraisers.javabullethell.model.Board;
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
	
	public void init(Board board) throws IOException {
		FXMLLoader optionLoad = new FXMLLoader(this.getClass().getClassLoader().getResource("OptionView.fxml"));
		Parent optionParent = optionLoad.load();
		this.optionView = optionLoad.getController();
		this.optionView.setView(new Scene(optionParent));
		this.optionView.registerController(control);
		FXMLLoader menuLoad = new FXMLLoader(this.getClass().getClassLoader().getResource("MenuView.fxml"));
		Parent menuParent = menuLoad.load();
		this.menuView = menuLoad.getController();
		this.menuView.setView(new Scene(menuParent));
		this.menuView.registerController(control);
		FXMLLoader endLoad = new FXMLLoader(this.getClass().getClassLoader().getResource("EndView.fxml"));
		Parent endParent = endLoad.load();
		this.endView = endLoad.getController();
		this.endView.setView(new Scene(endParent));
		this.endView.registerController(control);
		FXMLLoader gameLoad = new FXMLLoader(this.getClass().getClassLoader().getResource("GameView.fxml"));
		gameLoad.load();
		this.gameView = gameLoad.getController();
		this.gameView.updateController(control);
		this.gameView.createCanvas(board);
		this.stage.setFullScreen(true);
		this.stage.setTitle("Java Bullet Hell");
		this.stage.setResizable(false);
		this.stage.setY(0);
		this.stage.setX(0);
	}
	
	public EndView getEndView() {
		return this.endView;
	}
	
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
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public Stage getStage() {
		return stage;
	}
	
	public GameView getGameView() {
		return gameView;
	}
}
