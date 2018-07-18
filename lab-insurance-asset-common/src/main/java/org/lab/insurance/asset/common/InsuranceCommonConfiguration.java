package org.lab.insurance.asset.common;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan
@EnableMongoRepositories("org.lab.insurance.asset.common.repository")
@EnableAutoConfiguration
public class InsuranceCommonConfiguration {

}
