package com.devsuperior.dscatalog.controllers.exceptions;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class FieldMessage implements Serializable{	
	private static final long serialVersionUID = 2740060405492453826L;
	
	private String fieldName;
	private String message;
	
	public FieldMessage() {

	}

	public FieldMessage(String fieldName, String message) {
		this.fieldName = fieldName;
		this.message = message;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
