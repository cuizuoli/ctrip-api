/*
 * @(#)FlightSearchType.java $version 2014年1月26日
 *
 * Copyright 2014 NHN China. All rights Reserved.
 * NHN China PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ctrip.enums;

/**
 * nhn ctrip-api
 * com.ctrip.enums.FlightSearchType.java
 * @author CN40101
 * @date 2014年1月26日
 */
public enum FlightSearchType {
	DAN_CHENG("S"),
	WANG_FAN_CHENG("D"),
	LIAN_CHENG("M");
	private final String code;

	private FlightSearchType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
