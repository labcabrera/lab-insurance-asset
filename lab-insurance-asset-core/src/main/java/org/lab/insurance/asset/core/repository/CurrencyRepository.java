package org.lab.insurance.asset.core.repository;

import java.io.Serializable;
import java.util.Optional;

import org.lab.insurance.asset.core.model.Currency;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CurrencyRepository extends MongoRepository<Currency, Serializable> {

	Optional<Currency> findByIso3(String isin);
}
