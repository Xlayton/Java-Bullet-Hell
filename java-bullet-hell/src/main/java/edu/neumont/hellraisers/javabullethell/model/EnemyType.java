package edu.neumont.hellraisers.javabullethell.model;

public enum EnemyType {
	BASIC(25, 32, 32),
	BIGBOI(500,40,40);
	
	
	private final int health;
	private final int width;
	private final int height;
	
	private EnemyType(int health, int width, int height) {
		this.health = health;
		this.width = width;
		this.height = height;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
