package org.lab.insurance.asset.core.populator;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
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
	public void testFindAtDate() {
		LocalDateTime date = LocalDateTime.parse("2010-01-10T10:00:10.042");
		AssetPrice value = service.findAtDate("ASSET01", date);
		Assert.assertNotNull(value);
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
