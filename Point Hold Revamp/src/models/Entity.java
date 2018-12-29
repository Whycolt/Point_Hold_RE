package models;

import Point_Hold_RE.Pair;
import javafx.scene.canvas.GraphicsContext;

/**
 * Any object that occurs within the actual game
 * @author coltm
 *
 */

public abstract class Entity {
	
	protected Pair position, delta, shoot;
	protected int speed, size, bulletcd, bulletcount, hp;
	protected boolean fire;
	
	public abstract void draw(GraphicsContext g);
	public abstract void action(GameModel g);
	
	public int getBulletcd() {
		return bulletcd;
	}
	
	public void setBulletcd(int n) {
		bulletcd = n;
	}
	
	public int getBulletCount() {
		return bulletcount;
	}
	
	public void setBulletCount(int n) {
		bulletcount = n;
	}
	
	public void setFire(boolean fire) {
		this.fire = fire;
	}
	
	public boolean getFire() {
		return fire;
	}
	
	public Pair getShoot() {
		return shoot;
	}

	public void setShoot(Pair shoot) {
		this.shoot = shoot;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed; 
	}
	
	public Pair getPosition() {
		return position;
	}
	
	public Pair getDelta() {
		return delta;
	}
	
	public void setDelta(Pair delta) {
		this.delta = delta;
	}

	public void setPosition(Pair position) {
		this.position = position;
	}
}
