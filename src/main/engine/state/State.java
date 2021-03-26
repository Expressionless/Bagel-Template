package main.engine.state;

import main.game.Engine;

/**
 * Basic State Object
 * @author bmeachem
 *
 */
public abstract class State {
	
	protected String name;
	protected boolean initialized = false;

	public abstract void init();
	
	public abstract void update();
	public abstract void render();
	
	public State(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isInitialized() {
		return initialized;
	}
}
