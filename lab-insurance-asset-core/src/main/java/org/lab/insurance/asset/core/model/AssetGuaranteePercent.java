package org.lab.insurance.asset.core.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "guaranteePercents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AssetGuaranteePercent {

	@Id
	private String id;

	@DBRef
	private Asset asset;

	private LocalDateTime from;

	private LocalDateTime to;

	private BigDecimal guaranteePercent;

	/**
	 * Public constructor using entity identifier.
	 * 
	 * @param id
	 */
	public AssetGuaranteePercent(String id) {
		this.id = id;
	}

}
