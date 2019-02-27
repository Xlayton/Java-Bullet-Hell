package edu.neumont.hellraisers.javabullethell.ui;

import edu.neumont.hellraisers.javabullethell.GameController;
import edu.neumont.hellraisers.javabullethell.model.Board;
import edu.neumont.hellraisers.javabullethell.model.Enemy;
import edu.neumont.hellraisers.javabullethell.model.Entity;
import edu.neumont.hellraisers.javabullethell.model.Player;
import edu.neumont.hellraisers.javabullethell.model.Projectile;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class GameView{
	private Scene view;
	private Group group;
	private Canvas canvas;
	private GraphicsContext context;
	private GameController control;
	
	public void createCanvas(Board board) {
		canvas = new Canvas(board.getWidth(),board.getHeight());
		group = new Group(canvas);
		context = canvas.getGraphicsContext2D();
		view = new Scene(group,board.getWidth(),board.getHeight());
		new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				context.clearRect(0, 0, board.getWidth(), board.getHeight());
				updateDisplay(board);
			}
			
		}.start();
	}
	
	public void updateDisplay(Board board) {
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
		Image temp = new Image("playerExample1.png");
		context.drawImage(temp,player.getLocation().getX(),player.getLocation().getY(),100,100);
		player.move(1, 1);
	}
	
	private void drawEnemy(Enemy enemy) {
		Image image;
		switch(enemy.getEnemyType()) {
		case BASIC:
			image = new Image("EnemyExample1.png");
			break;
		case BIGBOI:
			image = new Image("EnemyExample2.png");
			break;
		default:
			image = new Image("projectile.png");
			break;
		}
		context.drawImage(image,enemy.getLocation().getX(),enemy.getLocation().getY(), enemy.getWidth()*10, enemy.getHeight()*10);
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
