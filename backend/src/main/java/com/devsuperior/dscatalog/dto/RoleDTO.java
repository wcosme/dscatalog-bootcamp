package com.devsuperior.dscatalog.dto;

import java.io.Serializable;

import com.devsuperior.dscatalog.entities.Role;

import lombok.Data;

@Data
public class RoleDTO implements Serializable{	
	private static final long serialVersionUID = -3163121464171012603L;
	
	private Long id;
	private String authority;
	
		
	public RoleDTO(Role entity) {
		id = entity.getId();
		authority = entity.getAuthority();
	}
}
