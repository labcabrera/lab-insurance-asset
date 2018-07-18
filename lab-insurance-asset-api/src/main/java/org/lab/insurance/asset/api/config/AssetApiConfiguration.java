package org.lab.insurance.asset.api.config;

import org.lab.insurance.asset.common.InsuranceCommonConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(InsuranceCommonConfiguration.class)
public class AssetApiConfiguration {

}
