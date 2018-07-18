package org.lab.insurance.asset.common.repository;

import java.util.Optional;

import org.lab.insurance.asset.common.model.Currency;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CurrencyRepository extends MongoRepository<Currency, String> {

	Optional<Currency> findByIso3(String isin);
}
