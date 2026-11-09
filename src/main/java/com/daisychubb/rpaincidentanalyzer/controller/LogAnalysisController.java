package com.daisychubb.rpaincidentanalyzer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daisychubb.rpaincidentanalyzer.dto.AnalysisRequest;
import com.daisychubb.rpaincidentanalyzer.dto.AnalysisResponse;
import com.daisychubb.rpaincidentanalyzer.entity.Analysis;
import com.daisychubb.rpaincidentanalyzer.repository.AnalysisRepository;
import com.daisychubb.rpaincidentanalyzer.service.LogAnalysisService;

@RestController
@RequestMapping("/api/v1/logs")
public class LogAnalysisController {
	
	private final LogAnalysisService logAnalysisService;
	private final AnalysisRepository analysisRepository;
	
	public LogAnalysisController(LogAnalysisService logAnalysisService, AnalysisRepository analysisRepository) {
		this.logAnalysisService = logAnalysisService;
		this.analysisRepository = analysisRepository;
	}
	
	@PostMapping("/analyze")
	public AnalysisResponse analyze(@RequestBody AnalysisRequest request) {
		
		AnalysisResponse response = logAnalysisService.classify(request);
		
		return response;
	}
	
	@GetMapping("/history")
	public List<Analysis> getHistory() {
		return analysisRepository.findAll();
	}
}
