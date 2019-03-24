package com.intercorp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intercorp.controller.request.ClientRequest;
import com.intercorp.controller.response.KpiClient;
import com.intercorp.controller.response.Response;
import com.intercorp.domain.Client;
import com.intercorp.exception.ClientInsertNullException;
import com.intercorp.servicie.ClientService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/clients")
public class ClientController {
	
	private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    
    
    @PostMapping("/creacliente")
    public ResponseEntity<Response>  create(@Valid @RequestBody ClientRequest request) {
    	try {
    		this.clientService.create(request.getClient());
		} catch (Exception e) {
			 throw new ClientInsertNullException("Error al registrar el visitante");
		}
    	return new ResponseEntity<Response>(new Response(request,"registrado correctamente"),HttpStatus.CREATED); 
    }
    
    
    @GetMapping("/kpideclientes")
    public ResponseEntity<KpiClient>  findKpi() {    	
    	KpiClient kpiClient =  this.clientService.findKpi();
		if (kpiClient == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    	return new ResponseEntity<KpiClient>(kpiClient,HttpStatus.OK); 
    }
    
    @GetMapping("/listclientes")
    public ResponseEntity<List<Client>>  findDocument() {
    	List<Client> lstClient =  this.clientService.findAll();
		if (lstClient == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    	return new ResponseEntity<List<Client>>(lstClient,HttpStatus.OK); 
    }

}
