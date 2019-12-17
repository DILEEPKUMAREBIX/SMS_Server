package com.sms.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	public Strategy saveStrategy(@Valid @RequestBody Strategy strategy) {
		return strategySerice.saveStrategy(strategy);
	}

	@DeleteMapping("/strategy/{id}")
	public void deleteStrategy(@PathVariable(value = "id") Long id) {
		strategySerice.deleteStrategy(id);
	}

	@PostMapping("/strategyWithImage")
	public ResponseEntity<String> createStrategy(@RequestPart("strategyImage") MultipartFile strategyImage,
			@RequestPart("strategy") String strategyString)
			throws JsonParseException, JsonMappingException, IOException {
		String message = "";
		try {
			Strategy strategy = new ObjectMapper().readValue(strategyString, Strategy.class);
			strategy.setImage(strategyImage.getBytes());
			strategySerice.saveStrategy(strategy);
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			// message = "FAIL to upload " + profileImage.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
}
