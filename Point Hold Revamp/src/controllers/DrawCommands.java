package controllers;

import models.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawCommands {
	
	public static void draw(Player p,GraphicsContext g) {
		g.setFill(Color.GREEN);
		g.fillOval(p.getX(), p.getY(), 60, 60);
	}
}
