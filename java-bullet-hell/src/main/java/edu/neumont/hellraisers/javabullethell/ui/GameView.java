package edu.neumont.hellraisers.javabullethell.ui;

import java.io.File;

import edu.neumont.hellraisers.javabullethell.GameController;
import edu.neumont.hellraisers.javabullethell.model.Board;
import edu.neumont.hellraisers.javabullethell.model.Enemy;
import edu.neumont.hellraisers.javabullethell.model.Entity;
import edu.neumont.hellraisers.javabullethell.model.FireEventListener;
import edu.neumont.hellraisers.javabullethell.model.Player;
import edu.neumont.hellraisers.javabullethell.model.Projectile;
import edu.neumont.hellraisers.javabullethell.model.ProjectileType;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;

public class GameView implements FireEventListener {
	private Scene view;
	private Group group;
	private Canvas canvas;
	private GraphicsContext context;
	private GameController control;
	private int moveX = 0;
	private int moveY = 0;
	private AudioClip sound = new AudioClip(new File("./src/main/resources/moistShot.mp3").toURI().toString());
	private boolean[] keyPressed = { false, false, false, false };
	private boolean[] attackPressed = { false, false, false, false };
	private int attackCooldown = 0;
	private boolean attacking = false;
	private String playerImage = "playerx32.png";

	private final int speed = 10;
	private final int playerBulletSpeed = 5;

	public void createCanvas(Board board) {
		board.registerListener(this);
		canvas = new Canvas(board.getWidth(), board.getHeight());
		group = new Group(canvas);
		context = canvas.getGraphicsContext2D();
		view = new Scene(group, board.getWidth(), board.getHeight());

		view.setOnKeyPressed(key -> {
			if (key.getCode().equals(KeyCode.W)) {
				if (!keyPressed[0]) {
					playerImage = "playerx32-back.png";
					keyPressed[0] = true;
					moveY -= speed;
				}
			}
			if (key.getCode().equals(KeyCode.A)) {
				if (!keyPressed[1]) {
					keyPressed[1] = true;
					moveX -= speed;
				}
			}
			if (key.getCode().equals(KeyCode.S)) {
				if (!keyPressed[2]) {
					keyPressed[2] = true;
					moveY += speed;
				}
			}
			if (key.getCode().equals(KeyCode.D)) {
				if (!keyPressed[3]) {
					keyPressed[3] = true;
					moveX += speed;
				}
			}
			if (key.getCode().equals(KeyCode.UP) && !attacking) {
				if (!attackPressed[0]) {
					attacking = true;
					attackPressed[0] = true;
				}
			}
			if (key.getCode().equals(KeyCode.LEFT) && !attacking) {
				attacking = true;
				if (!attackPressed[1]) {
					attackPressed[1] = true;
				}
			}
			if (key.getCode().equals(KeyCode.DOWN) && !attacking) {
				attacking = true;
				if (!attackPressed[2]) {
					attackPressed[2] = true;
				}
			}
			if (key.getCode().equals(KeyCode.RIGHT) && !attacking) {
				attacking = true;
				if (!attackPressed[3]) {
					attackPressed[3] = true;
				}
			}
		});

		view.setOnKeyReleased(key -> {
			if (key.getCode().equals(KeyCode.W)) {
				keyPressed[0] = false;
				moveY += speed;
			}
			if (key.getCode().equals(KeyCode.A)) {
				keyPressed[1] = false;
				moveX += speed;
			}
			if (key.getCode().equals(KeyCode.S)) {
				keyPressed[2] = false;
				moveY -= speed;
			}
			if (key.getCode().equals(KeyCode.D)) {
				keyPressed[3] = false;
				moveX -= speed;
			}
			if (key.getCode().equals(KeyCode.UP)) {
				if (attackPressed[0] && attacking) {
					attackPressed[0] = false;
					attacking = false;
				}
			}
			if (key.getCode().equals(KeyCode.LEFT)) {
				if (attackPressed[1] && attacking) {
					attackPressed[1] = false;
					attacking = false;
				}
			}
			if (key.getCode().equals(KeyCode.DOWN) && attacking) {
				if (attackPressed[2]) {
					attackPressed[2] = false;
					attacking = false;
				}
			}
			if (key.getCode().equals(KeyCode.RIGHT) && attacking) {
				if (attackPressed[3]) {
					attackPressed[3] = false;
					attacking = false;
				}
			}

		});
		new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				context.clearRect(0, 0, board.getWidth(), board.getHeight());
				updateDisplay(board);
			}

		}.start();
	}

	private void movePlayer() {
		control.getBoard().getPlayer().move(moveX, moveY);
		int x = control.getBoard().getPlayer().getLocation().getX() + 40;
		int y = control.getBoard().getPlayer().getLocation().getY() + 40;
		if (x + 1 > control.getBoard().getWidth()) {
			control.getBoard().getPlayer().move(-1 * moveX, 0);
		} else if (x - 20 < 0) {
			control.getBoard().getPlayer().move(-1 * moveX, 0);
		}
		if (y - 30 < 0) {
			control.getBoard().getPlayer().move(0, -1 * moveY);
		} else if (y + 20 > control.getBoard().getHeight()) {
			control.getBoard().getPlayer().move(0, -1 * moveY);
		}
	}

	private void arrowsPressed(Board board) {
		int offsetX = 20;
		int offsetY = 20;
		if (attackCooldown > 5) {
			attackCooldown = 0;
			if (attackPressed[0]) {
				control.createProjectile(ProjectileType.PLAYER_PROJECTILE,
						board.getPlayer().getLocation().getX() + offsetX,
						board.getPlayer().getLocation().getY() + offsetY, 0, -playerBulletSpeed);
			}
			if (attackPressed[1]) {
				control.createProjectile(ProjectileType.PLAYER_PROJECTILE,
						board.getPlayer().getLocation().getX() + offsetX,
						board.getPlayer().getLocation().getY() + offsetY, -playerBulletSpeed, 0);
			}
			if (attackPressed[2]) {
				control.createProjectile(ProjectileType.PLAYER_PROJECTILE,
						board.getPlayer().getLocation().getX() + offsetX,
						board.getPlayer().getLocation().getY() + offsetY, 0, playerBulletSpeed);
			}
			if (attackPressed[3]) {
				control.createProjectile(ProjectileType.PLAYER_PROJECTILE,
						board.getPlayer().getLocation().getX() + offsetX,
						board.getPlayer().getLocation().getY() + offsetY, playerBulletSpeed, 0);
			}
		}
	}

	public void updateDisplay(Board board) {
		attackCooldown++;
		movePlayer();
		arrowsPressed(board);
		drawPlayer(board.getPlayer());
		for (Enemy enemy : board.getEnemies()) {
			drawEnemy(enemy);
		}
		Projectile[] temp = new Projectile[board.getProjectiles().size()];
		temp = board.getProjectiles().toArray(temp);
		drawProjectiles(temp);
		drawScore(board.getPlayer());
	}

	public void updateController(GameController control) {
		this.control = control;
	}

	public Scene getView() {
		return view;
	}

	private void drawPlayer(Player player) {
		Image temp = new Image(playerImage);
		context.drawImage(temp, player.getLocation().getX(), player.getLocation().getY(), 64, 64);
		drawHealth(player);
	}

	private void drawEnemy(Enemy enemy) {
		Image image;
		switch (enemy.getEnemyType()) {
		case BASIC:
			image = new Image("basicx32.png");
			break;
		case BIGBOI:
			image = new Image("bigboix32.png");
			break;
		default:
			image = new Image("projectile.png");
			break;
		}
		drawHealth(enemy);
		context.drawImage(image, enemy.getLocation().getX(), enemy.getLocation().getY(), enemy.getWidth(),
				enemy.getHeight());
	}

	private void drawProjectiles(Projectile[] projectiles) {
		Image image = new Image("projectile.png");
		Image playerProj = new Image("playerProjectile.png");
		for (int index = 0; index < projectiles.length; index++) {
			Projectile p = projectiles[index];
			p.move();
			if (p.getProjectileType() == ProjectileType.ENEMY_PROJECTILE) {
				context.drawImage(image, p.getLocation().getX(), p.getLocation().getY());
			} else {
				context.drawImage(playerProj, p.getLocation().getX(), p.getLocation().getY());
			}
			if (projectileCollision(p)) {
				control.destroyProjectile(p);
			}
		}
	}

	private boolean projectileCollision(Projectile p) {
		int pX = p.getLocation().getX()+2;
		int pY = p.getLocation().getY()+2;
		if (p.getProjectileType() == ProjectileType.PLAYER_PROJECTILE) {
			for (Enemy enemy : control.getBoard().getEnemies()) {
				int x = enemy.getLocation().getX() + enemy.getWidth() / 2;
				int y = enemy.getLocation().getY() + enemy.getHeight() / 2;
				if (pX > x - enemy.getWidth() / 2) {
					if (pX < x + enemy.getWidth() / 2) {
						if (pY > y - enemy.getHeight() / 2) {
							if (pY < y + enemy.getHeight() / 2) {
								enemy.takeDamage(p.getDamage());
								if (enemy.getHealth() <= 0) {
									control.removeEnemy(enemy);
									control.getBoard().getPlayer().addScore(100L);
								}
								return true;
							}
						}
					}
				}
			}
		} else {
			int x = control.getBoard().getPlayer().getLocation().getX();
			int y = control.getBoard().getPlayer().getLocation().getY();
			Player player = control.getBoard().getPlayer();
			x+=player.getWidth();
			y+=player.getHeight();
			if (pX > x - player.getWidth() + 5) {
				if (pX < x + player.getWidth()-5) {
					if (pY > y - player.getHeight()+5) {
						if (pY < y + player.getHeight()-5){
							player.takeDamage(p.getDamage());
							control.destroyProjectile(p);
							if (player.getHealth() <= 0) {
								player.onDeath();
							}
						}
					}
				}
			}
		}
		return false;
	}

	private void drawScore(Player player) {
		context.setLineWidth(1.0);
		context.setFill(Color.BLUE);
		context.fillText(String.valueOf(player.getScore()), 50, 1000);
	}

	private void drawHealth(Entity entity) {
		context.strokeRect(entity.getLocation().getX() - 15, entity.getLocation().getY() - 5, 30, 10);
		context.setFill(Color.FIREBRICK);
		context.fillRect(entity.getLocation().getX() - 14, entity.getLocation().getY() - 4,
				28 * (entity.getHealth() / (entity.getMaxHealth() * 1D)), 8);
	}

	@Override
	public void projectileFired() {
		sound.play();
	}
}
