/*
 * @(#)FlightSearchRequestXml.java $version 2014年4月18日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ctrip.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DaLian Software ctrip-api
 * com.ctrip.model.FlightSearchRequestXml.java
 * @author cuizuoli
 * @date 2014年4月18日
 */
@XmlRootElement(name = "Request")
public class FlightSearchRequestBody {
	private Header header;
	private FlightSearchRequest flightSearchRequest;

	@XmlElement(name = "Header")
	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	@XmlElement(name = "FlightSearchRequest")
	public FlightSearchRequest getFlightSearchRequest() {
		return flightSearchRequest;
	}

	public void setFlightSearchRequest(FlightSearchRequest flightSearchRequest) {
		this.flightSearchRequest = flightSearchRequest;
	}
}
