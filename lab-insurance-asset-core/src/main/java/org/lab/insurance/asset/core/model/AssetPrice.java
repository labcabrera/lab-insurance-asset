package org.lab.insurance.asset.core.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "assetPrices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetPrice {

	@Id
	private String id;

	private Asset asset;

	private Currency currency;

	private Date priceDate;

	private BigDecimal price;

	private BigDecimal buyPrice;

	private BigDecimal sellPrice;

	private Date generated;

}
