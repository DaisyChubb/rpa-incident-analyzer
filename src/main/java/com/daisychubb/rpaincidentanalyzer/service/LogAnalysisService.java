package com.daisychubb.rpaincidentanalyzer.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.daisychubb.rpaincidentanalyzer.dto.AnalysisRequest;
import com.daisychubb.rpaincidentanalyzer.dto.AnalysisResponse;
import com.daisychubb.rpaincidentanalyzer.entity.Analysis;
import com.daisychubb.rpaincidentanalyzer.model.ClassificationType;
import com.daisychubb.rpaincidentanalyzer.repository.AnalysisRepository;

@Service
public class LogAnalysisService {
	
	private final AnalysisRepository analysisRepository;
	
	public LogAnalysisService(AnalysisRepository analysisRepository) {
		this.analysisRepository = analysisRepository;
	}

	public AnalysisResponse classify(AnalysisRequest request) {
		
		String log = request.getLogContent().toLowerCase();
		AnalysisResponse response = new AnalysisResponse();
		ClassificationType classification = ClassificationType.UNKNOWN;
		
		if (log.contains("invalid field path")) {
			classification = ClassificationType.UI_CHANGE;
		}
		else if (log.contains("login failed")) {
			classification = ClassificationType.CREDENTIAL_ISSUE;
		}
		else if (log.contains("timeout")) {
			classification = ClassificationType.TIMEOUT;
		}
		else if (log.contains("application unavailable")) {
			classification = ClassificationType.SYSTEM_UNAVAILABLE;
		}
		
		response.setStatus("FAILED");
		response.setClassification(classification);
		
		switch (classification) {
			case UI_CHANGE: 
				response.setSeverity("MEDIUM");
				response.setSummary("Bot failed due to a possible UI change.");
				response.setRecommendations(List.of(
			            "Review error screenshot",
			            "Review application UI",
			            "Validate selectors and path in AA",
			            "Re-record action in AA"));
				break;
				
			case CREDENTIAL_ISSUE:
				response.setSeverity("HIGH");
				response.setSummary("Bot failed due to authentication issues");
				response.setRecommendations(List.of(
						"Review values in credential vault",
						"Review version of KeePass",
						"Check credential expiration",
						"Escalate to application support team"));
				break;
				
			case TIMEOUT:
				response.setSeverity("MEDIUM");
				response.setSummary("Bot execution exceeded the allowed time.");
				response.setRecommendations(List.of(
						"Review application response times",
						"Increase timeout threshold in AA",
						"Check network connectivity",
						"Investigate performance bottlenecks"));
				break;
				
			case SYSTEM_UNAVAILABLE:
				response.setSeverity("HIGH");
				response.setSummary("Target application appears unavailable.");
				response.setRecommendations(List.of(
						"Verify application availability",
						"Review health check and monitoring dashboard",
						"Review recent outage communication or maintenance windows",
						"Escalate to application support team"));
				break;
				
			default:
				response.setSeverity("LOW");
				response.setSummary("Unable to determine root cause");
				response.setRecommendations(List.of(
						"Review entire execution logs",
						"Gather additional diagnositic information",
						"Review PDD and compare with UC in the code",
						"Update classification rules if neccessary"));
				break;
		}
		
		//Save response to database
		Analysis analysis = new Analysis();
		
		analysis.setBotName(request.getBotName());
		analysis.setClassification(classification.name());
		analysis.setSeverity(response.getSeverity());
		analysis.setSummary(response.getSummary());
		analysis.setAnalyzedAt(LocalDateTime.now());
		
		analysisRepository.save(analysis);
		
		return response;
	}
}
