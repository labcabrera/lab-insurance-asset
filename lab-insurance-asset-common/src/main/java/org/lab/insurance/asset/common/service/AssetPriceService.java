package org.lab.insurance.asset.common.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.lab.insurance.asset.common.exception.MissingPrice;
import org.lab.insurance.asset.common.model.AssetPrice;
import org.lab.insurance.asset.common.repository.AssetPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.NonNull;

@Service
public class AssetPriceService {

	@Autowired
	private AssetPriceRepository repository;

	public Optional<AssetPrice> findAtDate(@NonNull String assetId, @NonNull LocalDateTime date) {
		return repository.findAtDate(assetId, date);
	}

	public List<AssetPrice> findAtDate(@NonNull List<String> assetIds, @NonNull LocalDateTime date) {
		// TODO avoid multiple queries
		List<AssetPrice> result = new ArrayList<>();
		assetIds.stream().forEach(assetId -> {
			result.add(repository.findAtDate(assetId, date).orElseThrow(() -> new MissingPrice(assetId, date)));
		});
		return result;
	}

	public List<AssetPrice> findInRange(String assetId, LocalDateTime from, LocalDateTime to) {
		Sort sort = new Sort(Sort.Direction.ASC, "from");
		return repository.findInRange(assetId, from, to, sort);
	}

}
