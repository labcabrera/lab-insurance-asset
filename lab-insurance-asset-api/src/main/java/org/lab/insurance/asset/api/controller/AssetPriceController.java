package org.lab.insurance.asset.api.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.lab.insurance.asset.common.model.AssetPrice;
import org.lab.insurance.asset.common.service.AssetPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@RestController
@RequestMapping("/v1/asset-prices")
public class AssetPriceController {

	@Autowired
	private AssetPriceService service;

	@PostMapping("/single")
	public ResponseEntity<AssetPrice> findAtDate(@RequestBody SingleAssetPriceRequest request) {
		Optional<AssetPrice> optional = service.findAtDate(request.getAssetId(), request.getDate());
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		return new ResponseEntity<AssetPrice>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/all")
	public List<AssetPrice> findAtDate(@RequestBody MultipleAssetPriceRequest request) {
		List<AssetPrice> result = service.findAtDate(request.getAssetId(), request.getDate());
		return result;
	}

	@Getter
	@Setter
	@ToString
	static final class SingleAssetPriceRequest {

		private String assetId;
		private LocalDateTime date;

	}

	@Getter
	@Setter
	@ToString
	static final class MultipleAssetPriceRequest {

		private List<String> assetId;
		private LocalDateTime date;

	}

}
