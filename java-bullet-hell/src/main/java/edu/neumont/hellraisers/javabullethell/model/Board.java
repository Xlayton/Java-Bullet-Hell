package edu.neumont.hellraisers.javabullethell.model;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Board {
	private static final int BOARD_WIDTH = 800;
	private static final int BOARD_HEIGHT = 800;
	
	private Player player;
	private List<Enemy> enemies;
	private List<Projectile> projectiles;
	private Timeline update;
	
	public Board() {
		this.player = new Player(new Coordinate(BOARD_WIDTH/2, BOARD_HEIGHT/2));
		this.enemies = new ArrayList<>();
		this.projectiles = new ArrayList<>();
		update = new Timeline(new KeyFrame(Duration.millis(1), e -> {
			for(Enemy en : enemies) {
				for(int i = 0; i < en.getShots(); i++) {
					this.projectiles.add(new Projectile(new Coordinate(en.getLocation().getX(), en.getLocation().getY()), ProjectileType.ENEMY_PROJECTILE, ProjectileType.ENEMY_PROJECTILE.getDefaultVelX(),  ProjectileType.ENEMY_PROJECTILE.getDefaultVelY()));
					en.setShots(en.getShots()-1);
				}
			}
		}));
		update.setCycleCount(Animation.INDEFINITE);
		update.play();
	}
	
	public List<Enemy> getEnemies() {
		return enemies;
	}
	
	public List<Projectile> getProjectiles(){
		return projectiles;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public int getWidth() {
		return BOARD_WIDTH;
	}
	
	public int getHeight() {
		return BOARD_HEIGHT;
	}
}
