package org.lab.insurance.asset.api.controller;

import org.lab.insurance.asset.core.model.Asset;
import org.lab.insurance.asset.core.repository.AssetRepository;
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
@RequestMapping(value = "/v1/assets")
public class AssetController {

	@Autowired
	private AssetRepository repository;

	@GetMapping("/{id}")
	public ResponseEntity<Asset> searchById(@PathVariable(value = "id") String id) {
		return repository.findById(id).map(x -> new ResponseEntity<>(x, HttpStatus.OK))
			.orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}

	@GetMapping(value = "/isin/{isin}")
	public ResponseEntity<Asset> searchByIsin(@PathVariable(value = "isin") String isin) {
		return repository.findByIsin(isin).map(x -> new ResponseEntity<>(x, HttpStatus.OK))
			.orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}

	@PostMapping
	public Asset insert(@RequestBody Asset asset) {
		Asset result = repository.insert(asset);
		return result;
	}

}
