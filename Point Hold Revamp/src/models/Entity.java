package models;

import javafx.scene.canvas.GraphicsContext;

/**
 * Any object that occurs within the actual game
 * @author coltm
 *
 */

public abstract class Entity {
	
	protected int x,y;
	
	public abstract void draw(GraphicsContext g);
	public abstract void action();
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
