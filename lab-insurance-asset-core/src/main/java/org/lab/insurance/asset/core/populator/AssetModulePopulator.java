package org.lab.insurance.asset.core.populator;

import java.io.File;
import java.util.List;

import org.lab.insurance.asset.core.model.Asset;
import org.lab.insurance.asset.core.model.Currency;
import org.lab.insurance.asset.core.repository.AssetRepository;
import org.lab.insurance.asset.core.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AssetModulePopulator {

	@Autowired
	private CurrencyRepository currencyRepository;

	@Autowired
	private AssetRepository assetRepository;

	public boolean isInitialized() {
		return assetRepository.count() > 0;
	}

	public void initialize() {
		log.info("Loading bootstrap module data");
		List<Currency> currencies = loadObjectList(Currency.class, "bootstrap/currencies.csv");
		currencyRepository.saveAll(currencies);

		List<Asset> assets = loadObjectList(Asset.class, "bootstrap/assets.csv");
		assetRepository.saveAll(assets);
	}

	public <T> List<T> loadObjectList(Class<T> type, String fileName) {
		try {
			CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
			CsvMapper mapper = new CsvMapper();
			File file = new ClassPathResource(fileName).getFile();
			MappingIterator<T> readValues = mapper.readerFor(type).with(bootstrapSchema).readValues(file);
			return readValues.readAll();
		}
		catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

}
