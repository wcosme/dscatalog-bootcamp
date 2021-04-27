package com.devsuperior.dscatalog.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@Size(min = 5, max = 20, message = "O tamanho tem que ser entre 5 e 20 caracteres.")
	@NotBlank(message = "Campo obrigatório")
	private String name;
	
	@NotBlank(message = "Campo requerido.")
	private String description;
	
	@Positive(message = "Preço deve ser um valor positivo.")
	private Double price;
	private String imgUrl;
	
	@PastOrPresent(message = "A data não pode ser uma data futura.")
	private Instant date;			
			
	private List<CategoryDTO> categories = new ArrayList<>();
	
	
	public ProductDTO(Product entity) {
		super();
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.price = entity.getPrice();
		this.imgUrl = entity.getImgUrl();
		this.date = entity.getDate();
	}
	
	public ProductDTO(Product entity, Set<Category> categories) {
		this(entity);		
		categories.forEach(cat -> this.categories.add(new CategoryDTO(cat)));
	}
}
