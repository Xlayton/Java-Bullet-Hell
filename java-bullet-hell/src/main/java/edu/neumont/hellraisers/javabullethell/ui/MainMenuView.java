package edu.neumont.hellraisers.javabullethell.ui;

import edu.neumont.hellraisers.javabullethell.GameController;
import javafx.fxml.FXML;
import javafx.scene.Scene;

public class MainMenuView {
	private Scene view;
	private GameController controller;

	public void registerController(GameController control) {
		this.controller = control;
	}

	@FXML
	public void onPlay() {
		controller.onPlay();
	}

	@FXML
	public void onOption() {
		controller.onOption();
	}

	@FXML
	public void onAbout() {

	}

	public Scene getView() {
		return view;
	}
}
