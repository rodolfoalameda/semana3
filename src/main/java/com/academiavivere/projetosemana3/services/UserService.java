package com.academiavivere.projetosemana3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academiavivere.projetosemana3.entities.User;
import com.academiavivere.projetosemana3.repositories.UserRespository;

@Service
public class UserService {

	@Autowired
	private UserRespository repository;

	// GetAll
	public List<User> findAll() {
		return repository.findAll();
	}

	// GetById
	public User findById(Integer id) {
		Optional<User> user = repository.findById(id);
		return user.get();
	}

	// Post
	public User insert(User user) {
		return repository.save(user);
	}

	// Delete
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	// Update
	public User update(Integer id, User user) {
		User entity = repository.getOne(id);
		entity.setDataCadastro(user.getDataCadastro());
		entity.setName(user.getName());
		entity.setLogin(user.getLogin());
		entity.setPhone(user.getPhone());
		entity.setEmail(user.getEmail());
		entity.setProfile(user.getProfile());
		entity.setStatus(user.getStatus());
		return repository.save(entity);

	}

	public List<User> findByNameOrEmail(String name, String email) {
		return repository.findByNameOrEmail(name, email);
	}

	public boolean login(User userLogin) {
		User user = repository.findByLogin(userLogin.getLogin());
		return user.getPassword().equals(userLogin.getPassword());
	}

}
