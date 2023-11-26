package com.devsuperior.dscatalog.controllers.exceptions;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationError extends StandardError {
	private static final long serialVersionUID = -3883987567916514197L;
	
	private final List<FieldMessage> errors = new ArrayList<>();

	public void addError(String FieldName, String Message) {
		errors.add(new FieldMessage(FieldName, Message));
	}
}

