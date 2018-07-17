package org.lab.insurance.asset.core.repository;

import java.io.Serializable;

import org.lab.insurance.asset.core.model.AssetGuaranteePercent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssetGuaranteePercentRepository extends MongoRepository<AssetGuaranteePercent, Serializable> {

}
