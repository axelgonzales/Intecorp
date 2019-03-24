package com.aws.codestart.projecttemplates.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws.codestart.projecttemplates.controller.response.KpiClient;
import com.aws.codestart.projecttemplates.domain.Client;
import com.aws.codestart.projecttemplates.repository.ClientRepository;
import com.aws.codestart.projecttemplates.service.ClientService;


@Service
public class ClientServiceImpl  implements ClientService{
	
	private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
	
	@Override
	public void create(Client client) {
		clientRepository.create(client);
		
	}

	@Override
	public KpiClient findKpi() {
		// TODO Auto-generated method stub
		return clientRepository.findKpi();
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

}
