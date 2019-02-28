package edu.neumont.hellraisers.javabullethell.model;

public class Coordinate {
	private int X;
	private int Y;
	
	public Coordinate(int X, int Y) {
		this.X = X;
		this.Y = Y;
	}
	
	public void addX(int amt) {
		this.X += amt;
	}
	
	public void addY(int amt) {
		this.Y += amt;
	}
	
	public int getX() {
		return X;
	}
	
	public int getY() {
		return Y;
	}
	
	@Override
	public String toString() {
		return "X: " + X + " Y: " + Y;
	}
}
