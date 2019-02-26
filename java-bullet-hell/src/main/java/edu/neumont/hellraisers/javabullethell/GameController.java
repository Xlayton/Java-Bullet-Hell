package edu.neumont.hellraisers.javabullethell;

import edu.neumont.hellraisers.javabullethell.model.Board;
import edu.neumont.hellraisers.javabullethell.ui.MainView;

public class GameController {
	private Board board;
	private MainView mainView;
	
	public GameController(MainView view) {
		this.mainView = view;
		this.board = new Board();
	}
	
	public void init() {
		mainView.getStage().show();
	}
	
	public void onPlay() {
		
	}
	
	public void onOption() {
		
	}
	
	public void onMenu() {
		
	}
	
	public void onQuit() {
		
	}
	
	public void createEnemy() {
		
	}
	
	public void createPlayer() {
		
	}
	
	public void removeEnemy() {
		
	}
	
	public void removePlayer() {
		
	}
	
}
