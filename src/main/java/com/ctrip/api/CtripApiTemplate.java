/*
 * @(#)CtripApiTemplate.java $version 2014年4月18日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ctrip.api;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;

import com.ctrip.model.Header;
import com.ctrip.model.SoapRequest;
import com.ctrip.model.SoapResponse;
import com.ctrip.utils.SignatureUtils;

/**
 * DaLian Software ctrip-api
 * com.ctrip.api.CtripApiTemplate.java
 * @author cuizuoli
 * @date 2014年4月18日
 */
@Slf4j
@Component
public class CtripApiTemplate implements CtripApiOperations {

	public final static String SOAP_ACTION = "http://ctrip.com/Request";
	public final static String SOAP_RESPONSE_NS = " xmlns=\"http://ctrip.com/\"";
	public final static String SOAP_RESPONSE_DECLARE = "<?xml version=\"1.0\"?>";

	@Value("#{ctripProperties['ctrip.apiKey']}")
	private String apiKey;

	@Value("#{ctripProperties['ctrip.sid']}")
	private String sid;

	@Value("#{ctripProperties['ctrip.allianceId']}")
	private String allianceId;

	@Resource
	private WebServiceTemplate webServiceTemplate;

	@Resource
	private Jaxb2Marshaller jaxb2Marshaller;

	@Override
	public SoapResponse send(String uri, SoapRequest soapRequest) {
		// requestResult
		StringResult requestResult = new StringResult();
		jaxb2Marshaller.marshal(soapRequest, requestResult);
		String requestContent = requestResult.toString();
		log.debug("requestContent - " + requestContent);
		// responseResult
		StringResult responseResult = new StringResult();
		webServiceTemplate.sendSourceAndReceiveToResult(uri, new StringSource(requestContent), new SoapActionCallback(SOAP_ACTION), responseResult);
		String responseContent = responseResult.toString();
		log.debug("responseContent - " + responseContent);
		// delete responseContent xmlns, fixed unmarshal bugs.
		responseContent = StringUtils.replace(responseContent, CtripApiTemplate.SOAP_RESPONSE_NS, StringUtils.EMPTY);
		return (SoapResponse)jaxb2Marshaller.unmarshal(new StringSource(responseContent));
	}

	/**
	 * getHeader
	 * @return
	 */
	public Header getHeader() {
		String timestamp = SignatureUtils.getTimestamp();
		String requestType = "OTA_FlightSearch";
		// Header
		Header header = new Header();
		header.setAllianceId(allianceId);
		header.setSid(sid);
		header.setTimestamp(timestamp);
		header.setRequestType(requestType);
		header.setSignature(SignatureUtils.getSignature(timestamp, allianceId, apiKey, sid, requestType));
		return header;
	}

}
