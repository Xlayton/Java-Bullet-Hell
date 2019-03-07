package edu.neumont.hellraisers.javabullethell.model;

import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class Enemy extends Entity{
	
	private EnemyType enemyType;
	private Timeline shootTimer;
	private Timeline moveTimer;
	Image modelImage;
	private int numShotsToShoot;
	boolean moveUp = false;
	boolean moveLeft = false;
	
	public Enemy(EnemyType enemyType, Coordinate location, double difficulty) {
		super(enemyType.getHealth(), enemyType.getWidth(), enemyType.getHeight(), location);
		this.enemyType = enemyType;
		this.numShotsToShoot = 0;
		this.shootTimer = new Timeline(new KeyFrame(Duration.millis(3200/difficulty), e -> {
			numShotsToShoot++;
		}));
		shootTimer.setCycleCount(Animation.INDEFINITE);
		shootTimer.play();
		this.moveTimer = new Timeline(new KeyFrame(Duration.millis(25), e -> {
			if(this.getLocation().getX() >= 1920) {
				moveLeft = true;
			} else if (this.getLocation().getX() <= 0) {
				moveLeft = false;
			}
			if(this.getLocation().getY() >= 1080) {
				moveUp = true;
			} else if (this.getLocation().getY() <= 0) {
				moveUp = false;
			}
			
			if(new Random().nextInt(100) + 1 == 1) {
				moveUp = !moveUp;
				moveLeft = ! moveLeft;
			}
			
			if(moveUp && moveLeft) {
				this.getLocation().addX(-2);
				this.getLocation().addY(-2);
			} else if (moveUp && !moveLeft) {
				this.getLocation().addX(2);
				this.getLocation().addY(-2);
			} else if (!moveUp && moveLeft) {
				this.getLocation().addX(-2);
				this.getLocation().addY(2);
			} else {
				this.getLocation().addX(2);
				this.getLocation().addY(2);
			}
		}));
		moveTimer.setCycleCount(Animation.INDEFINITE);
		moveTimer.play();
	}
	
	@Override
	public void onDeath() {
		this.commitDie();
		// TODO Animate
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
	
	public Image getImage() {
		return modelImage;
	}
}
