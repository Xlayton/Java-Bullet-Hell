package edu.neumont.hellraisers.javabullethell;

import java.io.IOException;
import java.util.Random;

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

	public void init() throws InterruptedException {
		mainView.getStage().show();
		mainView.registerController(this);
		mainView.switchScene(SceneSelection.MENU_VIEW);
	}

	public void onPlay() {
		board = new Board();
		mainView.getGameView().createCanvas(board);
		mainView.switchScene(SceneSelection.GAME_VIEW);
		startSpawn();
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
	
	public void onEnd() {
		mainView.switchScene(SceneSelection.END_VIEW);
	}

	public void onApply(double difficulty, double sound) {
		this.difficulty = difficulty;
		this.sound = sound;
		System.out.println(this.difficulty + " " + this.sound);
		mainView.switchScene(SceneSelection.MENU_VIEW);
	}

	public void destroyProjectile(Projectile p) {
		for (int i = 0; i < board.getProjectiles().size(); i++) {
			if (p == board.getProjectiles().get(i)) {
				board.getProjectiles().remove(i);
			}
		}
	}

	public void createEnemy() {
		switch (new Random().nextInt(4) + 1) {
		case 1:
			board.getEnemies().add(new Enemy(EnemyType.BASIC,
					new Coordinate(new Random().nextInt(board.getWidth() + 1), board.getHeight()), difficulty));
			break;
		case 2:
			board.getEnemies().add(new Enemy(EnemyType.BASIC,
					new Coordinate(board.getWidth(), new Random().nextInt(board.getHeight() + 1)), difficulty));
			break;
		case 3:
			board.getEnemies()
					.add(new Enemy(EnemyType.BIGBOI, new Coordinate(new Random().nextInt(board.getWidth()  + 1), -45), difficulty));
			break;
		case 4:
			board.getEnemies()
					.add(new Enemy(EnemyType.BIGBOI, new Coordinate(-45, new Random().nextInt(board.getHeight() + 1)), difficulty));
			break;
		}
	}

	public void startSpawn() {
		Thread enemySpawner = new Thread(new Runnable() {
		    public void run() {
		        while(!board.getPlayer().isDead()) {
		            createEnemy();
		            try {
		                Thread.sleep(500);
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		        }
		    }
		});
		enemySpawner.start();
	}

	public void createPlayer() {

	}

	public void removeEnemy(Enemy enemy) {
		for (int i = 0; i < board.getEnemies().size(); i++) {
			if (enemy == board.getEnemies().get(i)) {
				enemy.onDeath();
				board.getEnemies().remove(i);
			}
		}
	}

	public void removePlayer() {
		mainView.getGameView().giveMeIt().stop();
		mainView.getEndView().setPlayerScore(board.getPlayer().getScore());
		onEnd();
	}

	public Board getBoard() {
		return board;
	}

	public double getDifficulty() {
		return difficulty;
	}

	public double getSound() {
		return sound;
	}

	public void createProjectile(ProjectileType type, int positionX, int positionY, int speedX, int speedY) {
		board.getProjectiles().add(new Projectile(new Coordinate(positionX, positionY), type, speedX, speedY));
	}
}
