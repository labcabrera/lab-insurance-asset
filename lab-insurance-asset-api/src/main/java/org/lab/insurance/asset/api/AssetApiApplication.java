package org.lab.insurance.asset.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableMongoRepositories("org.lab.insurance.asset.core.repository")
public class AssetApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssetApiApplication.class, args);
	}

}
