package org.lab.insurance.asset.core.model;

import java.time.LocalDateTime;

import org.lab.insurance.asset.core.common.HasId;
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

@Document(collection = "assets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asset implements HasId<String> {

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

	private LocalDateTime fromDate;

	private LocalDateTime toDate;

	@DBRef
	@JsonSerialize(using = HasIdSerializer.class)
	private Currency currency;

	/**
	 * Public constructor using entity identifier.
	 * 
	 * @param id
	 */
	public Asset(String id) {
		this.id = id;
	}

}
