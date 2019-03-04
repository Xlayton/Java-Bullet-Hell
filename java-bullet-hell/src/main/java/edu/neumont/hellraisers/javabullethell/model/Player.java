package edu.neumont.hellraisers.javabullethell.model;

public class Player extends Entity {
	private static final int baseHealth = 100;
	private static final int baseWidth = 15;
	private static final int baseHeight = 15;
	
	private long score;
	
	public Player(Coordinate location) {
		super(baseHealth, baseWidth, baseHeight, location);
		this.score = 0L;
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
}
