package main.engine.menu;

import java.util.ArrayList;
import java.util.logging.Logger;

public abstract class Menu {
	protected static final Logger log = Logger.getLogger(Menu.class.getName());

	protected final ArrayList<MenuElement> elements;
	
	protected String name;

	public abstract void loadButtons();
	
	public Menu(String name) {
		elements = new ArrayList<>();
		this.name = name;
		log.info("Created new Menu: " + name);
	}
	
	public void renderElements() {
		for(MenuElement element : elements) {
			element.render();
		}
	}
	
	public void updateElements() {
		for(MenuElement element : elements) {
			element.update();
		}
	}
	
	protected void addElement(MenuElement e) {
		if(e != null) {
			elements.add(e);
		} else log.severe(name + " attempted to add a null element!");
	}
}
