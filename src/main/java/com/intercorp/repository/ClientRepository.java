package com.intercorp.repository;

import java.util.List;

import com.intercorp.controller.response.KpiClient;
import com.intercorp.domain.Client;

public interface ClientRepository {
	
	void create(Client client);
	KpiClient findKpi();
	List<Client> findAll();
}
