package edu.neumont.hellraisers.javabullethell.model;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Enemy extends Entity{
	
	private EnemyType enemyType;
	private Timeline shootTimer;
	private int numShotsToShoot;
	
	public Enemy(EnemyType enemyType, Coordinate location, double difficulty) {
		super(enemyType.getHealth(), enemyType.getWidth(), enemyType.getHeight(), location);
		this.enemyType = enemyType;
		this.numShotsToShoot = 0;
		shootTimer = new Timeline(new KeyFrame(Duration.millis(600/difficulty), e -> {
			numShotsToShoot++;
		}));
		shootTimer.setCycleCount(Animation.INDEFINITE);
		shootTimer.play();
	}
	
	@Override
	public void onDeath() {
		this.commitDie();
		// TODO
	}
	
	public EnemyType getEnemyType() {
		return enemyType;
	}

	public int getShots() {
		return this.numShotsToShoot;
	}	
	
	public void setShots(int toSet) {
		this.numShotsToShoot = toSet;
	}
}
