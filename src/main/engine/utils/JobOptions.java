package main.engine.utils;

import java.util.Optional;

import bagel.Font;

public class JobOptions {
	// Some defaults to use
	public Optional<Integer> font_size = Optional.empty();
	public Optional<String> font_name = Optional.empty();
	
	public JobOptions(String font_name) {
		this.font_name = Optional.of(font_name);
	}
	
	public void setFontSize(int size) {
		font_size = Optional.of(size);
	}
	
	public void setFontName(String font_name) {
		this.font_name = Optional.of(font_name);
	}
}
