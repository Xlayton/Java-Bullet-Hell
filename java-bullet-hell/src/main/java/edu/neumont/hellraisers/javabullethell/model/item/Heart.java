package edu.neumont.hellraisers.javabullethell.model.item;

import edu.neumont.hellraisers.javabullethell.model.Coordinate;
import edu.neumont.hellraisers.javabullethell.model.Player;
import javafx.scene.image.Image;

public class Heart extends Item {
	private int amtHealed;

	public Heart(Coordinate location, int size, int amtHealed) {
		super(new Image("heart.png"), location, size);
		this.amtHealed = amtHealed;
	}

	@Override
	public void onPickup(Player player) {
		player.gainHealth(amtHealed);
	}
}
