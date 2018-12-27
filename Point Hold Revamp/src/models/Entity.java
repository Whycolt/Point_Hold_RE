package models;

import javafx.scene.canvas.GraphicsContext;

/**
 * Any object that occurs within the actual game
 * @author coltm
 *
 */

public abstract class Entity {
	
	protected int x,y,deltaX, deltaY, speed;
	
	public abstract void draw(GraphicsContext g);
	public abstract void action();
	
	public int getSpeed() {
		return speed;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getDeltaX() {
		return deltaX;
	}
	
	public int getDeltaY() {
		return deltaY;
	}
	
	public void changeX(int x) {
		this.deltaX = x;
	}
	
	public void changeY(int y) {
		this.deltaY = y;
	}
	
	public void addX(int x) {
		this.x += x;
	}
	public void addY(int y) {
		this.y += y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}
