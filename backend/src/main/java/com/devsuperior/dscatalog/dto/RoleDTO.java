package com.devsuperior.dscatalog.dto;

import java.io.Serializable;

import com.devsuperior.dscatalog.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO implements Serializable{	
	private static final long serialVersionUID = -3163121464171012603L;
	
	private Long id;
	private String authority;
	
		
	public RoleDTO(Role entity) {
		id = entity.getId();
		authority = entity.getAuthority();
	}
}
