package controllers;

import javafx.event.EventHandler;
import models.GameModel;
import models.PHModel;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyReleased implements EventHandler<KeyEvent>{

	private GameModel game;
	
	public KeyReleased(GameModel g) {
		this.game = g;
	}
	
	@Override
	public void handle(KeyEvent e) {
		if (e.getCode() == KeyCode.D) {
			game.getPlayer().removeMove("D");
		}
		if (e.getCode() == KeyCode.A) {
			game.getPlayer().removeMove("A");
		}
		if (e.getCode() == KeyCode.W) {
			game.getPlayer().removeMove("W");
		}
		if (e.getCode() == KeyCode.S) {
			game.getPlayer().removeMove("S");			
		}
		if (e.getCode() == KeyCode.RIGHT) {
			game.getPlayer().removeMove("Right");
		}
		if (e.getCode() == KeyCode.LEFT) {
			game.getPlayer().removeMove("Left");
		}
		if (e.getCode() == KeyCode.UP) {
			game.getPlayer().removeMove("Up");
		}
		if (e.getCode() == KeyCode.DOWN) {
			game.getPlayer().removeMove("Down");
		}
	}


	
}
