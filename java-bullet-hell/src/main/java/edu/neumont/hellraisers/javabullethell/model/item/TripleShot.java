package edu.neumont.hellraisers.javabullethell.model.item;

import edu.neumont.hellraisers.javabullethell.model.Coordinate;
import edu.neumont.hellraisers.javabullethell.model.Player;
import javafx.scene.image.Image;

public class TripleShot extends Item{

	public TripleShot(Coordinate coordinate, int size) {
		super(new Image("triple.png"),coordinate, size);
	}

	@Override
	public void onPickup(Player player) {
		if (!player.getTripleShot()) {
			player.toggleTripleShot();
		}
	}

}
