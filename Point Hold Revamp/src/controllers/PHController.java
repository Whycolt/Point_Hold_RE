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
	private MenuController home;//Controllers for menus
	
	/**
	 * Constructor for PHController
	 * @param model
	 * @param stage
	 */
	public PHController(PHModel model, Stage stage) {
		this.model = model;
		this.home = new HomeController(this.model);
	}

	
	@Override
	/**
	 * Handles events given action arg0
	 */
	public void handle(ActionEvent arg0) {
		if (model.inGame()){
			return;
		}
		switch(model.getState()) {
			case 0:
				home.handle(arg0);
				break;
		}
	}
}
