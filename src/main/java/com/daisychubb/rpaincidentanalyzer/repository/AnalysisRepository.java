package com.daisychubb.rpaincidentanalyzer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daisychubb.rpaincidentanalyzer.entity.Analysis;

public interface AnalysisRepository extends JpaRepository<Analysis, Long> {
	
	long countByClassification(String classification);
	long countByBotName(String botName);
}
