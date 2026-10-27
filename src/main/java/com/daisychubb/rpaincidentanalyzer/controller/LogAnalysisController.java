package com.daisychubb.rpaincidentanalyzer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daisychubb.rpaincidentanalyzer.dto.AnalysisRequest;
import com.daisychubb.rpaincidentanalyzer.dto.AnalysisResponse;

@RestController
@RequestMapping("/api/v1/logs")
public class LogAnalysisController {
	
	@PostMapping("/analyze")
	public AnalysisResponse analyze(@RequestBody AnalysisRequest request) {
		
		AnalysisResponse response = new AnalysisResponse();
		
		//Hardcoded responses for now
		response.setStatus("FAILED");
		response.setClassification("UI_CHANGE");
		response.setSeverity("MEDIUM");
		response.setSummary("Incorrect field path");
		response.setRecommendations(
				List.of("Validate Recorder selectors",
						"Review SAP screen layout",
						"Validate SAP environment"));
		
		return response;
	}
}
