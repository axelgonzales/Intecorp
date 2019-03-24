package com.intercorp.controller.request;


import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.intercorp.domain.Client;

import lombok.Data;

@Data
public class ClientRequest {

	@Valid
	private Client client;
	
}
