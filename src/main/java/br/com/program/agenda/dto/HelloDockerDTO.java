package br.com.program.agenda.dto;

public class HelloDockerDTO {
	
	private final String content;
	private final String environment;
	
	public HelloDockerDTO(String content, String environment) {
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