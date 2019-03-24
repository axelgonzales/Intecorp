package com.intercorp.servicie;

import java.util.List;

import com.intercorp.controller.response.KpiClient;
import com.intercorp.domain.Client;

public interface ClientService {
	
	void create(Client client);
	KpiClient findKpi();
	List<Client> findAll();

}
