/*
 * @(#)SoapResponse.java $version 2014年4月17日
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
 * com.ctrip.model.SoapResponse.java
 * @author cuizuoli
 * @date 2014年4月17日
 */
@XmlRootElement(name = "RequestResponse")
public class SoapResponse {
	private String xmlns = "http://ctrip.com/";
	private String response;

	@XmlAttribute
	public String getXmlns() {
		return xmlns;
	}

	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}

	@XmlElement(name = "RequestResult")
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}
