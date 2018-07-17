package org.lab.insurance.asset.core.populator;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.lab.insurance.asset.core.model.Asset;
import org.lab.insurance.asset.core.model.AssetPrice;
import org.lab.insurance.asset.core.model.Currency;
import org.lab.insurance.asset.core.repository.AssetPriceRepository;
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

	@Autowired
	private AssetPriceRepository assetPriceRepository;

	public boolean isInitialized() {
		// TODO
		assetRepository.deleteAll();

		return assetRepository.count() > 0;
	}

	public void initialize() {
		log.info("Loading bootstrap module data");
		List<Currency> currencies = loadObjectList(Currency.class, "bootstrap/currencies.csv");
		currencyRepository.saveAll(currencies);

		List<Asset> assets = loadObjectList(Asset.class, "bootstrap/assets.csv");
		assetRepository.saveAll(assets);

		LocalDateTime from = LocalDateTime.parse("2010-01-01T05:06:07.150Z", DateTimeFormatter.ISO_DATE_TIME);
		LocalDateTime to = LocalDateTime.parse("2018-12-31T00:00:00.000Z", DateTimeFormatter.ISO_DATE_TIME);

		Asset asset = assetRepository.findById("ASSET01").get();
		populateMockPrices(asset, from, to, new BigDecimal("1000"), new BigDecimal("0.1"));

	}

	private <T> List<T> loadObjectList(Class<T> type, String fileName) {
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

	private void populateMockPrices(Asset asset, LocalDateTime dateFrom, LocalDateTime dateTo, BigDecimal initialPrice,
		BigDecimal inc) {
		long t0 = System.currentTimeMillis();
		LocalDateTime tmpDateFrom = dateFrom;
		LocalDateTime tmpDateTo;
		BigDecimal tmpPrice = initialPrice;
		List<AssetPrice> prices = new ArrayList<>();
		LocalDateTime now = LocalDateTime.now();
		do {
			tmpDateTo = tmpDateFrom.with(LocalTime.MAX);
			AssetPrice price = new AssetPrice();
			price.setAsset(asset);
			price.setPrice(tmpPrice);
			price.setSellPrice(tmpPrice);
			price.setBuyPrice(tmpPrice);
			price.setPriceDateFrom(tmpDateFrom);
			price.setPriceDateTo(tmpDateTo);
			price.setCurrency(new Currency("EUR"));
			price.setGenerated(now);
			tmpDateFrom = tmpDateFrom.plusDays(1);
			tmpPrice = tmpPrice.add(inc);
			prices.add(price);
		}
		while (tmpDateTo.isBefore(dateTo));
		assetPriceRepository.saveAll(prices);
		log.info("Inserted {} mock prices for asset {} ({} ms)", prices.size(), asset.getId(),
			System.currentTimeMillis() - t0);
	}

}
