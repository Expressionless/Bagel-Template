package main.engine.state;

import java.util.logging.Logger;

import bagel.Input;
import main.engine.menu.Menu;

/**
 * Basic State Object
 * @author bmeachem
 *
 */
public abstract class State {
	protected static final Logger log = Logger.getLogger(Menu.class.getName());
	
	protected String name;
	protected boolean initialized = false;

	public abstract void init();
	
	public abstract void update(Input input);
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
