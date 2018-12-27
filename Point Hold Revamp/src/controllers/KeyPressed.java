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
			game.getPlayer().changeX(game.getPlayer().getSpeed());
			System.out.println("happened");
		}
		if (e.getCode() == KeyCode.A) {
			game.getPlayer().changeX(-game.getPlayer().getSpeed());
			System.out.println("happened");

		}
		if (e.getCode() == KeyCode.W) {
			game.getPlayer().changeY(-game.getPlayer().getSpeed());
			System.out.println("happened");

		}
		if (e.getCode() == KeyCode.S) {
			game.getPlayer().changeY(game.getPlayer().getSpeed());
			System.out.println("happened");

		}
	}


	
}
