/*
 * @(#)FlightRoute.java $version 2014年1月26日
 *
 * Copyright 2014 NHN China. All rights Reserved.
 * NHN China PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ctrip.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * nhn ctrip-api
 * com.ctrip.model.FlightRoute.java
 * @author CN40101
 * @date 2014年1月26日
 */
public class FlightRoute {
	private String departCity;
	private String arriveCity;
	private String departDate;
	private String airlineDibitCode;
	private String departPort;
	private String arrivePort;
	private String earliestDepartTime;
	private String latestDepartTime;

	@XmlElement(name = "DepartCity")
	public String getDepartCity() {
		return departCity;
	}

	public void setDepartCity(String departCity) {
		this.departCity = departCity;
	}

	@XmlElement(name = "ArriveCity")
	public String getArriveCity() {
		return arriveCity;
	}

	public void setArriveCity(String arriveCity) {
		this.arriveCity = arriveCity;
	}

	@XmlElement(name = "DepartDate")
	public String getDepartDate() {
		return departDate;
	}

	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}

	@XmlElement(name = "AirlineDibitCode")
	public String getAirlineDibitCode() {
		return airlineDibitCode;
	}

	public void setAirlineDibitCode(String airlineDibitCode) {
		this.airlineDibitCode = airlineDibitCode;
	}

	@XmlElement(name = "DepartPort")
	public String getDepartPort() {
		return departPort;
	}

	public void setDepartPort(String departPort) {
		this.departPort = departPort;
	}

	@XmlElement(name = "ArrivePort")
	public String getArrivePort() {
		return arrivePort;
	}

	public void setArrivePort(String arrivePort) {
		this.arrivePort = arrivePort;
	}

	@XmlElement(name = "EarliestDepartTime")
	public String getEarliestDepartTime() {
		return earliestDepartTime;
	}

	public void setEarliestDepartTime(String earliestDepartTime) {
		this.earliestDepartTime = earliestDepartTime;
	}

	@XmlElement(name = "LatestDepartTime")
	public String getLatestDepartTime() {
		return latestDepartTime;
	}

	public void setLatestDepartTime(String latestDepartTime) {
		this.latestDepartTime = latestDepartTime;
	}
}
