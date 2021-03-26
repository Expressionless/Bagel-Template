package main;

import java.util.logging.Logger;

import main.game.Engine;

public class Main {
	private static final Logger log = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		log.info("Starting Engine");
        Engine engine = new Engine();
        engine.run();
	}
	
}
