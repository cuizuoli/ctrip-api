/*
 * @(#)SignatureUtils.java $version 2014年1月26日
 *
 * Copyright 2014 NHN China. All rights Reserved.
 * NHN China PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ctrip.utils;

import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * nhn ctrip-api
 * com.ctrip.utils.SignatureUtils.java
 * @author CN40101
 * @date 2014年1月26日
 */
public class SignatureUtils {

	/**
	 * getTimestamp
	 * @return
	 */
	public static String getTimestamp() {
		return String.valueOf(System.currentTimeMillis() / 1000);
	}

	/**
	 * Signature=Md5(TimeStamp+AllianceID+MD5(密钥).ToUpper()+SID+RequestType).ToUpper()
	 * 
	 * 参考数据：
	 * 密钥是：abcdefg123456
	 * MD5后站点密钥是：5393E07F94A25AAA373DBD3FA257BD3A
	 * 
	 * 签名的参考结果：
	 * AllianceID =1& SID =50& TimeStamp =1234567890&RequestType=OTA_Ping
	 * 加密结果如下：
	 * Signature=Md5(TimeStamp+AllianceID+MD5(密钥).ToUpper()+SID+RequestType).ToUpper()
	 *          =MD5(123456789015393E07F94A25AAA373DBD3FA257BD3A50OTA_Ping)
	 *          =EF5FBA4AAB36FD044F8A13BA0D63DD13
	 * 
	 * @param timestamp - 计算从1970年到现在的秒数；
	 * @param allianceId - 联盟代码，可以在“我的账户”中查到；
	 * @param secretKey - 站点的APIKey，可以在“站点列表”中查到；
	 * @param sid - 联盟的站点ID，可以在“站点列表”中查到；
	 * @param requestType - 请求接口服务的名称，例如OTA_Ping；
	 * @return
	 */
	public static String getSignature(String timestamp, String allianceId, String secretKey, String sid,
			String requestType) {
		return DigestUtils.md5Hex(new StringBuffer()
			.append(timestamp)
			.append(allianceId)
			.append(DigestUtils.md5Hex(secretKey).toUpperCase())
			.append(sid)
			.append(requestType)
			.toString()).toUpperCase();
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println(DigestUtils.md5Hex("abcdefg123456").toUpperCase());
		System.out.println(SignatureUtils.getSignature("1234567890", "1", "abcdefg123456", "50", "OTA_Ping"));
	}
}
