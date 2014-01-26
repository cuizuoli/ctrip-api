/*
 * @(#)ApiTest.java $version 2014年1月26日
 *
 * Copyright 2014 NHN China. All rights Reserved.
 * NHN China PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ctrip.api;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.ctrip.api.test.AbstractTest;

/**
 * nhn ctrip-api
 * com.ctrip.api.ApiTest.java
 * @author CN40101
 * @date 2014年1月26日
 */
public class ApiTest extends AbstractTest {

	@Value("#{ctripProperties['ctrip.apiKey']}")
	private String apiKey;

	@Value("#{ctripProperties['ctrip.sid']}")
	private String sid;

	@Value("#{ctripProperties['ctrip.allianceId']}")
	private String allianceId;

	@Resource
	private Jaxb2Marshaller jaxb2Marshaller;

	@Resource
	private WebServiceTemplate webServiceTemplate;

	@Test
	public void test() throws IOException {
		//		String timestamp = SignatureUtils.getTimestamp();
		//		String requestType = "OTA_FlightSearch";
		//		// Header
		//		Header header = new Header();
		//		header.setAllianceId(allianceId);
		//		header.setSid(sid);
		//		header.setTimestamp(timestamp);
		//		header.setRequestType(requestType);
		//		header.setSignature(SignatureUtils.getSignature(timestamp, allianceId, apiKey, sid, requestType));
		//		// FlightRoute
		//		FlightRoute flightRoute = new FlightRoute();
		//		flightRoute.setDepartCity("SHA");
		//		flightRoute.setArriveCity("BJS");
		//		flightRoute.setDepartDate("2014-01-27");
		//		flightRoute.setAirlineDibitCode("CA");
		//		flightRoute.setDepartPort("");
		//		flightRoute.setArrivePort("");
		//		flightRoute.setEarliestDepartTime("2013-01-27T08:00:00");
		//		flightRoute.setLatestDepartTime("2013-01-27T12:00:00");
		//		// Routes
		//		Routes routes = new Routes();
		//		routes.setFlightRoute(flightRoute);
		//		// FlightSearchRequest
		//		FlightSearchRequest flightSearchRequest = new FlightSearchRequest();
		//		flightSearchRequest.setSearchType(FlightSearchType.DAN_CHENG.getCode());
		//		flightSearchRequest.setRoutes(routes);
		//		flightSearchRequest.setSendTicketCity("SHA");
		//		flightSearchRequest.setIsSimpleResponse("false");
		//		flightSearchRequest.setIsLowestPrice("false");
		//		flightSearchRequest.setPriceTypeOptions("NormalPrice");
		//		flightSearchRequest.setProductTypeOptions("Normal");
		//		flightSearchRequest.setClassgrade("F");
		//		flightSearchRequest.setOrderBy("DepartTime");
		//		flightSearchRequest.setDirection("ASC");
		//		// FlightSearch
		//		FlightSearch flightSearch = new FlightSearch();
		//		flightSearch.setHeader(header);
		//		flightSearch.setFlightSearchRequest(flightSearchRequest);
		//		//
		//		ByteArrayOutputStream os = new ByteArrayOutputStream();
		//		jaxb2Marshaller.marshal(flightSearch, new StreamResult(os));
		//		IOUtils.write(os.toByteArray(), new FileOutputStream(new File("D:/wsdl.xml")));
		webServiceTemplate.sendSourceAndReceiveToResult("http://openapi.ctrip.com/Flight/DomesticFlight/OTA_FlightSearch.asmx", new StreamSource(new File("D:/wsdl.xml")), new StreamResult(System.out));
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:context-ctrip.xml");
		WebServiceTemplate webServiceTemplate = applicationContext.getBean(WebServiceTemplate.class);
		webServiceTemplate.sendSourceAndReceiveToResult("http://openapi.ctrip.com/Flight/DomesticFlight/OTA_FlightSearch.asmx", new StreamSource(new File("D:/wsdl.xml")), new StreamResult(System.out));
	}
}
