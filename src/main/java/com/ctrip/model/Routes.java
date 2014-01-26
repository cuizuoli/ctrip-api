/*
 * @(#)Routes.java $version 2014年1月26日
 *
 * Copyright 2014 NHN China. All rights Reserved.
 * NHN China PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ctrip.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * nhn ctrip-api
 * com.ctrip.model.Routes.java
 * @author CN40101
 * @date 2014年1月26日
 */
public class Routes {
	private FlightRoute flightRoute;

	@XmlElement(name = "FlightRoute")
	public FlightRoute getFlightRoute() {
		return flightRoute;
	}

	public void setFlightRoute(FlightRoute flightRoute) {
		this.flightRoute = flightRoute;
	}
}
