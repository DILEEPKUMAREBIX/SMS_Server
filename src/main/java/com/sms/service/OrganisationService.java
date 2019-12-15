package com.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.Repository.OrganisationRepository;
import com.sms.entity.Organisation;

@Service
public class OrganisationService {
	
	@Autowired
	private OrganisationRepository organisationRepository;
	
	public Iterable<Organisation> getAllOrganisations() {
		return organisationRepository.findAll();
	}
	
	public Organisation saveOrganisation(Organisation organisation) {
		return organisationRepository.save(organisation);
	}

}
