package edu.neumont.hellraisers.javabullethell.ui;

import edu.neumont.hellraisers.javabullethell.GameController;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class EndView {
	private Scene view;
	private GameController control;
	@FXML
	private Label playerScore;
	
	public void registerController(GameController gameController) {
		this.control = gameController;
	}
	
	public void setPlayerScore(long toSet) {
		this.playerScore.setText("" + toSet);
	}
	
	@FXML
	public void onMenu() {
		control.onMenu();
	}
	
	@FXML
	public void onQuit() {
		control.onQuit();
	}
	
	public void setView(Scene view) {
		this.view = view;
	}
	
	public Scene getView() {
		return view;
	}
}
