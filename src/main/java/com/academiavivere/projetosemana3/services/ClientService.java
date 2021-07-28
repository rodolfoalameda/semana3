package com.academiavivere.projetosemana3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academiavivere.projetosemana3.entities.Client;
import com.academiavivere.projetosemana3.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	// GetAll
	public List<Client> findAll() {
		return repository.findAll();
	}

	// GetById
	public Client findById(Integer id) {
		Optional<Client> client = repository.findById(id);
		return client.get();

	}

	// Post
	public Client insert(Client client) {
		return repository.save(client);
	}

	// Delete
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	// Update
	public Client update(Integer id, Client client) {
		Client entity = repository.getOne(id);
		entity.setDataCadastro(client.getDataCadastro());
		entity.setName(client.getName());
		entity.setCpfCnpj(client.getCpfCnpj());
		entity.setAdress(client.getAdress());
		entity.setCity(client.getCity());
		entity.setCountry(client.getCountry());
		entity.setZipCode(client.getZipCode());
		entity.setPhone(client.getPhone());
		entity.setEmail(client.getEmail());
		return repository.save(entity);
	}
	
	public List<Client> findByNameOrCpfCnpjOrCityOrCountry(String name, String cpfCnpj, String city, String country){
		return repository.findByNameOrCpfCnpjOrCityOrCountry(name, cpfCnpj, city, country);
	}

	public Client save(Client client) {
		return repository.save(client);
	}
	
	
}
