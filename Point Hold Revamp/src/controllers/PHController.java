package controllers;

import javafx.stage.Stage;
import models.PHModel;

import java.util.Observable;
import java.util.Observer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Controller to handle events for Point Hold
 * @author coltm
 *
 */

public class PHController implements EventHandler<ActionEvent>{

	private PHModel model;//Model
	private MenuController homeController;//Controllers for menus
	private GameController gameController;//Controller for the actual game
	
	/**
	 * Constructor for PHController
	 * @param model
	 * @param stage
	 */
	public PHController(PHModel model, Stage stage) {
		this.model = model;
		this.homeController = new HomeController(this.model);
		this.gameController = new GameController(this.model);
	}
	
	@Override
	/**
	 * Handles events given action arg0
	 */
	public void handle(ActionEvent arg0) {
		if (model.inGame()){
			gameController.handle(arg0);
			return;
		}
		System.out.println("Current State: " + model.getState());
		switch(model.getState()) {
			case 0:
				homeController.handle(arg0);
				if (model.getState() == 1) {
					gameController.gameInit();
				}
				break;
			case 2:
				
				break;
		}
	}
}
