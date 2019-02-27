package edu.neumont.hellraisers.javabullethell.ui;

import edu.neumont.hellraisers.javabullethell.GameController;
import edu.neumont.hellraisers.javabullethell.model.Board;
import edu.neumont.hellraisers.javabullethell.model.Enemy;
import edu.neumont.hellraisers.javabullethell.model.Entity;
import edu.neumont.hellraisers.javabullethell.model.Player;
import edu.neumont.hellraisers.javabullethell.model.Projectile;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameView{
	private Scene view;
	private Group group;
	private Canvas canvas;
	private GraphicsContext context;
	private GameController control;
	
	public void createCanvas(Board board) {
		group = new Group();
		canvas = new Canvas(board.getWidth(),board.getHeight());
		context = canvas.getGraphicsContext2D();
		view = new Scene(group,board.getWidth(),board.getHeight());
	}
	
	public void updateDisplay(Board board) {
		drawPlayer(board.getPlayer());
	}
	
	public void updateController(GameController control) {
		this.control = control;
	}
	
	public Scene getView() {
		return view;
	}
	
	private void drawPlayer(Player player) {
		Image temp = new Image("PlayerExample1.png");
		context.drawImage(temp,player.getLocation().getX(),player.getLocation().getY());
	}
	
	private void drawEnemy(Enemy enemy) {
		
	}
	
	private void drawProjectiles(Projectile[] projectiles) {
		
	}
	
	private void drawScore(Player player) {
		
	}
	
	private void drawHealth(Entity entity) {
		
	}
	
}
