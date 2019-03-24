package com.aws.codestart.projecttemplates.servicie;

import java.util.List;

import com.aws.codestart.projecttemplates.controller.response.KpiClient;
import com.aws.codestart.projecttemplates.domain.Client;

public interface ClientService {
	
	void create(Client client);
	KpiClient findKpi();
	List<Client> findAll();

}
