package com.authorize.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authorize.model.entity.Organization;
import com.authorize.service.OrganizationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/orgs")
@RestController
public class OrganizationController {
	
	@Autowired
	private OrganizationService organizationService;
	
//	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<Organization> createOrganization(@RequestBody Organization orgs) {
		log.info("orgs is getting created {}",orgs.toString());
		return new ResponseEntity<>(organizationService.addOrgs(orgs),HttpStatus.CREATED);
	}
	
//	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_SUPPORTER') or hasAuthority('ROLE_MANAGER')")
	@GetMapping
	public ResponseEntity<List<Organization>> readOrganization() {
		log.info("obtaining data from service");
		return new ResponseEntity<>(organizationService.viewOrgs(),HttpStatus.OK);
	}
	
//	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_SUPPORTER')")
	@PutMapping
	public ResponseEntity<Organization> updateOrganization(@RequestBody Organization orgs) {
		log.info("updating data {}",orgs);
		return new ResponseEntity<>(organizationService.updateOrgs(orgs),HttpStatus.CREATED);
	}

//	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_SUPPORTER')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrganization(@PathVariable int id) {
		organizationService.deleteOrgs(id);
		log.info("deleted org successfully");
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
