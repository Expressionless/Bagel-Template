package main.engine.utils;

import main.engine.res.ResourceType;

public class Job {
	private JobOptions options;
	
	public final ResourceType type;
	public final String path;

	public Job(String type, String path, JobOptions options) {
		this.type = ResourceType.valueOf(type);
		this.path = path;
		this.options = options;
	}
	
	public Job(String type, String path) {
		this(type, path, null);
	}
	
	public JobOptions getOptions() {
		return options;
	}
}
