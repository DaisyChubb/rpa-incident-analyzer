package com.daisychubb.rpaincidentanalyzer.service;

import org.springframework.stereotype.Service;

import com.daisychubb.rpaincidentanalyzer.model.ClassificationType;

@Service
public class LogAnalysisService {

	public ClassificationType classify(String logContent) {
		
		String log = logContent.toLowerCase();
		
		if (log.contains("invalid field path")) {
			return ClassificationType.UI_CHANGE;
		}
		
		if (log.contains("login failed")) {
			return ClassificationType.CREDENTIAL_ISSUE;
		}
		
		if (log.contains("timeout")) {
			return ClassificationType.TIMEOUT;
		}
		
		if (log.contains("application unavailable")) {
			return ClassificationType.SYSTEM_UNAVAILABLE;
		}
		
		return ClassificationType.UNKNOWN;
	}
}
