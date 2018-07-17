package org.lab.insurance.asset.core.repository;

import java.io.Serializable;

import org.lab.insurance.asset.core.model.Currency;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CurrencyRepository extends MongoRepository<Currency, Serializable> {

	Currency findByIso(String isoCode);
}
