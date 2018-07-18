package org.lab.insurance.asset.common.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.lab.insurance.asset.common.common.HasIdSerializer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "li_asset_assetPrices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AssetPrice {

	@Id
	private String id;

	@DBRef(lazy = true)
	@JsonSerialize(using = HasIdSerializer.class)
	private Asset asset;

	@DBRef(lazy = true)
	@JsonSerialize(using = HasIdSerializer.class)
	private Currency currency;

	private LocalDateTime from;

	private LocalDateTime to;

	private LocalDateTime generated;

	private BigDecimal price;

	private BigDecimal buyPrice;

	private BigDecimal sellPrice;

}
