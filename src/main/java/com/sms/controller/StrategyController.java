package com.sms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.entity.Strategy;
import com.sms.service.StrategySerice;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class StrategyController {

	@Autowired
	StrategySerice strategySerice;

	@GetMapping("/getAllStrategies")
	public Iterable<Strategy> getAllStrategies() {
		Iterable<Strategy> strategies = strategySerice.getAllStrategies();
		return strategies;
	}

	@PostMapping("/strategy")
	public Strategy saveStrategy(@Valid @RequestBody Strategy organisation) {
		return strategySerice.saveStrategy(organisation);
	}

	@DeleteMapping("/strategy/{id}")
	public void deleteStrategy(@PathVariable(value = "id") Long id) {
		strategySerice.deleteStrategy(id);
	}
}
