package org.lab.insurance.asset.common.exception;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
@SuppressWarnings("serial")
public class MissingPrice extends RuntimeException {

	private final String assetId;
	private final LocalDateTime date;

	public MissingPrice(String assetId, LocalDateTime date) {
		super("Missing asset " + assetId + " price at " + date);
		this.assetId = assetId;
		this.date = date;
	}

}
