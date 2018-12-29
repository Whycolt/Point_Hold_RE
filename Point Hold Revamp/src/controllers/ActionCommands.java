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
		shootF(p, g);
		move(p);
		borders(p);
	}
	
	private static void shootF(Entity e, GameModel g) {
		if (e.getBulletcd() < e.getBulletCount()) {
			if (e.getFire()) {
				g.add(new BulletF(e.getShoot().copy(), new Pair(e.getPosition().getX()+e.getSize()/2-7,e.getPosition().getY()+e.getSize()/2-7)));
				e.setBulletCount(0);
			}
		}
		if (e.getBulletCount() < 10000) {
			e.setBulletCount(e.getBulletCount()+1);
		}
		
	}
	
	private static void shootE(Entity e, GameModel g) {
		if (e.getBulletcd() < e.getBulletCount()) {
			if (e.getFire()) {
				g.add(new BulletE(e.getShoot().copy(), new Pair(e.getPosition().getX()+e.getSize()/2-7,e.getPosition().getY()+e.getSize()/2-7)));
				e.setBulletCount(0);
			}
		}
		if (e.getBulletCount() < 10000) {
			e.setBulletCount(e.getBulletCount()+1);
		}
		
	}
	
	private static void move(Entity e) {
		double d = Math.sqrt(e.getDelta().getX()*e.getDelta().getX()+e.getDelta().getY()*e.getDelta().getY());
		if (d != 0) {
			e.getPosition().setX(e.getPosition().getX()+(int)(e.getSpeed()*e.getDelta().getX()/d));
			e.getPosition().setY(e.getPosition().getY()+(int)(e.getSpeed()*e.getDelta().getY()/d));
		}
	}
	
	private static void check(BulletF b, GameModel g) {
		boolean x = true,y = true;
		if (b.getPosition().getX() < 0) {
			x = false;
		}
		if (b.getPosition().getX() > Size.x-b.getSize()){
			x = false;
		}
		if (b.getPosition().getY() < 0){
			y = false;
		}
		if (b.getPosition().getY() > Size.y-b.getSize()){
			y = false;
		}
		if (!x || !y) {
			g.remove(b);
		}
	}
	
	private static void check(BulletE b, GameModel g) {
		boolean x = true,y = true;
		if (b.getPosition().getX() < 0) {
			x = false;
		}
		if (b.getPosition().getX() > Size.x-b.getSize()){
			x = false;
		}
		if (b.getPosition().getY() < 0){
			y = false;
		}
		if (b.getPosition().getY() > Size.y-b.getSize()){
			y = false;
		}
		if (!x || !y) {
			g.remove(b);
		}
	}
	
	private static void borders(Player e) {
		if (e.getPosition().getX() < 0) {
			e.getPosition().setX(0);
		}
		if (e.getPosition().getX() > Size.x-e.getSize()){
			e.getPosition().setX(Size.x-e.getSize());
		}
		if (e.getPosition().getY() < 0){
			e.getPosition().setY(0);
		}
		if (e.getPosition().getY() > Size.y-e.getSize()){
			e.getPosition().setY(Size.y-e.getSize());
		}
	}
	
	private static void borders(Standard e) {
		if (e.getPosition().getX() < 0) {
			e.setDelta(new Pair(-e.getDelta().getX(),e.getDelta().getY()));
		}
		if (e.getPosition().getX() > Size.x-e.getSize()){
			e.setDelta(new Pair(-e.getDelta().getX(),e.getDelta().getY()));
		}
		if (e.getPosition().getY() < 0){
			e.setDelta(new Pair(e.getDelta().getX(),-e.getDelta().getY()));
		}
		if (e.getPosition().getY() > Size.y-e.getSize()){
			e.setDelta(new Pair(e.getDelta().getX(),-e.getDelta().getY()));
		}
	}

	public static void action(BulletF b, GameModel g) {
		move(b);
		check(b,g);
	}
	
	public static void action(BulletE b, GameModel g) {
		move(b);
		check(b,g);
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

		shootE(s,g);
		move(s);
		borders(s);
	}
	
}
