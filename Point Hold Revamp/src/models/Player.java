package models;

import controllers.DrawCommands;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player extends Entity{

	
	
	@Override
	public void draw(GraphicsContext g) {
		DrawCommands.draw(this, g);
	}
	
	public void changeX(int x) {
		this.x += x;
	}
	
	public void changeY(int y) {
		this.y += y;
	}
	
	@Override
	public void action() {
		// TODO Auto-generated method stub	
	}

}
