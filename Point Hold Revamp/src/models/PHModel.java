package models;

import java.util.Observable;

/**
 * Model of Point Hold
 * @author coltm
 *
 */

public class PHModel extends Observable{
	
	private GameModel game; //Game model
	private int state;//Model state
	
	//State methods
	/**
	 * Constructor for PHModel
	 */
	public PHModel(){
		state = 0;
		startGame();
	}
	
	/**
	 * change state of PHModel
	 */
	public void ChangeState(int state) {
		this.setChanged();
		this.notifyObservers();
		this.state = state;
	}
	
	/**
	 * Returns state of PHModel
	 * @return state
	 */
	public int getState() {
		return state;
	}
	
	/**
	 * Returns true if model is currently in game, false otherwise 
	 * @return 
	 */
	public boolean inGame() {
		return state == 1;
	}
	//Game state methods
	/**
	 * Starts a new game in model
	 */
	public void startGame() {
		game = new GameModel();
		this.setChanged();
		this.notifyObservers();
	 }
	
	 /**
	  * Returns current game instance of the GameModel
	  * @return game
	  */
	public GameModel getGame() {
		return game;
	}
	
}
