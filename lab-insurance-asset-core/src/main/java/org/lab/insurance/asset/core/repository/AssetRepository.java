package org.lab.insurance.asset.core.repository;

import java.util.Optional;

import org.lab.insurance.asset.core.model.Asset;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssetRepository extends MongoRepository<Asset, String> {

	Optional<Asset> findByIsin(String isin);
}
