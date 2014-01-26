/*
 * @(#)Header.java $version 2014年1月26日
 *
 * Copyright 2014 NHN China. All rights Reserved.
 * NHN China PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ctrip.model;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * nhn ctrip-api
 * com.ctrip.model.Header.java
 * @author CN40101
 * @date 2014年1月26日
 */
public class Header {
	private String allianceId;
	private String sid;
	private String timestamp;
	private String requestType;
	private String signature;

	@XmlAttribute(name = "AllianceID")
	public String getAllianceId() {
		return allianceId;
	}

	public void setAllianceId(String allianceId) {
		this.allianceId = allianceId;
	}

	@XmlAttribute(name = "SID")
	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	@XmlAttribute(name = "TimeStamp")
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@XmlAttribute(name = "RequestType")
	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	@XmlAttribute(name = "Signature")
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
}
