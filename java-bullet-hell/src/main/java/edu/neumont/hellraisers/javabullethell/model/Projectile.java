package edu.neumont.hellraisers.javabullethell.model;

public class Projectile {
	private Coordinate location;
	private int velocityX;
	private int velocityY;
	private int timeOut;
	private ProjectileType projectileType;
	private int damage;
	
	public Projectile(Coordinate location, ProjectileType projectileType, int velocityX, int velocityY) {
		this.location = location;
		this.projectileType = projectileType;
		this.timeOut = projectileType.getTimeout();
		this.damage = projectileType.getDamage();
		this.velocityX = velocityX;
		this.velocityY = velocityY;
	}
	
	public void move() {
		this.location.addX(velocityX);
		this.location.addY(velocityY);
	}

	public Coordinate getLocation() {
		return location;
	}

	public void setLocation(Coordinate location) {
		this.location = location;
	}

	public int getVelocityX() {
		return velocityX;
	}

	public void setVelocityX(int velocityX) {
		this.velocityX = velocityX;
	}

	public int getVelocityY() {
		return velocityY;
	}

	public void setVelocityY(int velocityY) {
		this.velocityY = velocityY;
	}

	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

	public ProjectileType getProjectileType() {
		return projectileType;
	}

	public void setProjectileType(ProjectileType projectileType) {
		this.projectileType = projectileType;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
}
