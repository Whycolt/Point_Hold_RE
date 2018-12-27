package controllers;

import javafx.animation.*;
import panels.GamePanel;

/**
 * Timer for the actual game of Point Hold
 * @author coltm
 *
 */

public class GameTimer extends AnimationTimer{

	private GameController controller;
	
	public GameTimer(GameController controller){
		this.controller = controller;
	}
	
	@Override
	public void handle(long time) {
		controller.execute();
	}
}
