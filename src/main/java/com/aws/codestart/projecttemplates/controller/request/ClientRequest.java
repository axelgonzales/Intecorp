package com.aws.codestart.projecttemplates.controller.request;


import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.aws.codestart.projecttemplates.domain.Client;

import lombok.Data;

@Data
public class ClientRequest {

	@Valid
	private Client client;
	
}
