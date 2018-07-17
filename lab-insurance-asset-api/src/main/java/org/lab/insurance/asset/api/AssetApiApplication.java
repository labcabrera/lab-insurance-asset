package org.lab.insurance.asset.api;

import org.lab.insurance.asset.core.populator.AssetModulePopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssetApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AssetApiApplication.class, args);
	}

	@Autowired
	private AssetModulePopulator populator;

	@Override
	public void run(String... args) throws Exception {
		if (!populator.isInitialized()) {
			populator.initialize();
		}
	}

}
