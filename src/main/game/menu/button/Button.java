package main.game.menu.button;

import bagel.Font;
import main.engine.menu.Menu;
import main.engine.menu.MenuElement;
import main.engine.utils.FontUtils;
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
		if (activeSprite != null)
			activeSprite.drawTopLeft(pos);

		Font font = Engine.RES.getFont("button font");
		double x = pos.getX() + activeSprite.getWidth() / 2;
		double y = pos.getY() + activeSprite.getHeight() / 5 * 3;
		
		FontUtils.drawStringCentered(font, name, x, y);
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
