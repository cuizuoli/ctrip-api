/*
 * @(#)ApiTest.java $version 2014年1月26日
 *
 * Copyright 2014 NHN China. All rights Reserved.
 * NHN China PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ctrip.api;

import java.io.IOException;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.ctrip.api.test.AbstractTest;

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

	@Resource
	private Jaxb2Marshaller jaxb2Marshaller;

	@Resource
	private WebServiceTemplate webServiceTemplate;

	@Resource
	private Flight flight;

	@Test
	public void test() throws IOException {
		String result = flight.search();
		log.debug(result);
	}

}
