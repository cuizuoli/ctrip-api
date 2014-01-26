/*
 * @(#)FlightSearchRequest.java $version 2014年1月26日
 *
 * Copyright 2014 NHN China. All rights Reserved.
 * NHN China PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ctrip.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * nhn ctrip-api
 * com.ctrip.model.FlightSearchRequest.java
 * @author CN40101
 * @date 2014年1月26日
 */
public class FlightSearchRequest {
	private String searchType;
	private Routes routes;
	private String sendTicketCity;
	private String isSimpleResponse;
	private String isLowestPrice;
	private String priceTypeOptions;
	private String productTypeOptions;
	private String classgrade;
	private String orderBy;
	private String direction;

	@XmlElement(name = "SearchType")
	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	@XmlElement(name = "Routes")
	public Routes getRoutes() {
		return routes;
	}

	public void setRoutes(Routes routes) {
		this.routes = routes;
	}

	@XmlElement(name = "SendTicketCity")
	public String getSendTicketCity() {
		return sendTicketCity;
	}

	public void setSendTicketCity(String sendTicketCity) {
		this.sendTicketCity = sendTicketCity;
	}

	@XmlElement(name = "IsSimpleResponse")
	public String getIsSimpleResponse() {
		return isSimpleResponse;
	}

	public void setIsSimpleResponse(String isSimpleResponse) {
		this.isSimpleResponse = isSimpleResponse;
	}

	@XmlElement(name = "IsLowestPrice")
	public String getIsLowestPrice() {
		return isLowestPrice;
	}

	public void setIsLowestPrice(String isLowestPrice) {
		this.isLowestPrice = isLowestPrice;
	}

	@XmlElement(name = "PriceTypeOptions")
	public String getPriceTypeOptions() {
		return priceTypeOptions;
	}

	public void setPriceTypeOptions(String priceTypeOptions) {
		this.priceTypeOptions = priceTypeOptions;
	}

	@XmlElement(name = "ProductTypeOptions")
	public String getProductTypeOptions() {
		return productTypeOptions;
	}

	public void setProductTypeOptions(String productTypeOptions) {
		this.productTypeOptions = productTypeOptions;
	}

	@XmlElement(name = "Classgrade")
	public String getClassgrade() {
		return classgrade;
	}

	public void setClassgrade(String classgrade) {
		this.classgrade = classgrade;
	}

	@XmlElement(name = "OrderBy")
	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	@XmlElement(name = "Direction")
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
}
