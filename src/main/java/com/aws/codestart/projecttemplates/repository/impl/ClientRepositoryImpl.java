package com.aws.codestart.projecttemplates.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aws.codestart.projecttemplates.controller.response.KpiClient;
import com.aws.codestart.projecttemplates.domain.Client;
import com.aws.codestart.projecttemplates.repository.ClientRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Repository
public class ClientRepositoryImpl implements ClientRepository {
	

	@Override
	public void create(Client client) {

	
        

	}

	@Override
	public KpiClient findKpi() {
		KpiClient kpiClient = new KpiClient();
		kpiClient.setOldAverage(1);
		kpiClient.setOldDesviation(2);
		return kpiClient;
	}

	@Override
	public List<Client> findAll() {
		List<Client> clients = new ArrayList<>();
		Client client  = new Client();
		client.setBirthdate("1997-27-09");
		client.setFirstName("Axel Cristhofer");
		client.setLastName("Gonzales Llerena");
		client.setOld(21);
		clients.add(client);
		return clients;
	}

}
