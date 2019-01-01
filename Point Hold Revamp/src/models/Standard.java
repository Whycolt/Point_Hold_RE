package models;

import Point_Hold_RE.Pair;
import controllers.ActionCommands;
import controllers.DrawCommands;
import javafx.scene.canvas.GraphicsContext;

public class Standard extends Enemy{
	
	public Standard(Pair start, Pair movement) {
		super(start, movement, 30);
		shotDamage = 10;
		bulletcd = 60;
		bulletcount = 0;
		speed = 4;
		setFire(true);
		shoot = new Pair(movement.getY(),movement.getX());
		damage = 10;
	}

	@Override
	public void draw(GraphicsContext g) {
		DrawCommands.draw(this, g);
	}
	
	@Override
	public void action(GameModel g) {
		ActionCommands.action(this,g);
	}

	
	
}
