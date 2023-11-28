package com.devsuperior.dscatalog.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name =  "tb_category")
public class Category implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	// Salva no banco o tempo no padrão UTC
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;
	
	// Salva no banco o tempo no padrão UTC
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updatedAt;
	
	@ManyToMany(mappedBy = "categories")
	@ToString.Exclude
	private Set<Product> products = new HashSet<>();
	
		
	@PrePersist
	public void prePersist() {
		createdAt = Instant.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		updatedAt = Instant.now();
	}

}
