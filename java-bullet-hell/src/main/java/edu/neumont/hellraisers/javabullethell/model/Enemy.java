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
			if(this.getLocation().getX() >= 800) {
				moveLeft = true;
			} else if (this.getLocation().getX() <= 0) {
				moveLeft = false;
			}
			if(this.getLocation().getY() >= 800) {
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
				modelImage = (this.enemyType == EnemyType.BASIC) ? new Image("basicx32-back.png") : new Image("bigboix32-back.png");
			} else if (moveUp && !moveLeft) {
				this.getLocation().addX(2);
				this.getLocation().addY(-2);
				modelImage = (this.enemyType == EnemyType.BASIC) ? new Image("basicx32-back.png") : new Image("bigboix32-back.png");
			} else if (!moveUp && moveLeft) {
				this.getLocation().addX(-2);
				this.getLocation().addY(2);
				modelImage = (this.enemyType == EnemyType.BASIC) ? new Image("basicx32.png") : new Image("bigboix32.png");
			} else {
				this.getLocation().addX(2);
				this.getLocation().addY(2);
				modelImage = (this.enemyType == EnemyType.BASIC) ? new Image("basicx32-right.png") : new Image("bigboix32-right.png");
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
