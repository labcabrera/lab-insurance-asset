package org.lab.insurance.asset.api.controller;

import org.lab.insurance.asset.core.model.Currency;
import org.lab.insurance.asset.core.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/currencies")
public class CurrencyController {

	@Autowired
	private CurrencyRepository repository;

	@GetMapping("/{id}")
	public ResponseEntity<Currency> searchById(@PathVariable(value = "id") String id) {
		return repository.findById(id).map(x -> new ResponseEntity<>(x, HttpStatus.OK))
			.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping(value = "/iso3/{iso3}")
	public ResponseEntity<Currency> searchByIso3(@PathVariable(value = "iso3") String isin) {
		return repository.findByIso3(isin).map(x -> new ResponseEntity<>(x, HttpStatus.OK))
			.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public Currency insert(@RequestBody Currency currency) {
		Currency result = repository.insert(currency);
		return result;
	}

}
