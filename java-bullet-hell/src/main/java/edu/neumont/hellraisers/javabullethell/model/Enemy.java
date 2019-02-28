package edu.neumont.hellraisers.javabullethell.model;

public class Enemy extends Entity{
	
	private EnemyType enemyType;
	
	public Enemy(EnemyType enemyType, Coordinate location) {
		super(enemyType.getHealth(), enemyType.getWidth(), enemyType.getHeight(), location);
		this.enemyType = enemyType;
	}
	
	@Override
	public void onDeath() {
		this.commitDie();
		// TODO
	}
	
	public EnemyType getEnemyType() {
		return enemyType;
	}
}
