package com.authorize.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authorize.model.entity.Organization;
import com.authorize.repository.OrganizationRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrganizationServiceImpl implements OrganizationService{
	
	@Autowired
	private OrganizationRepository organizationRepository;

	@Override
	public Organization addOrgs(Organization orgs) {
	    log.info("entered service of inserting..{}", orgs.toString());
	    return organizationRepository.save(orgs);
	}

	@Override
	public Organization updateOrgs(Organization orgs) {
	    log.info("entered service of updating..");
	    return organizationRepository.save(orgs);
	}

	@Override
	public void deleteOrgs(int id) {
	    log.info("deleting org of id {}", id);
	    organizationRepository.deleteById(id);
	}

	@Override
	public List<Organization> viewOrgs() {
	    log.info("loading all rows");
	    return organizationRepository.findAll();
	}

}
