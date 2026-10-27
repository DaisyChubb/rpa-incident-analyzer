package com.daisychubb.rpaincidentanalyzer.dto;

public class AnalysisRequest {
	
	private String botName;
	private String logContent;
	
	public String getBotName() {
		return botName;
	}
	public void setBotName(String botName) {
		this.botName = botName;
	}
	public String getLogContent() {
		return logContent;
	}
	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}

}
