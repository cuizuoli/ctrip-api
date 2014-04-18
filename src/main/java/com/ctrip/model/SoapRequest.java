/*
 * @(#)SoapRequest.java $version 2014年4月17日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ctrip.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DaLian Software ctrip-api
 * com.ctrip.model.SoapRequest.java
 * @author cuizuoli
 * @date 2014年4月17日
 */
@XmlRootElement(name = "Request")
public class SoapRequest {
	private String xmlns = "http://ctrip.com/";
	private String request;

	@XmlAttribute
	public String getXmlns() {
		return xmlns;
	}

	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}

	@XmlElement(name = "requestXML")
	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}
}
