package org.lab.insurance.asset.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "currencies")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Currency {

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
