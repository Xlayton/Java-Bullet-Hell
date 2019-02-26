package edu.neumont.hellraisers.javabullethell.model;

public abstract class Entity {
	private int health;
	private Coordinate location;
	private int width;
	private int height;
	private boolean isDead;
	
	public Entity(int health, int width, int height, Coordinate location) {
		
	}

	public void shoot(Direction direction) {
		//TODO
	}
	
	public void takeDamage(int amt) {
		//TODO
	}
	
	public void move(int amtX, int amtY) {
		//TODO
	}
	
	public abstract void onDeath();
	
	public int getHealth() {
		return health;
	}
	
	public Coordinate getLocation() {
		return location;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public boolean isDead() {
		return isDead;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
}
