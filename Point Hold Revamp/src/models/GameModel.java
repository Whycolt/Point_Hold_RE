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
	private ArrayList<Entity> removed;//list of removed elements
	private ArrayList<Entity> added;
	private Player player;
	
	/**
	 * Constructor for GameModel
	 */
	public GameModel() {
		e = new ArrayList<Entity>();
		removed = new ArrayList<Entity>();
		added = new ArrayList<Entity>();
		player = new Player();
	}
	
	public void add(Entity e) {
		added.add(e);
	}
	
	/**
	 * Performs the actions of the entities in the game
	 */
	public void execute() {
		for (Entity i:e) {
			i.action(this);
		}
		for (Entity i:removed) {
			e.remove(i);
		}
		for (Entity i:added) {
			e.add(i);
		}
		removed.clear();
		added.clear();
		player.action(this);
		this.setChanged();
		this.notifyObservers();
	}
	
	public void remove(Entity e) {
		removed.add(e);
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

