package main.engine.state;

/**
 * Basic State Object
 * @author bmeachem
 *
 */
public abstract class State {
	
	protected String name;

	public abstract void init();
	
	public abstract void update();
	public abstract void render();
	
	public State(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
