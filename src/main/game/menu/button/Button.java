package main.game.menu.button;


import main.engine.menu.Menu;
import main.engine.menu.MenuElement;
import main.game.Engine;

public class Button extends MenuElement {

	private ButtonAction action;
	private String name;
	
	public Button(Menu menu, String name, double x, double y) {
		super(menu, Engine.RES.getSprite("button.png"), x, y);
		this.name = name;
		
		log.info("Created new button: " + name);
	}

	@Override
	protected void draw() {
		//if(sprite != null)
		//	sprite.draw(pos);
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
	
	public String getName() {
		return name;
	}
}
