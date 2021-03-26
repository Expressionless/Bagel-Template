package main.engine.view;

import bagel.util.Rectangle;
import main.engine.GameObject;
import main.engine.utils.Point;
import main.engine.utils.RectangleUtils;
import main.game.Constants;

public class Camera {
	// TODO: Link this to a tile value
	public static final int RENDER_BUFFER = 32;

	private Rectangle viewRect, renderRect;
	private Point pos;

	public Camera(Point pos) {
		this.pos = pos;
		viewRect = RectangleUtils.createCenteredRectangle(pos, Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
		renderRect = RectangleUtils.createCenteredRectangle(pos, Constants.FRAME_WIDTH + RENDER_BUFFER,
				Constants.FRAME_HEIGHT + RENDER_BUFFER);
	}
	
	public Camera(double x, double y) {
		this(new Point(x, y));
	}
	
	public boolean shouldDoUpdate(GameObject object) {
		return viewRect.intersects(object.getPos().toBagelPos());
	}
	
	public boolean shouldDoRender(GameObject object) {
		return renderRect.intersects(object.getPos().toBagelPos());
	}

}
