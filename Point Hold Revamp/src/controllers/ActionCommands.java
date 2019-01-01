package controllers;

import Point_Hold_RE.Pair;
import Point_Hold_RE.Size;
import models.BulletE;
import models.BulletF;
import models.Entity;
import models.GameModel;
import models.Player;
import models.Standard;

public class ActionCommands {
	
	public static void action(Player p, GameModel g) {
		boolean x = true, y = true, fireX = true, fireY = true;
		p.getDelta().setX(0);
		p.getDelta().setY(0);
		p.getShoot().setX(0);
		p.getShoot().setY(0);

		for (String s:p.getMovement()) {
			if (x && s.compareTo("A")==0) {
				p.getDelta().setX(-1);
				x = false;
			}
			if (x && s.compareTo("D")==0) {
				p.getDelta().setX(1);
				x = false;
			}
			if (y && s.compareTo("W")==0) {
				p.getDelta().setY(-1);
				y = false;
			}
			if (y && s.compareTo("S")==0) {
				p.getDelta().setY(1);
				y = false;
			}
			if (x && s.compareTo("Left")==0) {
				p.getShoot().setX(-1);
				fireX = false;
			}
			if (x && s.compareTo("Right")==0) {
				p.getShoot().setX(1);
				fireX = false;
			}
			if (y && s.compareTo("Up")==0) {
				p.getShoot().setY(-1);
				fireY = false;
			}
			if (y && s.compareTo("Down")==0) {
				p.getShoot().setY(1);
				fireY = false;
			}
		}
		p.setFire(!fireX || !fireY);
		ActionMethod.shootF(p, g,p.getShotDamage());
		ActionMethod.move(p);
		ActionMethod.borders(p);
		if (p.getHP() < 0) {
			g.end();
		}
	}
	
	public static void action(BulletF b, GameModel g) {
		ActionMethod.move(b);
		ActionMethod.check(b,g);
	}
	
	public static void action(BulletE b, GameModel g) {
		ActionMethod.move(b);
		ActionMethod.check(b,g);
	}

	public static void action(Standard s, GameModel g) {
		if (s.getPosition().getX() < g.getPlayer().getPosition().getX()) {
			s.getShoot().setX(Math.abs(s.getShoot().getX()));
		}
		if (s.getPosition().getX() > g.getPlayer().getPosition().getX()) {
			s.getShoot().setX(-Math.abs(s.getShoot().getX()));
		}
		if (s.getPosition().getY() < g.getPlayer().getPosition().getY()) {
			s.getShoot().setY(Math.abs(s.getShoot().getY()));
		}
		if (s.getPosition().getY() > g.getPlayer().getPosition().getY()) {
			s.getShoot().setY(-Math.abs(s.getShoot().getY()));
		}
		ActionMethod.shootE(s,g,s.getShotDamage());
		ActionMethod.move(s);
		ActionMethod.borders(s);
		ActionMethod.check(s,g);
	}
	
}
