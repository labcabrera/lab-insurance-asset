package org.lab.insurance.asset.core.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.lab.insurance.asset.core.common.HasIdSerializer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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

	@DBRef
	@JsonSerialize(using = HasIdSerializer.class)
	private Asset asset;

	@DBRef
	@JsonSerialize(using = HasIdSerializer.class)
	private Currency currency;

	private LocalDateTime priceDateFrom;

	private LocalDateTime priceDateTo;

	private LocalDateTime generated;

	private BigDecimal price;

	private BigDecimal buyPrice;

	private BigDecimal sellPrice;

}
