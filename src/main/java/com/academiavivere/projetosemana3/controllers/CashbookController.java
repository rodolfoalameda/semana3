package com.academiavivere.projetosemana3.controllers;

import java.text.ParseException;
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

import com.academiavivere.projetosemana3.entities.Cashbook;
import com.academiavivere.projetosemana3.services.CashbookService;

@RestController
@RequestMapping("/cashbooks")
public class CashbookController {

	@Autowired
	private CashbookService service;

	@GetMapping
	public ResponseEntity<List<Cashbook>> findAll() {
		List<Cashbook> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cashbook> findById(@PathVariable Integer id) {
		Cashbook cashbook = service.findById(id);
		return ResponseEntity.ok().body(cashbook);
	}

	@PostMapping
	public ResponseEntity<Cashbook> update(@RequestBody Cashbook cashbook) {
		service.insert(cashbook);
		return new ResponseEntity<Cashbook>(HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cashbook> update(@PathVariable Integer id, @RequestBody Cashbook cashbook) {
		cashbook = service.update(id, cashbook);
		return ResponseEntity.ok().body(cashbook);
	}

	@GetMapping("/filter")
	public ResponseEntity<List<Cashbook>> findByDataLancamento(@RequestParam Long dataLancamento,
			@RequestParam Long dataFinal) throws ParseException {
		List<Cashbook> list = service.findByDataLancamento(dataLancamento, dataFinal);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/filterId")
	public ResponseEntity<List<Cashbook>> findByClientId(@RequestParam Integer id) {
		List<Cashbook> list = service.findByClientId(id);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/filterDate")
	public ResponseEntity<List<Cashbook>> findByClientIdAndDataLancamentoBetween(@RequestParam Integer id,
			@RequestParam Long dataLancamento, @RequestParam Long dataFinal) {
		List<Cashbook> list = service.findByClientIdAndDataLancamentoBetween(id, dataLancamento, dataFinal);
		return ResponseEntity.ok().body(list);
	}
}
