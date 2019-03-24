package com.aws.codestart.projecttemplates.repository;

import java.util.List;

import com.aws.codestart.projecttemplates.controller.response.KpiClient;
import com.aws.codestart.projecttemplates.domain.Client;

public interface ClientRepository {
	
	void create(Client client);
	KpiClient findKpi();
	List<Client> findAll();
}
