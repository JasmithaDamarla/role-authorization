package com.authorize.service;

import java.util.List;

import com.authorize.model.entity.Organization;

public interface OrganizationService {

	public Organization addOrgs(Organization orgs);
	public Organization updateOrgs(Organization orgs);
	public void deleteOrgs(int id);
	public List<Organization> viewOrgs();
}
