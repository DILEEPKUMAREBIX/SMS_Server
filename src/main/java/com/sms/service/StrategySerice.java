package com.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.ResourceNotFoundException;
import com.sms.Repository.StrategyRepository;
import com.sms.entity.Strategy;

@Service
public class StrategySerice {

	@Autowired
	private StrategyRepository strategyRepository;

	public Iterable<Strategy> getAllStrategies() {
		return strategyRepository.findAll();
	}

	public Strategy saveStrategy(Strategy strategy) {
		return strategyRepository.save(strategy);
	}

	public void deleteStrategy(Long id) {
		Strategy strategy = strategyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("strategy", "id", id));

		strategyRepository.delete(strategy);
	}

	public Strategy updateQuestion(Strategy strategyDetails) {
		Strategy strategy = strategyRepository.findById(strategyDetails.getId())
				.orElseThrow(() -> new ResourceNotFoundException("question", "id", strategyDetails.getId()));
		strategy.setStrNameEng(strategyDetails.getStrNameEng());
		strategy.setStrNameAr(strategyDetails.getStrNameAr());
		strategy.setRecordStatus(strategyDetails.getRecordStatus());

		Strategy updatedstrategy = strategyRepository.save(strategy);
		return updatedstrategy;
	}
}
