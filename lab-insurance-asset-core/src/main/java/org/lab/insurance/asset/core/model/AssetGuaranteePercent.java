package org.lab.insurance.asset.core.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "guaranteePercents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetGuaranteePercent {

	@Id
	private String id;

	@DBRef
	private Asset asset;

	private Date from;
	private Date to;
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
