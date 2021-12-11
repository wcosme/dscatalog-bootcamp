package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.User;
import com.devsuperior.dscatalog.services.validation.UserInsertValid;

import lombok.Getter;
@Getter
@UserInsertValid
public class UserInsertDTO extends UserDTO{

	public UserInsertDTO(User entity) {
		super(entity);
	}

	private static final long serialVersionUID = 1L;

	private String password;
	
}
