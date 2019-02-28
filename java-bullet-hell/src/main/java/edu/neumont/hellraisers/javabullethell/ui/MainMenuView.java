package edu.neumont.hellraisers.javabullethell.ui;

import edu.neumont.hellraisers.javabullethell.GameController;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

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
		new Alert(AlertType.INFORMATION, "Made by Clayton Schrumpf and Oscar Cabrera-Luna\nVersion:1.0.0", ButtonType.OK).show();
	}

	public Scene getView() {
		return view;
	}

	public void setView(Scene scene) {
		this.view = scene;
	}
}
