package main.engine.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import main.engine.res.ResourceType;
import main.engine.res.Sprite;

public class ResourceManager implements Runnable {
	private static final Logger log = Logger.getLogger(ResourceManager.class.getName());
	public static String ABS_PATH;

	private final ArrayList<Job> jobs;
	private String activeDir = "";

	public static final HashMap<String, Sprite> SPRITES = new HashMap<>();

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
		//run();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		log.info("Stopping ResourceManager Thread");
	}

	/**
	 * Add a resource to the queue to load
	 * @param type - Type of Resource to Load. See <b>ResourceType.java</b>
	 * @param path - Path to load the resource from
	 * @param relative - Whether or not to use the saved active directory in resource manager.
	 * 		<li>default: <b>false</b>
	 */
	public synchronized void addJob(String type, String path, boolean relative) {
		if(relative)
			path = activeDir + path;
		
		jobs.add(new Job(type, path));
		log.info("Adding Job: Load " + type + " from: " + path + ". New jobs queue: " + jobs.size());
	}
	
	public synchronized void addJob(String type, String path) {
		addJob(type, path, true);
	}

	@Override
	public void run() {
		start();

		while (true) {
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
					
				default:
					log.severe("Unhandled type: " + nextJob.type.toString());
					break;
				}
				
				jobs.remove(0);
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		//stop();
	}

	/**
	 * Set the active directory relative to the current active directory
	 * @param dir
	 * @param relative
	 */
	public void setActiveDir(String dir, boolean relative) {
		String newDir = ABS_PATH + dir;
		if(relative)
			newDir = this.activeDir + dir;
		
		File file = new File(newDir);
		if(!(file.exists())) {
			log.severe("Directory: " + newDir + " does not exist");
			return;
		}
		this.activeDir = newDir;
		log.info("Set Active Directory To: " + this.activeDir);
	}
	
	public void setActiveDir(String dir) {
		setActiveDir(dir, false);
	}
	
	public String getActiveDir() {
		return activeDir;
	}
	
	public synchronized Sprite getSprite(String spriteName) {
		return SPRITES.get(spriteName);
	}
	
	/**
	 * Basic utility job class
	 * 
	 * @author bmeachem
	 *
	 */
	private class Job {
		private final ResourceType type;
		private String path;

		public Job(String type, String path) {
			this.type = ResourceType.valueOf(type);
			this.path = path;
		}
	}
}
