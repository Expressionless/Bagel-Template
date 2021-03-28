package main.engine.menu;

import java.util.logging.Logger;

import main.engine.res.Sprite;
import main.engine.utils.Point;

public abstract class MenuElement {
	protected static final Logger log = Logger.getLogger(MenuElement.class.getName());

	protected Sprite sprite;
	protected Point pos;
	
	protected Menu menu;
	/**
	 * Called at end of MenuElement.render
	 */
	protected abstract void draw();
	/**
	 * Called at end of MenuElement.update
	 */
	protected abstract void step();
	
	public MenuElement(Menu menu, Sprite sprite, Point pos) {
		this.sprite = sprite;
		this.pos = pos;
		this.menu = menu;
	}
	
	public MenuElement(Menu menu, Sprite sprite, double x, double y) {
		this(menu, sprite, new Point(x, y));
	}

	// Render the sprite
	public void render() {
		if(sprite != null)
			sprite.draw(pos);
		
		draw();
	}
	
	public void update() {
		
		step();
	}
	
}
