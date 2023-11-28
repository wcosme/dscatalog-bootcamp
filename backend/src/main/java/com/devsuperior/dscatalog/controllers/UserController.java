package com.devsuperior.dscatalog.controllers;

import com.devsuperior.dscatalog.dto.UserDTO;
import com.devsuperior.dscatalog.dto.UserInsertDTO;
import com.devsuperior.dscatalog.dto.UserUpdateDTO;
import com.devsuperior.dscatalog.services.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<Page<UserDTO>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,			
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "firstName") String orderBy
			){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Page<UserDTO> list = service.findAllPaged(pageRequest);		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id){			
		UserDTO dto = service.findUserById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> insertUser(@Valid @RequestBody UserInsertDTO dto){		
		UserDTO newDto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newDto.getId()).toUri();
		return ResponseEntity.created(uri).body(newDto);		
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateDTO dto){
		UserDTO newDto = service.update(id, dto);				
		return ResponseEntity.ok().body(newDto);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<UserDTO> deleteUser(@PathVariable Long id){		
		service.delete(id);				
		return ResponseEntity.noContent().build();
		
	}
	
	@PostMapping(value = "/v2")
	public ResponseEntity<UserDTO> findByIdV2(@RequestBody Long id){		
		UserDTO dto = service.findUserById(id);
		return ResponseEntity.ok().body(dto);
	}
}
