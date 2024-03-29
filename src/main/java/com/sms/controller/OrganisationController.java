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

import com.sms.entity.Organisation;
import com.sms.service.OrganisationService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class OrganisationController {

	@Autowired
	OrganisationService organisationService;

	@GetMapping("/getAllOrganisations")
	public Iterable<Organisation> getAllOrganisations() {
		Iterable<Organisation> questions = organisationService.getAllOrganisations();
		return questions;
	}

	@PostMapping("/organisation")
	public Organisation saveOrganisation(@Valid @RequestBody Organisation organisation) {
		return organisationService.saveOrganisation(organisation);
	}

	@DeleteMapping("/organisation/{id}")
	public void deleteOrganisation(@PathVariable(value = "id") Long id) {
		organisationService.deleteOrganisation(id);
	}
}
