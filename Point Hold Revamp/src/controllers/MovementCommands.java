package controllers;

import models.Entity;
import models.Player;

public class MovementCommands {
	
	public static void action(Player p) {
		int d;
		if (p.getDeltaX() != 0 && p.getDeltaY() != 0) {
			d = (int)(p.getSpeed()*0.7);
		}
		else {
			d = p.getSpeed();
		}
		p.addX(d*p.getDeltaX()/p.getSpeed());
		p.addY(d*p.getDeltaY()/p.getSpeed());
		borders(p);
	}
	
	public static void borders(Entity e) {
		if (e.getX() < 0) {
			e.setX(0);
		}
		if (e.getX() > 740){
			e.setX(740);
		}
		if (e.getY() < 0){
			e.setY(0);
		}
		if (e.getY() > 540){
			e.setY(540);
		}
	}
	
}
