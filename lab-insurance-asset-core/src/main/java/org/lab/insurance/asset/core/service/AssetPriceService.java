package org.lab.insurance.asset.core.service;

import java.time.LocalDateTime;
import java.util.List;

import org.lab.insurance.asset.core.model.AssetPrice;
import org.lab.insurance.asset.core.repository.AssetPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetPriceService {

	@Autowired
	private AssetPriceRepository repository;

	public AssetPrice findAtDate(String assetId, LocalDateTime date) {
		return repository.findAtDate(assetId, date);
	}

	public List<AssetPrice> findInRange(String assetId, LocalDateTime from, LocalDateTime to) {
		return repository.findInRange(assetId, from, to);
	}

}
