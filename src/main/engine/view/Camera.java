package main.engine.view;

import bagel.util.Point;
import bagel.util.Rectangle;
import main.engine.GameObject;
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
	
	public boolean isInFrame(GameObject object) {
		return viewRect.intersects(object.getImmutablePos());
	}
	
	public boolean doRender(GameObject object) {
		return renderRect.intersects(object.getImmutablePos());
	}

}
