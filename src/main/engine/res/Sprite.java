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
	
	public void drawTopLeft(Point pos) {
		double width = currentImage.getWidth();
		double height = currentImage.getHeight();
		
		double x = pos.getX() + width / 2;
		double y = pos.getY() + height / 2;
		
		currentImage.draw(x, y);
	}
	
	public void drawTopLeft(double x, double y) {
		drawTopLeft(new Point(x, y));
	}
	
	public void drawCentered(Point pos) {
		drawCentered(pos.getX(), pos.getY());
	}
	
	public void drawCentered(double x, double y) {
		currentImage.draw(x, y);
	}
	
	public void drawCentered(double x, double y, DrawOptions options) {
		currentImage.draw(x , y, options);
	}
	
	public double getWidth() {
		return currentImage.getWidth();
	}
	
	public double getHeight() {
		return currentImage.getHeight();
	}
}
