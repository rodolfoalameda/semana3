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

import com.academiavivere.projetosemana3.entities.User;
import com.academiavivere.projetosemana3.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Integer id) {
		User user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user) {
		service.insert(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User user) {
		user = service.update(id, user);
		return ResponseEntity.ok().body(user);

	}

	@GetMapping("/search")
	public ResponseEntity<List<User>> findByName(@RequestParam(required = false) String name,
			@RequestParam(required = false) String email) {
		List<User> list = service.findByNameOrEmail(name, email);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Boolean> login (@RequestBody(required = true) User userLogin){
		Boolean login = service.login(userLogin);
		return ResponseEntity.ok().body(login);
	}

}
