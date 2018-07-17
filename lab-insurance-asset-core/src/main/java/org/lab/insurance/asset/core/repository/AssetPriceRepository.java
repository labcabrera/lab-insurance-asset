package org.lab.insurance.asset.core.repository;

import java.io.Serializable;

import org.lab.insurance.asset.core.model.AssetPrice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssetPriceRepository extends MongoRepository<AssetPrice, Serializable> {

}
