package edu.neumont.hellraisers.javabullethell.model.item;

import edu.neumont.hellraisers.javabullethell.model.Coordinate;
import edu.neumont.hellraisers.javabullethell.model.Player;
import javafx.scene.image.Image;

public class SpeedUp extends Item{

	public SpeedUp(Coordinate location) {
		super(new Image("speedUp.png"), location, 32);
	}

	@Override
	public void onPickup(Player player) {
		player.setSpeed(player.getSpeed() + 2);
		
	}

}
