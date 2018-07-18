package org.lab.insurance.asset.core.populator;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab.insurance.asset.core.exception.MissingPrice;
import org.lab.insurance.asset.core.model.AssetPrice;
import org.lab.insurance.asset.core.service.AssetPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssetPriceServiceTest {

	@Autowired
	private AssetPriceService service;

	@Test
	public void testFindAtDate() throws Exception {
		LocalDateTime date = LocalDateTime.parse("2010-01-10T10:00:10.042");
		AssetPrice value = service.findAtDate("ASSET01", date).get();
		Assert.assertNotNull(value);
	}

	@Test(expected = NoSuchElementException.class)
	public void testFindAtDateNoValue() {
		LocalDateTime date = LocalDateTime.parse("2000-01-10T10:00:10.042");
		service.findAtDate("ASSET01", date).get();
	}

	@Test
	public void testFindAtDateMultipleAssets() {
		LocalDateTime date = LocalDateTime.parse("2010-01-10T10:00:10.042");
		List<String> assets = Arrays.asList("ASSET01", "ASSET02");
		List<AssetPrice> values = service.findAtDate(assets, date);
		Assert.assertFalse(values.isEmpty());
		Assert.assertTrue(values.size() == 2);
	}

	@Test(expected = MissingPrice.class)
	public void testFindAtDateMultipleAssetsNoValues() {
		LocalDateTime date = LocalDateTime.parse("2000-01-10T10:00:10.042");
		List<String> assets = Arrays.asList("ASSET01", "ASSET02");
		service.findAtDate(assets, date);
	}

	@Test
	public void testFindInRange() {
		LocalDateTime from = LocalDateTime.parse("2010-01-10T10:00:10.042");
		LocalDateTime to = LocalDateTime.parse("2010-01-15T10:00:10.042");
		List<AssetPrice> values = service.findInRange("ASSET01", from, to);
		Assert.assertFalse(values.isEmpty());
	}

	@Configuration
	@EnableMongoRepositories("org.lab.insurance.asset.core.repository")
	@ComponentScan("org.lab.insurance.asset.core")
	@EnableAutoConfiguration
	public static class AssetPriceServiceTestConfig {
	}

}
