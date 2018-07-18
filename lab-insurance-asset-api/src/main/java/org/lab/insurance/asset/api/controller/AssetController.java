package org.lab.insurance.asset.api.controller;

import org.lab.insurance.asset.common.model.Asset;
import org.lab.insurance.asset.common.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/assets")
public class AssetController {

	@Autowired
	private AssetRepository repository;

	@GetMapping
	public Page<Asset> search( //@formatter:off
			@RequestParam(name = "p", defaultValue = "0") Integer page,
			@RequestParam(name = "s", defaultValue = "10") Integer size) { //@formatter:on
		Example<Asset> example = Example.of(new Asset());
		// TODO filter predicates
		return repository.findAll(example, PageRequest.of(page, size));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Asset> searchById(@PathVariable(value = "id") String id) {
		return repository.findById(id).map(x -> new ResponseEntity<>(x, HttpStatus.OK))
			.orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}

	@GetMapping("/isin/{isin}")
	public ResponseEntity<Asset> searchByIsin(@PathVariable(value = "isin") String isin) {
		return repository.findByIsin(isin).map(x -> new ResponseEntity<>(x, HttpStatus.OK))
			.orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}

	@PostMapping
	public Asset insert(@RequestBody Asset asset) {
		return repository.insert(asset);
	}

	@PatchMapping
	public Asset update(@RequestBody Asset asset) {
		return repository.save(asset);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		repository.deleteById(id);
	}

}
