package edu.neumont.hellraisers.javabullethell.ui;

import edu.neumont.hellraisers.javabullethell.GameController;
import edu.neumont.hellraisers.javabullethell.model.Board;
import edu.neumont.hellraisers.javabullethell.model.Enemy;
import edu.neumont.hellraisers.javabullethell.model.Entity;
import edu.neumont.hellraisers.javabullethell.model.Player;
import edu.neumont.hellraisers.javabullethell.model.Projectile;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class GameView{
	private Scene view;
	private Group group;
	private Canvas canvas;
	private GraphicsContext context;
	private GameController control;
	
	private int moveX = 0;
	private int moveY = 0;
	private boolean[] keyPressed = {false,false,false,false};
	
	private final int speed = 10;
	
	public void createCanvas(Board board) {
		canvas = new Canvas(board.getWidth(),board.getHeight());
		group = new Group(canvas);
		context = canvas.getGraphicsContext2D();
		view = new Scene(group,board.getWidth(),board.getHeight());
		context.getCanvas().setOnMouseMoved(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				System.out.println(":O");
			}
			
		});
		
		view.setOnKeyPressed(key -> {
			if (key.getCode().equals(KeyCode.W)) {
				if (!keyPressed[0]) {
					keyPressed[0] = true;
					moveY -= speed;
				}
			}
			if (key.getCode().equals(KeyCode.A)) {
				if (!keyPressed[1]) {
					keyPressed[1] = true;
					moveX -= speed;
				}
			}
			if (key.getCode().equals(KeyCode.S)) {
				if (!keyPressed[2]) {
					keyPressed[2] = true;
					moveY += speed;
				}
			}
			if (key.getCode().equals(KeyCode.D)) {
				if (!keyPressed[3]) {
					keyPressed[3] = true;
					moveX += speed;
				}
			}
		});
		
		view.setOnKeyReleased(key ->{
			if (key.getCode().equals(KeyCode.W)) {
				keyPressed[0] = false;
				moveY += speed;
			}
			if (key.getCode().equals(KeyCode.A)) {
				keyPressed[1] = false;
				moveX += speed;
			}
			if (key.getCode().equals(KeyCode.S)) {
				keyPressed[2] = false;
				moveY -= speed;
			}
			if (key.getCode().equals(KeyCode.D)) {
				keyPressed[3] = false;
				moveX -= speed;
			}
		});
		new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				context.clearRect(0, 0, board.getWidth(), board.getHeight());
				updateDisplay(board);
			}
			
		}.start();
	}
	
	private void movePlayer() {
		control.getBoard().getPlayer().move(moveX,moveY);
	}
	
	public void updateDisplay(Board board) {
		movePlayer();
		drawPlayer(board.getPlayer());
		for (Enemy enemy : board.getEnemies()) {
			drawEnemy(enemy);
		}
		drawScore(board.getPlayer());
	}
	
	public void updateController(GameController control) {
		this.control = control;
	}
	
	public Scene getView() {
		return view;
	}
	
	private void drawPlayer(Player player) {
		Image temp = new Image("playerx32.png");
		context.drawImage(temp,player.getLocation().getX(),player.getLocation().getY(),64,64);
	}
	
	private void drawEnemy(Enemy enemy) {
		Image image;
		switch(enemy.getEnemyType()) {
		case BASIC:
			image = new Image("basicx32.png");
			break;
		case BIGBOI:
			image = new Image("bigboix32.png");
			break;
		default:
			image = new Image("projectile.png");
			break;
		}
		context.drawImage(image,enemy.getLocation().getX(),enemy.getLocation().getY(), enemy.getWidth(), enemy.getHeight());
	}
	
	private void drawProjectiles(Projectile[] projectiles) {
		Image image = new Image("projectile.png");
		for (Projectile p : projectiles) {
			context.drawImage(image, p.getLocation().getX(), p.getLocation().getY());
		}
	}
	
	private void drawScore(Player player) {
		context.setLineWidth(1.0);
		context.setFill(Color.BLUE);
		context.fillText(String.valueOf(player.getScore()), 50,780);
	}
	
	private void drawHealth(Entity entity) {
		
	}
	
}
