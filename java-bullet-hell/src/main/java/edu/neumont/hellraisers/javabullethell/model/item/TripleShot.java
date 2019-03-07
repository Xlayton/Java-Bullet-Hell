package edu.neumont.hellraisers.javabullethell.model.item;

import edu.neumont.hellraisers.javabullethell.model.Coordinate;
import edu.neumont.hellraisers.javabullethell.model.Player;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class TripleShot extends Item{

	public TripleShot(Coordinate coordinate, int size) {
		super(new Image("triple.png"),coordinate, size);
	}

	@Override
	public void onPickup(Player player) {
		if (!player.getTripleShot()) {
			player.toggleTripleShot();
			new Timeline(new KeyFrame(Duration.millis(10500), e ->{
				player.toggleTripleShot();
			})).play();
		}
	}

}
