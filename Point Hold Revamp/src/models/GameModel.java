package models;

import java.util.ArrayList;
import java.util.Observable;
import javafx.scene.canvas.GraphicsContext;


/**
 * Model of the actual game Point Hold
 * @author coltm
 *
 */
public class GameModel extends Observable{
	
	private ArrayList<Entity> e;//List of entities in game
	private Player player;
	
	/**
	 * Constructor for GameModel
	 */
	public GameModel() {
		e = new ArrayList<Entity>();
		player = new Player();
	}
	
	/**
	 * Performs the actions of the entities in the game
	 */
	public void execute() {
		for (Entity i:e) {
			i.action();
		}
		player.action();
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Draws all items in the game
	 * @param g
	 */
	public void draw(GraphicsContext g) {
		for (Entity i:e) {
			i.draw(g);
		}
		player.draw(g);
	}
	
	public Player getPlayer() {
		return player;
	}
	
}

