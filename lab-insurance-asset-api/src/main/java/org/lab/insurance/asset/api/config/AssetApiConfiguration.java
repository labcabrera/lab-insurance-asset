package org.lab.insurance.asset.api.config;

import org.lab.insurance.asset.core.populator.AssetModulePopulator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableMongoRepositories("org.lab.insurance.asset.core.repository")
@ComponentScan("org.lab.insurance.asset.core.service")
public class AssetApiConfiguration {

	@Bean
	public AssetModulePopulator assetPopulator() {
		return new AssetModulePopulator();
	}

}
