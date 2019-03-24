package com.aws.codestart.projecttemplates.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data	
@AllArgsConstructor
@NoArgsConstructor
public class Response {
	
	private Object data;
	private String message;
	
}
