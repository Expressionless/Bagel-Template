package main.engine.res;

import java.util.HashMap;

public abstract class Resource {
	public static final HashMap<String, Resource> RESOURCES = new HashMap<>();
	
	protected String name;
	protected String path;
	
	public Resource(String name, String path) {
		this.name = name;
		this.path = path;
	}
}
