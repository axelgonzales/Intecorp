package com.aws.codestart.projecttemplates.controller;

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

import com.aws.codestart.projecttemplates.controller.response.ClientResponse;
import com.aws.codestart.projecttemplates.controller.response.KpiClient;
import com.aws.codestart.projecttemplates.controller.response.Response;
import com.aws.codestart.projecttemplates.domain.Client;
import com.aws.codestart.projecttemplates.service.ClientService;


@RestController
@RequestMapping("/clients")
public class ClientController {
	
	private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    
    
    @PostMapping("/creacliente")
    public ResponseEntity<Response>  create(@Valid @RequestBody Client client) {
    	
		this.clientService.create(client);
    	return new ResponseEntity<Response>(new Response(client,"Registrado correctamente"),HttpStatus.CREATED); 
    }
    
    
    @GetMapping("/kpideclientes")
    public ResponseEntity<Response>  findKpi() {    	
    	KpiClient kpiClient =  this.clientService.findKpi();
		if (kpiClient == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
    	return new ResponseEntity<Response>(new Response(kpiClient,"Procesado correctamente"),HttpStatus.OK); 
    }
    
    @GetMapping("/listclientes")
    public ResponseEntity<Response>  findAll() {
    	try {
        	List<ClientResponse> lstClient =  this.clientService.findAll();
        	return new ResponseEntity<Response>(new Response(lstClient,"Procesado correctamente"),HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
