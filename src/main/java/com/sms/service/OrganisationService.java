package com.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.ResourceNotFoundException;
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

	public void deleteOrganisation(Long id) {
		Organisation organisation = organisationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("question", "id", id));

		organisationRepository.delete(organisation);
	}

	public Organisation updateQuestion(Organisation organisationDetails) {
		Organisation organisation = organisationRepository.findById(organisationDetails.getId())
				.orElseThrow(() -> new ResourceNotFoundException("question", "id", organisationDetails.getId()));
		organisation.setOrgNameEng(organisationDetails.getOrgNameEng());
		organisation.setOrgNameAr(organisationDetails.getOrgNameAr());
		organisation.setRecordStatus(organisationDetails.getRecordStatus());

		Organisation updatedOrganisation = organisationRepository.save(organisation);
		return updatedOrganisation;
	}

}
