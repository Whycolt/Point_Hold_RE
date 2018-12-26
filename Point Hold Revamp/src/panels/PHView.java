package panels;

import java.awt.peer.MenuPeer;
import java.util.Observable;
import java.util.Observer;

import controllers.PHController;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.PHModel;

/**
 * View used to make Point Hold
 * @author coltm
 */

public class PHView implements Observer{

	private PHModel model;//model
	private Stage stage;//stage
	private PHController controller;//controller
	private MenuPanel menuPanel;//panel for menus
	private GamePanel gamePanel;//panel for game
	private Pane root;//root of stage
	private Pane current;//active panel
	
	/**
	 * Constructor for PHView
	 * @param model 
	 * @param stage
	 */
	public PHView(PHController controller,PHModel model, Stage stage) {
		this.model = model;
		model.addObserver(this);
		this.stage = stage;
		this.controller = controller;
		this.root = new Pane();
		this.initUI(stage);
	}

	/**
	 * Initiates the stage for the view
	 * @param stage
	 */
	private void initUI(Stage stage) {
		menuPanel = new MenuPanel(model, controller);
		gamePanel = new GamePanel(model, controller);
		current = menuPanel;
		root.getChildren().add(current);
		Scene scene = new Scene(root,800,600);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Updates when notified
	 */
	//Changes between game and menu panel
	@Override
	public void update(Observable o, Object arg) {
		root.getChildren().remove(current);
		if (model.inGame()) {
			current = gamePanel;
		}
		else {
			current = menuPanel;
		}
		root.getChildren().add(current);
		System.out.println("updated");
	}
}
