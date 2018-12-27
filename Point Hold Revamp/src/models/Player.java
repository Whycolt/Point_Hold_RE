package models;

import controllers.DrawCommands;
import controllers.MovementCommands;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player extends Entity{


	public Player() {
		speed = 10;
	}
	
	@Override
	public void draw(GraphicsContext g) {
		DrawCommands.draw(this, g);
	}
	
	@Override
	public void action() {
		MovementCommands.action(this);
	}

}
