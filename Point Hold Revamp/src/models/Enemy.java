package models;

import Point_Hold_RE.Pair;

public abstract class Enemy extends Entity{

	public Enemy(Pair start, Pair movement, int hp) {
		position = start;
		delta = movement;
		this.hp = hp;
		size = 60;
	}

}
