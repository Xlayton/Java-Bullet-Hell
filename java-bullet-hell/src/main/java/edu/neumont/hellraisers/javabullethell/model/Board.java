package edu.neumont.hellraisers.javabullethell.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private static final int BOARD_WIDTH = 800;
	private static final int BOARD_HEIGHT = 800;
	
	private Player player;
	private List<Enemy> enemies;
	private List<Projectile> projectiles;
	
	public Board() {
		this.player = new Player(new Coordinate(BOARD_WIDTH/2, BOARD_HEIGHT/2));
		this.enemies = new ArrayList<>();
		this.projectiles = new ArrayList<>();
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
