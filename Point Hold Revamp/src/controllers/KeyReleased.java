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
			game.getPlayer().changeX(0);
		}
		if (e.getCode() == KeyCode.A) {
			game.getPlayer().changeX(0);
		}
		if (e.getCode() == KeyCode.W) {
			game.getPlayer().changeY(0);
		}
		if (e.getCode() == KeyCode.S) {
			game.getPlayer().changeY(0);
		}
	}


	
}
