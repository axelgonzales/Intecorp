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

import com.aws.codestart.projecttemplates.controller.request.ClientRequest;
import com.aws.codestart.projecttemplates.controller.response.KpiClient;
import com.aws.codestart.projecttemplates.controller.response.Response;
import com.aws.codestart.projecttemplates.domain.Client;
import com.aws.codestart.projecttemplates.exception.ClientInsertNullException;
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
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
    	return new ResponseEntity<KpiClient>(kpiClient,HttpStatus.OK); 
    }
    
    @GetMapping("/listclientes")
    public ResponseEntity<List<Client>>  findDocument() {
    	List<Client> lstClient =  this.clientService.findAll();
		if (lstClient == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
    	return new ResponseEntity<List<Client>>(lstClient,HttpStatus.OK); 
    }

}
