package edu.neumont.hellraisers.javabullethell.model;

public class Enemy extends Entity{
	private EnemyType enemyType;

	@Override
	public void onDeath() {
		// TODO Auto-generated method stub
	}
	
	public EnemyType getEnemyType() {
		return enemyType;
	}
}
