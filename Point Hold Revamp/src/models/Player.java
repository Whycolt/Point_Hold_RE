package models;

import java.util.ArrayList;

import Point_Hold_RE.Pair;
import controllers.ActionCommands;
import controllers.DrawCommands;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player extends Entity{

	
	private ArrayList<String> movement;
	
	public Player() {
		setPosition(new Pair(0,0));
		setDelta(new Pair(0,0));
		setShoot(new Pair(0,0));
		bulletcd = 20;
		bulletcount = 0;
		size = 60;
		speed = 10;
		movement = new ArrayList<String>();
	}
	
	@Override
	public void draw(GraphicsContext g) {
		DrawCommands.draw(this, g);
	}
	
	@Override
	public void action(GameModel g) {
		ActionCommands.action(this,g);
	}
	
	public void addMove(String action) {
		if (!movement.contains(action)) {
			movement.add(action);
		}
	}
	
	public void removeMove(String action) {
		if (movement.contains(action)) {
			movement.remove(action);
		}
	}
	
	public ArrayList<String> getMovement(){
		return movement;
	}

}
