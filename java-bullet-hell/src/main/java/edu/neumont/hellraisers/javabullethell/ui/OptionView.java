package edu.neumont.hellraisers.javabullethell.ui;

import edu.neumont.hellraisers.javabullethell.GameController;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Slider;

public class OptionView {
	
	private Scene view;
	private GameController controller;

	@FXML
	private Slider difficulty;
	
	@FXML
	private Slider sound;
	
	@FXML
	public void onApply() {
		
	}
	
	public void registerController(GameController control) {
		this.controller = control;
	}
}
