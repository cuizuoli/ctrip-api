/*
 * @(#)Flight.java $version 2014年1月25日
 *
 * Copyright 2014 Vip Journey. All rights Reserved.
 * Vip Journey PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ctrip.api;

import java.io.FileNotFoundException;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.StringUtils;
import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;

import com.ctrip.enums.FlightSearchType;
import com.ctrip.model.FlightRoute;
import com.ctrip.model.FlightSearchRequest;
import com.ctrip.model.FlightSearchRequestBody;
import com.ctrip.model.FlightSearchResponseBody;
import com.ctrip.model.Routes;
import com.ctrip.model.SoapRequest;
import com.ctrip.model.SoapResponse;

/**
 * vip-journey ctrip-api
 * com.ctrip.api.Flight.java
 * @author cuizuoli
 * @date 2014年1月25日
 */
@Slf4j
@Component
public class Flight {

	private final static String OTA_FLIGHT_SEARCH = "http://openapi.ctrip.com/Flight/DomesticFlight/OTA_FlightSearch.asmx";

	@Resource
	private CtripApiTemplate ctripApiTemplate;

	@Resource
	private Jaxb2Marshaller jaxb2Marshaller;

	public String search() throws XmlMappingException, FileNotFoundException {
		// FlightRoute
		FlightRoute flightRoute = new FlightRoute();
		flightRoute.setDepartCity("SHA");
		flightRoute.setArriveCity("BJS");
		flightRoute.setDepartDate("2014-04-20");
		flightRoute.setAirlineDibitCode("CA");
		flightRoute.setDepartPort("");
		flightRoute.setArrivePort("");
		flightRoute.setEarliestDepartTime("2014-04-20T08:00:00");
		flightRoute.setLatestDepartTime("2014-04-20T12:00:00");
		// Routes
		Routes routes = new Routes();
		routes.setFlightRoute(flightRoute);
		// FlightSearchRequest
		FlightSearchRequest flightSearchRequest = new FlightSearchRequest();
		flightSearchRequest.setSearchType(FlightSearchType.DAN_CHENG.getCode());
		flightSearchRequest.setRoutes(routes);
		flightSearchRequest.setSendTicketCity("SHA");
		flightSearchRequest.setIsSimpleResponse("false");
		flightSearchRequest.setIsLowestPrice("false");
		flightSearchRequest.setPriceTypeOptions("NormalPrice");
		flightSearchRequest.setProductTypeOptions("Normal");
		flightSearchRequest.setClassgrade("F");
		flightSearchRequest.setOrderBy("DepartTime");
		flightSearchRequest.setDirection("ASC");
		// FlightSearch
		FlightSearchRequestBody flightSearchRequestBody = new FlightSearchRequestBody();
		flightSearchRequestBody.setHeader(ctripApiTemplate.getHeader());
		flightSearchRequestBody.setFlightSearchRequest(flightSearchRequest);
		StringResult requestBodyResult = new StringResult();
		jaxb2Marshaller.marshal(flightSearchRequestBody, requestBodyResult);
		// SoapRequest
		SoapRequest soapRequest = new SoapRequest();
		soapRequest.setRequest(requestBodyResult.toString());
		SoapResponse soapResponse = ctripApiTemplate.send(OTA_FLIGHT_SEARCH, soapRequest);
		// FlightSearchResponseBody
		String responseContent = soapResponse.getResponse();
		responseContent = StringUtils.replace(responseContent, CtripApiTemplate.SOAP_RESPONSE_DECLARE, StringUtils.EMPTY);
		FlightSearchResponseBody flightSearchResponseBody = (FlightSearchResponseBody)jaxb2Marshaller.unmarshal(new StringSource(responseContent));
		return flightSearchResponseBody.getFlightSearchResponse();
	}

}
