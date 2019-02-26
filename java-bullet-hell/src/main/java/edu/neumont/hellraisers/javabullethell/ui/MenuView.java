package edu.neumont.hellraisers.javabullethell.ui;

import edu.neumont.hellraisers.javabullethell.GameController;
import javafx.fxml.FXML;
import javafx.scene.Scene;

public class MenuView {
	private Scene view;
	private GameController controller;
	
	public void registerController(GameController control) {
		this.controller = control;
	}
	
	@FXML
	public void onPlay() {
		
	}
	
	@FXML
	public void onOption() {
		
	}
	
	@FXML
	public void onAbout() {
		
	}
}
