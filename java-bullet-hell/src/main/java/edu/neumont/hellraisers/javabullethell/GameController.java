package edu.neumont.hellraisers.javabullethell;

import java.io.IOException;

import edu.neumont.hellraisers.javabullethell.model.Board;
import edu.neumont.hellraisers.javabullethell.model.Coordinate;
import edu.neumont.hellraisers.javabullethell.model.Enemy;
import edu.neumont.hellraisers.javabullethell.model.EnemyType;
import edu.neumont.hellraisers.javabullethell.model.SceneSelection;
import edu.neumont.hellraisers.javabullethell.ui.MainView;

public class GameController {
	private Board board;
	private MainView mainView;
	private double difficulty = 2.0;
	private double sound = 75.0;
	
	public GameController(MainView view) {
		this.mainView = view;
		this.board = new Board();
		mainView.registerController(this);
		try {
			mainView.init();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mainView.switchScene(SceneSelection.GAME_VIEW);
	}
	
	public void init() {
		mainView.getStage().show();
		mainView.registerController(this);
		mainView.switchScene(SceneSelection.GAME_VIEW);
		createEnemy();
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
	
	public void onApply(double difficulty, double sound) {
		this.difficulty = difficulty;
		this.sound = sound;
		System.out.println(this.difficulty + " " + this.sound);
	}
	
	public void createEnemy() {
		board.getEnemies().add(new Enemy(EnemyType.BIGBOI, new Coordinate(0,0)));
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
  
	public double getDifficulty() {
		return difficulty;
	}
	
	public double getSound(){
		return sound;
	}
}
