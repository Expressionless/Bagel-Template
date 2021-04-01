package main.engine.utils;

import bagel.Font;

public class FontUtils {

	public static void drawStringCentered(Font font, String text, double x, double y) {
		double width = font.getWidth(text);
		font.drawString(text, x - width / 2, y);
	}
	
}
