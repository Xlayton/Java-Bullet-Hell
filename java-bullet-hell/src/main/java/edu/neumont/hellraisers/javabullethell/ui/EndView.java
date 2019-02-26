package edu.neumont.hellraisers.javabullethell.ui;

import edu.neumont.hellraisers.javabullethell.GameController;
import javafx.fxml.FXML;
import javafx.scene.Scene;

public class EndView {
	private Scene view;
	private GameController control;
	
	public void registerGameController(GameController gameController) {
		this.control = gameController;
	}
	
	@FXML
	public void onMenu() {
		control.onMenu();
	}
	
	@FXML
	public void onQuit() {
		control.onQuit();
	}
	
	public Scene getView() {
		return view;
	}
}
