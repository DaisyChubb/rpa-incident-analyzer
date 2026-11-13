package com.daisychubb.rpaincidentanalyzer.dto;

public class AnalysisStatsResponse {
	private long totalAnalyses;
    private long uiChanges;
    private long credentialIssues;
    private long timeouts;
    private long systemUnavailable;
    private long unknown;
    
	public long getTotalAnalyses() {
		return totalAnalyses;
	}
	public void setTotalAnalyses(long totalAnalyses) {
		this.totalAnalyses = totalAnalyses;
	}
	public long getUiChanges() {
		return uiChanges;
	}
	public void setUiChanges(long uiChanges) {
		this.uiChanges = uiChanges;
	}
	public long getCredentialIssues() {
		return credentialIssues;
	}
	public void setCredentialIssues(long credentialIssues) {
		this.credentialIssues = credentialIssues;
	}
	public long getTimeouts() {
		return timeouts;
	}
	public void setTimeouts(long timeouts) {
		this.timeouts = timeouts;
	}
	public long getSystemUnavailable() {
		return systemUnavailable;
	}
	public void setSystemUnavailable(long systemUnavailable) {
		this.systemUnavailable = systemUnavailable;
	}
	public long getUnknown() {
		return unknown;
	}
	public void setUnknown(long unknown) {
		this.unknown = unknown;
	}

}
