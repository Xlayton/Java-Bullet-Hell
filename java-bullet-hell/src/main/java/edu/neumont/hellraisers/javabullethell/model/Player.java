package edu.neumont.hellraisers.javabullethell.model;

public class Player extends Entity {
	private static final int baseHealth = 100;
	private static final int baseWidth = 32;
	private static final int baseHeight = 32;
	
	private int speed;
	private long score;
	private boolean tripleShot;
	
	public Player(Coordinate location) {
		super(baseHealth, baseWidth, baseHeight, location);
		this.score = 0L;
		tripleShot = false;
		this.setSpeed(10);
	}
	
	public void toggleTripleShot() {
		tripleShot = !tripleShot;
	}
	
	public boolean getTripleShot() {
		return this.tripleShot;
	}

	
	public void gainHealth(int amt) {
		this.setHealth(this.getHealth() + amt);
	}

	@Override
	public void onDeath() {
		this.commitDie();
		// TODO Animate
	}
	
	public long getScore() {
		return score;
	}
	
	public void addScore(long points) {
		score += points;
	}


	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		if(speed >= 20) {
			speed = 20;
		}
		this.speed = speed;
	}
}
