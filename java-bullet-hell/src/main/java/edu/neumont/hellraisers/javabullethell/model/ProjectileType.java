package edu.neumont.hellraisers.javabullethell.model;

public enum ProjectileType {
	PLAYER_PROJECTILE(15, 1000, 5, 5), 
	ENEMY_PROJECTILE(15, 1000, 5, 5);
	
	private final int dam; 
	private final int timeout;
	private final int defaultX;
	private final int defaultY;
	
	private ProjectileType(int dam, int timeout, int defaultX, int defaultY) {
		this.dam = dam;
		this.timeout = timeout;
		this.defaultX = defaultX;
		this.defaultY = defaultY;
	}
	
	public int getDamage() {
		return dam;
	}
	
	public int getTimeout() {
		return timeout;
	}
	
	public int getDefaultVelX() {
		return defaultX;
	}
	
	public int getDefaultVelY() {
		return defaultY;
	}
}
