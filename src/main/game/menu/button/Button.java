package main.game.menu.button;

import main.engine.menu.Menu;
import main.engine.menu.MenuElement;
import main.game.Engine;

public class Button extends MenuElement {

	private ButtonAction action;
	
	public Button(Menu menu, double x, double y) {
		super(menu, Engine.RES.getSprite("menu_button"), x, y);
	}

	@Override
	protected void draw() {
		sprite.draw(pos);
	}

	@Override
	protected void step() {
		
	}
	
	public void setAction(ButtonAction action) {
		this.action = action;
	}
	
	public ButtonAction getAction() {
		return action;
	}	
}
