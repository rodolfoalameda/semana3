package com.academiavivere.projetosemana3.services;

import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academiavivere.projetosemana3.entities.Cashbook;
import com.academiavivere.projetosemana3.entities.Client;
import com.academiavivere.projetosemana3.repositories.CashbookRepository;

@Service
public class CashbookService {

	@Autowired
	private ClientService clientService;

	@Autowired
	private CashbookRepository repository;

	// GetAll
	public List<Cashbook> findAll() {
		return repository.findAll();
	}

	// GetById
	public Cashbook findById(Integer id) {
		Optional<Cashbook> cashbook = repository.findById(id);
		return cashbook.get();
	}

	// Post
	public Cashbook insert(Cashbook cashbook) {
		Client client = clientService.findById(cashbook.getClient().getId());

		if (cashbook.getType() == 'C') {
			client.setBalance(client.getBalance() + cashbook.getValue());

		} else {
			client.setBalance(client.getBalance() - cashbook.getValue());

		}
		clientService.save(client);
		return repository.save(cashbook);
	}

	// Delete
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	// Update
	public Cashbook update(Integer id, Cashbook cashbook) {
		Cashbook entity = repository.getOne(id);
		entity.setDataLancamento(cashbook.getDataLancamento());
		entity.setDescricao(cashbook.getDescricao());
		entity.setType(cashbook.getType());
		entity.setValue(cashbook.getValue());
		entity.setClient(cashbook.getClient());
		return repository.save(entity);
	}

	public List<Cashbook> findByDataLancamento(Long dataLancamento, Long dataFinal) throws ParseException {
		return repository.findByDataLancamentoBetween(Date.from(Instant.ofEpochMilli(dataLancamento)),
				Date.from(Instant.ofEpochMilli(dataFinal)));
	}

	public List<Cashbook> findByClientId(Integer id) {
		return repository.findByClientId(id);
	}

	public List<Cashbook> findByClientIdAndDataLancamentoBetween(Integer id, Long dataLancamento, Long dataFinal) {
		return repository.findByClientIdAndDataLancamentoBetween(id, Date.from(Instant.ofEpochMilli(dataLancamento)),
				Date.from(Instant.ofEpochMilli(dataFinal)));
	}
}
