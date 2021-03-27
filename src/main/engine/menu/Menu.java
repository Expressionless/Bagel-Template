package main.engine.menu;

import java.util.ArrayList;

public abstract class Menu {

	protected final ArrayList<MenuElement> elements;
	
	protected String name;

	public abstract void loadButtons();
	
	public Menu(String name) {
		elements = new ArrayList<>();
		this.name = name;
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
}
