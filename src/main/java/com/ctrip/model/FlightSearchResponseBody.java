/*
 * @(#)FlightSearchResponseBody.java $version 2014年4月18日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ctrip.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DaLian Software ctrip-api
 * com.ctrip.model.FlightSearchResponseBody.java
 * @author cuizuoli
 * @date 2014年4月18日
 */
@XmlRootElement(name = "Response")
public class FlightSearchResponseBody {
	private String flightSearchResponse;

	@XmlElement(name = "FlightSearchResponse")
	public String getFlightSearchResponse() {
		return flightSearchResponse;
	}

	public void setFlightSearchResponse(String flightSearchResponse) {
		this.flightSearchResponse = flightSearchResponse;
	}
}
