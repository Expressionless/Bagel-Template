package main.engine.res;

import java.util.HashMap;

public abstract class Resource {
	public static final HashMap<String, Resource> RESOURCES = new HashMap<>();
	
	protected final String name;
	protected final String path;
	
	public Resource(String name, String path) {
		this.name = name;
		this.path = path;
		RESOURCES.put(name, this);
	}
	
	public String getName() {
		return name;
	}
	
	public String getPath() {
		return path;
	}
}
