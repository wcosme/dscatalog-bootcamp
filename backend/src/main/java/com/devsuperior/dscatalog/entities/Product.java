package com.devsuperior.dscatalog.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@Table(name = "tb_product")
@NoArgsConstructor
public class Product implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	private Double price;
	private String imgUrl;
	
	// Salva no banco o tempo no padrão UTC
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant date;
	
	@ManyToMany
	@JoinTable(name = "tb_product_category",
			joinColumns = @JoinColumn(name = "product_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id")		
			)
	@ToString.Exclude
	Set<Category> categories = new HashSet<>();

	public Product(Long id) {
		this.id = id;
	}
}
