package br.com.program.agenda.entities;

import jakarta.persistence.Entity;

public class HelloDocker {
	
	private final String content;
	private final String environment;
	
	public HelloDocker(String content, String environment) {
		this.content = content;
		this.environment = environment;
	}

	public String getContent() {
		return content;
	}

	public String getEnvironment() {
		return environment;
	}
}