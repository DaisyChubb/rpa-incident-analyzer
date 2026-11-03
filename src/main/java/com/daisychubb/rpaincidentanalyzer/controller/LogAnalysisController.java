package com.daisychubb.rpaincidentanalyzer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daisychubb.rpaincidentanalyzer.dto.AnalysisRequest;
import com.daisychubb.rpaincidentanalyzer.dto.AnalysisResponse;
import com.daisychubb.rpaincidentanalyzer.model.ClassificationType;
import com.daisychubb.rpaincidentanalyzer.service.LogAnalysisService;

@RestController
@RequestMapping("/api/v1/logs")
public class LogAnalysisController {
	
	private final LogAnalysisService logAnalysisService;
	
	public LogAnalysisController(LogAnalysisService logAnalysisService) {
		this.logAnalysisService = logAnalysisService;
	}
	
	@PostMapping("/analyze")
	public AnalysisResponse analyze(@RequestBody AnalysisRequest request) {
		
		AnalysisResponse response = logAnalysisService.classify(request.getLogContent());
		
		return response;
	}
}
