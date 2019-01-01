package controllers;

import Point_Hold_RE.Pair;
import Point_Hold_RE.Size;
import models.GameModel;
import models.Standard;

public class EnemyFactory {

	private GameModel g;
	private int count;
	
	public EnemyFactory(GameModel g) {
		this.g = g;
		count = 181;
	}

	public void createEnemy() {
		if (count > 360) {
			count = 0;
			int direction = (int)(Math.random()*2);
			int start = (int)(Math.random()*2);
			Pair dir = new Pair(0,0);
			Pair str = new Pair(0,0);
			if (direction == 1) {
				dir = new Pair(0,1);
			}
			else {
				dir = new Pair(1,0);
			}
			if (start == 1) {
				str = new Pair(0,(int)(Math.random()*(Size.y-60)));
			}
			else {
				str = new Pair((int)(Math.random()*(Size.x-60)),0);
			}
			g.add(new Standard(str,dir));
		}
		count += 1;
	}
	
}
