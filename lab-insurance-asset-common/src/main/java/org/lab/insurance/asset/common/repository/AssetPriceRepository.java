package org.lab.insurance.asset.common.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.lab.insurance.asset.common.model.AssetPrice;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AssetPriceRepository extends MongoRepository<AssetPrice, String> {

	@Query("{ 'asset.id': ?0, 'from': { '$lte': ?1 }, 'to': { '$gte': ?1 } }")
	Optional<AssetPrice> findAtDate(String assetId, LocalDateTime date);

	@Query("{ 'asset.id': ?0, 'from': { '$gte': ?1 }, 'to': { '$lte': ?2 } }")
	List<AssetPrice> findInRange(String assetId, LocalDateTime from, LocalDateTime to, Sort sort);

}
