package controllers;

import models.Bullet;
import models.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawCommands {
	
	public static void draw(Player p,GraphicsContext g) {
		g.setFill(Color.GREEN);
		g.fillOval(p.getPosition().getX(), p.getPosition().getY(), p.getSize(), p.getSize());
	}

	public static void draw(Bullet b, GraphicsContext g) {
		g.setFill(Color.GREEN);
		g.fillOval(b.getPosition().getX(), b.getPosition().getY(), b.getSize(), b.getSize());
	}
}
