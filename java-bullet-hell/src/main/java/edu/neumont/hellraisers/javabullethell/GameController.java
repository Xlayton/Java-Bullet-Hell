package edu.neumont.hellraisers.javabullethell;

import edu.neumont.hellraisers.javabullethell.model.Board;
import edu.neumont.hellraisers.javabullethell.model.SceneSelection;
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
		mainView.registerController(this);
		mainView.switchScene(SceneSelection.GAME_VIEW);
	}
	
	public void onPlay() {
		mainView.switchScene(SceneSelection.GAME_VIEW);
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
	
	public Board getBoard() {
		return board;
	}
	
}
