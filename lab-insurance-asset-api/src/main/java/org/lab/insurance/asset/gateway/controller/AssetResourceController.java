package org.lab.insurance.asset.gateway.controller;

import java.util.Optional;

import org.lab.insurance.asset.core.model.Asset;
import org.lab.insurance.asset.core.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hm/search")
public class AssetResourceController {

	@Autowired
	private AssetRepository repository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Asset> searchById(@PathVariable(value = "id") String id) {
		Optional<Asset> optional = repository.findById(id);
		if (!optional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(optional.get(), HttpStatus.OK);
	}
}
