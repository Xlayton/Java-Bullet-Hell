
import edu.neumont.hellraisers.javabullethell.GameController;
import edu.neumont.hellraisers.javabullethell.model.Board;
import edu.neumont.hellraisers.javabullethell.model.Enemy;
import edu.neumont.hellraisers.javabullethell.model.Entity;
import edu.neumont.hellraisers.javabullethell.model.Player;
import edu.neumont.hellraisers.javabullethell.model.Projectile;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class GameView extends View{
	private Scene view;
	private Group group;
	private Canvas canvas;
	private GraphicsContext context;
	private GameController control;
	
	public void updateDisplay(Board board) {
		
	}
	
	public void updateController(GameController control) {
		this.control = control;
	}
	
	private void drawPlayer(Player player) {
		
	}
	
	private void drawEnemy(Enemy enemy) {
		
	}
	
	private void drawProjectiles(Projectile[] projectiles) {
		
	}
	
	private void drawScore(Player player) {
		
	}
	
	private void drawHealth(Entity entity) {
		
	}
	
}
