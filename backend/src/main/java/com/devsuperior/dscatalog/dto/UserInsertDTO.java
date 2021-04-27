package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.services.validation.UserInsertValid;

import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
@UserInsertValid
public class UserInsertDTO extends UserDTO{

	private static final long serialVersionUID = 1L;

	private String password;
	
}
