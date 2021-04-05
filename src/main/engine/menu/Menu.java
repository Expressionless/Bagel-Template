package main.engine.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import bagel.Input;
import main.game.menu.button.Button;
import main.game.menu.button.ButtonAction;
import main.game.state.MenuState;

public abstract class Menu {
	protected static final Logger log = Logger.getLogger(Menu.class.getName());

	protected final ArrayList<MenuElement> elements;
	protected final HashMap<String, Button> buttons;
	
	protected final MenuState menuState;
	
	protected String name;

	public abstract void loadButtons();
	
	public Menu(String name, MenuState menuState) {
		this.name = name;
		elements = new ArrayList<>();
		buttons = new HashMap<>();
		this.menuState = menuState;
		loadButtons();
		
		log.info("Created new Menu: " + name);
	}
	
	public void renderElements() {
		for(MenuElement element : elements) {
			element.render();
		}
	}
	
	public void updateElements(Input input) {
		for(MenuElement element : elements) {
			element.update(input);
		}
	}
	
	protected void addElement(MenuElement e) {
		if(e != null) {
			elements.add(e);
		} else log.severe(name + " attempted to add a null element!");
	}

	protected Button createButton(String name, double x, double y, ButtonAction action) {
		Button button = new Button(this, name, x, y);
		button.setAction(action);
		buttons.put(name, button);
		addElement(button);
		
		return button;
	}
	
	protected Button createButton(String name, double x, double y) {
		return createButton(name, x, y, () -> {});
	}
	
	public String getName() {
		return name;
	}
}
