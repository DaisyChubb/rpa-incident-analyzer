package com.daisychubb.rpaincidentanalyzer.dto;

import java.util.List;

import com.daisychubb.rpaincidentanalyzer.model.ClassificationType;

public class AnalysisResponse {
	
	private String status;
	private ClassificationType classification;
	private String severity;
	private String summary;
	private List<String> recommendations;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ClassificationType getClassification() {
		return classification;
	}
	public void setClassification(ClassificationType classification) {
		this.classification = classification;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public List<String> getRecommendations() {
		return recommendations;
	}
	public void setRecommendations(List<String> recommendations) {
		this.recommendations = recommendations;
	}
	
}
