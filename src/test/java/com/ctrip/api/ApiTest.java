/*
 * @(#)ApiTest.java $version 2014年1月26日
 *
 * Copyright 2014 NHN China. All rights Reserved.
 * NHN China PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ctrip.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import javax.annotation.Resource;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;

import com.ctrip.api.test.AbstractTest;
import com.ctrip.enums.FlightSearchType;
import com.ctrip.model.FlightRoute;
import com.ctrip.model.FlightSearch;
import com.ctrip.model.FlightSearchRequest;
import com.ctrip.model.Header;
import com.ctrip.model.Routes;
import com.ctrip.model.SoapRequest;
import com.ctrip.model.SoapResponse;
import com.ctrip.utils.SignatureUtils;

/**
 * nhn ctrip-api
 * com.ctrip.api.ApiTest.java
 * @author CN40101
 * @date 2014年1月26日
 */
@Slf4j
public class ApiTest extends AbstractTest {

	@Value("#{ctripProperties['ctrip.apiKey']}")
	private String apiKey;

	@Value("#{ctripProperties['ctrip.sid']}")
	private String sid;

	@Value("#{ctripProperties['ctrip.allianceId']}")
	private String allianceId;

	@Autowired
	private ApplicationContext applicationContext;

	@Resource
	private Jaxb2Marshaller jaxb2Marshaller;

	@Resource
	private WebServiceTemplate webServiceTemplate;

	@Test
	public void test() throws IOException {
		log.debug("test");
		String timestamp = SignatureUtils.getTimestamp();
		String requestType = "OTA_FlightSearch";
		// Header
		Header header = new Header();
		header.setAllianceId(allianceId);
		header.setSid(sid);
		header.setTimestamp(timestamp);
		header.setRequestType(requestType);
		header.setSignature(SignatureUtils.getSignature(timestamp, allianceId, apiKey, sid, requestType));
		// FlightRoute
		FlightRoute flightRoute = new FlightRoute();
		flightRoute.setDepartCity("SHA");
		flightRoute.setArriveCity("BJS");
		flightRoute.setDepartDate("2014-05-27");
		flightRoute.setAirlineDibitCode("CA");
		flightRoute.setDepartPort("");
		flightRoute.setArrivePort("");
		flightRoute.setEarliestDepartTime("2014-05-27T08:00:00");
		flightRoute.setLatestDepartTime("2014-05-27T12:00:00");
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
		FlightSearch flightSearch = new FlightSearch();
		flightSearch.setHeader(header);
		flightSearch.setFlightSearchRequest(flightSearchRequest);
		StringResult stringResult = new StringResult();
		jaxb2Marshaller.marshal(flightSearch, stringResult);
		SoapRequest soapRequest = new SoapRequest();
		soapRequest.setRequest(stringResult.toString());
		StringResult requestBody = new StringResult();
		jaxb2Marshaller.marshal(soapRequest, requestBody);
		log.debug(requestBody.toString());
		String url = "http://openapi.ctrip.com/Flight/DomesticFlight/OTA_FlightSearch.asmx";
		StringResult responseBody = new StringResult();
		webServiceTemplate.sendSourceAndReceiveToResult(url, new StringSource(requestBody.toString()), new SimpleSoapActionCallback("http://ctrip.com/Request"), responseBody);
		log.debug(responseBody.toString());
		SoapResponse soapResponse = (SoapResponse)jaxb2Marshaller.unmarshal(new StreamSource(new StringReader(responseBody.toString())));
		log.debug(soapResponse.getResponse());
	}

	@Test
	public void test1() throws JAXBException, FileNotFoundException {
		SoapResponse soapResponse = (SoapResponse)jaxb2Marshaller.unmarshal(new StreamSource(new FileReader(new File("D:\\test1.xml"))));
		log.debug(soapResponse.getResponse());
	}

	private class SimpleSoapActionCallback extends SoapActionCallback {

		public SimpleSoapActionCallback(String soapAction) {
			super(soapAction);
		}

		@Override
		public void doWithMessage(WebServiceMessage message) throws IOException {
			message.writeTo(new FileOutputStream(new File("D:/test.xml")));
			super.doWithMessage(message);
		}
	}
}
