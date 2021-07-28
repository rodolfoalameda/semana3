package com.academiavivere.projetosemana3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.academiavivere.projetosemana3.entities.Client;
import com.academiavivere.projetosemana3.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientService service;

	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		List<Client> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Client> findById(@PathVariable Integer id) {
		Client client = service.findById(id);
		return ResponseEntity.ok().body(client);
	}

	@PostMapping
	public ResponseEntity<Client> insert(@RequestBody Client client) {
		service.insert(client);
		return new ResponseEntity<Client>(HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Client> update(@PathVariable Integer id, @RequestBody Client client) {
		client = service.update(id, client);
		return ResponseEntity.ok().body(client);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Client>> findByNameOrCpfCnpjOrCityOrCoutry(@RequestParam(required = false) String name,
			@RequestParam(required = false) String cpfCnpj, @RequestParam(required = false) String city,
			@RequestParam(required = false) String country) {
		List<Client> list = service.findByNameOrCpfCnpjOrCityOrCountry(name, cpfCnpj, city, country);
		return ResponseEntity.ok().body(list);
	}
}
