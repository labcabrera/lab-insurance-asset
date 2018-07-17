package org.lab.insurance.asset.core.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "assets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asset {

	public enum AssetType {
		FIM, GUARANTEE, INTERNAL_FUND, CASH;
	}

	@Id
	private String id;

	private String isin;

	private String name;

	private String shortName;

	private AssetType type;

	private Integer decimals;

	private Date fromDate;

	private Date toDate;

	@DBRef
	private Currency currency;

	public Asset(String isin) {
		this.isin = isin;
	}

}
