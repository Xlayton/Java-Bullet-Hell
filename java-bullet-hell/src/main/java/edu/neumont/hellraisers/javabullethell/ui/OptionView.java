package edu.neumont.hellraisers.javabullethell.ui;

import java.io.IOException;

import edu.neumont.hellraisers.javabullethell.GameController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;

public class OptionView {
	
	public OptionView() throws IOException {
		FXMLLoader load = new FXMLLoader(this.getClass().getClassLoader().getResource("OptionView.fxml"));
		Parent parent = load.load();
		
		this.view = new Scene(parent);
	}
	
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
	
	public Scene getView() {
		return view;
	}
}
