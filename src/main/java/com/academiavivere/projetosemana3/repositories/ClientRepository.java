package com.academiavivere.projetosemana3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academiavivere.projetosemana3.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

	List<Client> findByNameOrCpfCnpjOrCityOrCountry(String name, String cpfCnpj, String city, String country);
	
}
