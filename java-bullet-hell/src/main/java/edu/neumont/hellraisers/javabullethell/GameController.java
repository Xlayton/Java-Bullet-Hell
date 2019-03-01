package edu.neumont.hellraisers.javabullethell;

import java.io.IOException;

import edu.neumont.hellraisers.javabullethell.model.Board;
import edu.neumont.hellraisers.javabullethell.model.Coordinate;
import edu.neumont.hellraisers.javabullethell.model.Enemy;
import edu.neumont.hellraisers.javabullethell.model.EnemyType;
import edu.neumont.hellraisers.javabullethell.model.Projectile;
import edu.neumont.hellraisers.javabullethell.model.ProjectileType;
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
			mainView.init(board);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void init() {
		mainView.getStage().show();
		mainView.registerController(this);
		mainView.switchScene(SceneSelection.MENU_VIEW);
	}
	
	public void onPlay() {
		mainView.switchScene(SceneSelection.GAME_VIEW);
	}
	
	public void onOption() {
		mainView.switchScene(SceneSelection.OPTION_VIEW);
	}
	
	public void onMenu() {
		mainView.switchScene(SceneSelection.MENU_VIEW);
	}
	
	public void onQuit() {
		mainView.getStage().close();
	}
	
	public void onApply(double difficulty, double sound) {
		this.difficulty = difficulty;
		this.sound = sound;
		System.out.println(this.difficulty + " " + this.sound);
		mainView.switchScene(SceneSelection.MENU_VIEW);
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
	
	public void createProjectile(ProjectileType type, int positionX, int positionY, int speedX, int speedY) {
		board.getProjectiles().add(new Projectile(new Coordinate(positionX,positionY),type,speedX,speedY));
	}
}
