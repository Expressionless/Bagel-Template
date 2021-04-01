package main.engine.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import bagel.Font;
import main.engine.res.Sprite;

public class ResourceManager implements Runnable {
	private static final Logger log = Logger.getLogger(ResourceManager.class.getName());
		
	public static String ABS_PATH;

	private final ArrayList<Job> jobs;
	private String activeDir = "";

	public static final HashMap<String, Sprite> SPRITES = new HashMap<>();
	public static final HashMap<String, Font> FONTS = new HashMap<>();

	private boolean running = false;

	public ResourceManager() {
		jobs = new ArrayList<>();
		ABS_PATH = new File("").getAbsolutePath();
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		log.info("Starting ResourceManager Thread");
		// run();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		log.info("Stopping ResourceManager Thread");
	}

	/**
	 * Add a resource to the queue to load
	 * 
	 * @param type     - Type of Resource to Load. See <b>ResourceType.java</b>
	 * @param path     - Path to load the resource from
	 * @param relative - Whether or not to use the saved active directory in
	 *                 resource manager.
	 *                 <li>default: <b>false</b>
	 */
	public synchronized void addJob(String type, String path, JobOptions options, boolean relative) {
		if (relative)
			path = activeDir + path;

		jobs.add(new Job(type, path, options));
		log.info("Adding Job: Load " + type + " from: " + path + ". New jobs queue: " + jobs.size());
	}
	
	public synchronized void addJob(String type, String path, JobOptions options) {
		addJob(type, path, options, true);
	}

	public synchronized void addJob(String type, String path) {
		addJob(type, path, null, true);
	}

	@Override
	public void run() {
		start();

		while (running) {
			// Check if there are jobs to process
			if (jobs.size() > 0) {
				log.info(Integer.toString(jobs.size()));
				Job nextJob = jobs.get(0);
				log.info("Loading a " + nextJob.type.toString() + " from " + nextJob.path);
				// Load the resource
				switch (nextJob.type) {
				case Sprite:
					Sprite nextSprite = Sprite.createSprite(nextJob.path);
					SPRITES.put(nextSprite.getName(), nextSprite);
					log.info("Loaded: " + nextSprite.getName());
					break;
				case Font:
					String fileName;
					
					if(!(new File(nextJob.path).exists())) {
						log.severe("File at: " + nextJob.path + " does not exist!");
						break;
					} else fileName = new File(nextJob.path).getName();
					
					Font font = new Font(nextJob.path, nextJob.getOptions().font_size.get());
					log.info("Loaded: " + nextJob.path + " as: " + fileName);
					FONTS.put(nextJob.getOptions().font_name.get(), font);
					break;
				default:
					log.severe("Unhandled type: " + nextJob.type.toString());
					break;
				}

				jobs.remove(0);
			} else running = false;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// stop();
	}

	/**
	 * Set the active directory
	 * 
	 * @param dir - Directory to set to
	 * @param relative - Relative to the previous active directory (will work relative to the Absolute Path otherwise)
	 */
	public void setActiveDir(String dir, boolean relative) {
		String newDir = ABS_PATH + dir;
		if (relative)
			newDir = this.activeDir + dir;

		File file = new File(newDir);
		if (!(file.exists())) {
			log.severe("Directory: " + newDir + " does not exist");
			return;
		}
		
		this.activeDir = newDir;
		log.info("Set Active Directory To: " + this.activeDir);
	}

	/**
	 * Set the active directory relative to the absolute working directory
	 * @param dir
	 */
	public void setActiveDir(String dir) {
		setActiveDir(dir, false);
	}

	public String getActiveDir() {
		return activeDir;
	}

	public synchronized Sprite getSprite(String spriteName) {
		log.fine("Fetching Sprite: " + spriteName);
		Sprite sprite = SPRITES.get(spriteName);
		if (sprite == null) {
			log.severe("Failed to fetch sprite: " + spriteName);
		}
		return sprite;
	}
	
	public synchronized Font getFont(String fontName) {
		log.fine("Fetching Font: " + fontName);
		Font font = FONTS.get(fontName);
		if(font == null)
			log.severe("Failed to fetch font: " + fontName);
		return font;
	}
}
