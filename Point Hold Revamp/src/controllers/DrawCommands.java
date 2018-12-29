package controllers;

import models.BulletE;
import models.BulletF;
import models.Player;
import models.Standard;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawCommands {
	
	public static void draw(Player p,GraphicsContext g) {
		g.setFill(Color.GREEN);
		g.fillOval(p.getPosition().getX(), p.getPosition().getY(), p.getSize(), p.getSize());
	}

	public static void draw(BulletF b, GraphicsContext g) {
		g.setFill(Color.GREEN);
		g.fillOval(b.getPosition().getX(), b.getPosition().getY(), b.getSize(), b.getSize());
	}
	
	public static void draw(BulletE b, GraphicsContext g) {
		g.setFill(Color.RED);
		g.fillOval(b.getPosition().getX(), b.getPosition().getY(), b.getSize(), b.getSize());
	}

	public static void draw(Standard s, GraphicsContext g) {
		g.setFill(Color.RED);
		g.fillOval(s.getPosition().getX(), s.getPosition().getY(), s.getSize(), s.getSize());
	}
}
