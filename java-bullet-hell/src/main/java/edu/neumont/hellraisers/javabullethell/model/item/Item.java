package edu.neumont.hellraisers.javabullethell.model.item;

import edu.neumont.hellraisers.javabullethell.model.Coordinate;
import edu.neumont.hellraisers.javabullethell.model.Player;
import javafx.scene.image.Image;

public abstract class Item {
	private Image image;
	private Coordinate location;
	private int size;
	
	public Item(Image image, Coordinate location, int size) {
		this.image = image;
		this.location = location;
		this.size = size;
	}
	
	public abstract void onPickup(Player player);
	
	public Image getImage() {
		return image;
	}
	
	public Coordinate getLocation() {
		return location;
	}
	
	public int getSize() {
		return size;
	}
}
