package controllers;

import Point_Hold_RE.Pair;
import Point_Hold_RE.Size;
import models.BulletE;
import models.BulletF;
import models.Entity;
import models.GameModel;
import models.Player;
import models.Standard;

public class ActionMethod {

	public static void col(Entity a, Entity b) {
		Pair CentreA = a.getCenter();
		Pair CentreB = b.getCenter();
		int deltaX = CentreB.getX()-CentreA.getX();
		int deltaY = CentreB.getY()-CentreA.getY();
		int delta = (int)(Math.sqrt(deltaX*deltaX + deltaY*deltaY));
		if (delta < (a.getSize()/2)+(b.getSize()/2)) {
			a.changeHP(b.getDamage());
			b.changeHP(a.getDamage());
		}
	}
	
	public static void shootF(Entity e, GameModel g, int shotDamage) {
		if (e.getBulletcd() < e.getBulletCount()) {
			if (e.getFire()) {
				g.addF(new BulletF(e.getShoot().copy(), new Pair(e.getPosition().getX()+e.getSize()/2-7,e.getPosition().getY()+e.getSize()/2-7),shotDamage));
				e.setBulletCount(0);
			}
		}
		if (e.getBulletCount() < 10000) {
			e.setBulletCount(e.getBulletCount()+1);
		}
		
	}
	
	public static void shootE(Entity e, GameModel g, int ShotDamage) {
		if (e.getBulletcd() < e.getBulletCount()) {
			if (e.getFire()) {
				g.add(new BulletE(e.getShoot().copy(), new Pair(e.getPosition().getX()+e.getSize()/2-7,e.getPosition().getY()+e.getSize()/2-7),ShotDamage));
				e.setBulletCount(0);
			}
		}
		if (e.getBulletCount() < 10000) {
			e.setBulletCount(e.getBulletCount()+1);
		}
		
	}
	
	public static void move(Entity e) {
		double d = Math.sqrt(e.getDelta().getX()*e.getDelta().getX()+e.getDelta().getY()*e.getDelta().getY());
		if (d != 0) {
			e.getPosition().setX(e.getPosition().getX()+(int)(e.getSpeed()*e.getDelta().getX()/d));
			e.getPosition().setY(e.getPosition().getY()+(int)(e.getSpeed()*e.getDelta().getY()/d));
		}
	}
	
	public static void check(BulletF b, GameModel g) {
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
		if (!x || !y || b.getHP() <= 0) {
			g.removeF(b);
		}
	}
	
	public static void check(BulletE b, GameModel g) {
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
		col(b,g.getF().get(0));
		if (!x || !y || b.getHP() <= 0) {
			g.remove(b);
		}
	}
	
	public static void check(Standard b, GameModel g) {
		for (Entity i:g.getF()) {
			col(b,i);
		}
		if (b.getHP() <= 0) {
			g.remove(b);
			return;
		}
	}
	
	public static void borders(Player e) {
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
	
	public static void borders(Standard e) {
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
	
}
