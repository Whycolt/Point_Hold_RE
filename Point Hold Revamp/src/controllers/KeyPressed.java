package controllers;

import javafx.event.EventHandler;
import models.GameModel;
import models.PHModel;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyPressed implements EventHandler<KeyEvent>{

	private GameModel game;
	
	public KeyPressed(GameModel g) {
		this.game = g;
	}
	
	@Override
	public void handle(KeyEvent e) {
		if (e.getCode() == KeyCode.D) {
			game.getPlayer().addMove("D");
		}
		if (e.getCode() == KeyCode.A) {
			game.getPlayer().addMove("A");
		}
		if (e.getCode() == KeyCode.W) {
			game.getPlayer().addMove("W");
		}
		if (e.getCode() == KeyCode.S) {
			game.getPlayer().addMove("S");
		}
		if (e.getCode() == KeyCode.RIGHT) {
			game.getPlayer().addMove("Right");
		}
		if (e.getCode() == KeyCode.LEFT) {
			game.getPlayer().addMove("Left");
		}
		if (e.getCode() == KeyCode.UP) {
			game.getPlayer().addMove("Up");
		}
		if (e.getCode() == KeyCode.DOWN) {
			game.getPlayer().addMove("Down");
		}
	}
}
