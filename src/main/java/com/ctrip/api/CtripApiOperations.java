/*
 * @(#)CtripApiOperations.java $version 2014年4月18日
 *
 * Copyright 2014 DaLian Software. All rights Reserved.
 * DaLian Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ctrip.api;

import com.ctrip.model.SoapRequest;
import com.ctrip.model.SoapResponse;

/**
 * DaLian Software ctrip-api
 * com.ctrip.api.CtripApiOperations.java
 * @author cuizuoli
 * @date 2014年4月18日
 */
public interface CtripApiOperations {
	/**
	 * send
	 * @param uri
	 * @param soapRequest
	 * @return
	 */
	SoapResponse send(String uri, SoapRequest soapRequest);
}
