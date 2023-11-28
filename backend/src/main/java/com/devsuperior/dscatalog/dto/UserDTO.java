package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class UserDTO implements Serializable{	
	private static final long serialVersionUID = 5093647784358149084L;
	
	private Long id;
	
	@NotBlank(message = "Campo obrigatório")
	private String firstName;
	private String lastName;
	
	@Email(message = "Favor, informar um e-mail valido.")
	private String email;
	
	Set<RoleDTO> roles = new HashSet<>(); 
	
		
	public UserDTO(User entity) {
		id = entity.getId();
		firstName = entity.getFirstName();
		lastName = entity.getLastName();
		email = entity.getEmail();
		entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
	}		
}
