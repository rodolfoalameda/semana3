package com.academiavivere.projetosemana3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academiavivere.projetosemana3.entities.User;

public interface UserRespository extends JpaRepository<User, Integer> {

	public List<User> findByNameOrEmail(String name, String email);
	
	public User findByLogin(String login);

}
