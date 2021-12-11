package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.User;
import com.devsuperior.dscatalog.services.validation.UserUpdateValid;

@UserUpdateValid
public class UserUpdateDTO extends UserDTO{
	
	public UserUpdateDTO(User entity) {
		super(entity);
	}

	private static final long serialVersionUID = 1L;	
	
}
