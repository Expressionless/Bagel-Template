package main.engine.res;

import java.io.File;

import bagel.DrawOptions;
import bagel.Image;
import main.engine.utils.Point;

public class Sprite extends Resource {
	
	private Image currentImage;

	private Sprite(String name, String path) {
		super(name, path);
		currentImage = new Image(path);
		log.info("Created new Sprite: " + name);
	}
	
	public static Sprite createSprite(String path) {
		File file = new File(path);
		
		// TODO: Return missing sprite
		if(!file.exists())
			return null;
		
		Sprite sprite = new Sprite(file.getName(), path);
		return sprite;
	}
	
	public void draw(Point pos) {
		currentImage.draw(pos.getX(), pos.getY());
	}
	
	public void draw(double x, double y) {
		currentImage.draw(x, y);
	}
	
	public void draw(double x, double y, DrawOptions options) {
		currentImage.draw(x , y, options);
	}
}
