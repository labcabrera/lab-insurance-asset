package org.lab.insurance.asset.common.model;

import org.lab.insurance.asset.common.common.HasId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "li_asset_currencies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Currency implements HasId<String> {

	@Id
	private String id;

	@NonNull
	private String iso3;

	private String name;

	/**
	 * Public constructor
	 * @param id
	 */
	public Currency(String id) {
		this.id = id;
	}

}
