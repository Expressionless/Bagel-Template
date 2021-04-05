package main.engine.menu;

import main.engine.GameObject;
import main.engine.res.Sprite;
import main.engine.utils.Point;

public abstract class MenuElement extends GameObject {
	
	protected Menu menu;
	
	public MenuElement(Menu menu, Sprite sprite, Point pos) {
		super(pos, sprite);
		this.pos = pos;
		this.menu = menu;
	}
	
	public MenuElement(Menu menu, Sprite sprite, double x, double y) {
		this(menu, sprite, new Point(x, y));
	}
}
