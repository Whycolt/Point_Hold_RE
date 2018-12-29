package models;

import java.util.ArrayList;

import Point_Hold_RE.Pair;
import controllers.ActionCommands;
import controllers.DrawCommands;
import javafx.scene.canvas.GraphicsContext;

public class BulletE extends Entity{

	public BulletE(Pair shoot, Pair x) {
		setPosition(x);
		setDelta(shoot);
		setShoot(new Pair(0,0));
		bulletcd = 0;
		bulletcount = 0;
		size = 15;
		speed = 10;
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
