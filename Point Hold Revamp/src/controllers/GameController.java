package controllers;

import javafx.event.EventHandler;
import models.GameModel;
import models.PHModel;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;

/**
 * Controller for actual game 
 * @author coltm
 *
 */

public class GameController implements EventHandler<ActionEvent>{

	private GameTimer tick;
	private PHModel model;
	private GameModel game;
	private boolean timer;
	
	public GameController(PHModel model) {
		this.timer = false;
		this.model = model;
		this.tick = new GameTimer(this);
	}
	
	public void gameInit() {
		game = model.getGame();
		tick.start();
		timer = true;
	}
	
	public boolean isOn() {
		return timer;
	}
	
	public void start() {
		tick.start();
		timer = true;
	}
	
	public void stop() {
		tick.stop();
		timer = false;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
	}
	
	public void execute() {
		if (game != null)
			game.execute();
	}
	
}
