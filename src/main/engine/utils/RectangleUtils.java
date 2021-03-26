package main.engine.utils;

import bagel.util.Point;
import bagel.util.Rectangle;

public class RectangleUtils {

	public static Rectangle createCenteredRectangle(Point centre, int width, int height) {
		Point topLeft = new Point(centre.x - width / 2, centre.y - height / 2);
		Rectangle rect = new Rectangle(topLeft, width, height);

		return rect;
	}
	
	public static Rectangle createCenteredRectangle(main.engine.utils.Point centre, int width, int height) {
		return createCenteredRectangle(centre.toBagelPos(), width, height);
	}

}
