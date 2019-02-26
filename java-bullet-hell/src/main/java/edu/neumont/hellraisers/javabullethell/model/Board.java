package edu.neumont.hellraisers.javabullethell.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private Player player;
	private List<Enemy> enemies;
	private List<Projectile> projectiles;
	
	public Board() {
		this.player = new Player();
		this.enemies = new ArrayList<>();
		this.projectiles = new ArrayList<>();
	}
}
