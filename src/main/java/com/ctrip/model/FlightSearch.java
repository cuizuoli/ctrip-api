/*
 * @(#)FlightSearch.java $version 2014年1月26日
 *
 * Copyright 2014 NHN China. All rights Reserved.
 * NHN China PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ctrip.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * nhn ctrip-api
 * com.ctrip.model.FlightSearch.java
 * @author CN40101
 * @date 2014年1月26日
 */
@XmlRootElement(name = "Request")
public class FlightSearch {
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
