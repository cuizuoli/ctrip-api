/*
 * @(#)AbstractTest.java $version 2014年1月26日
 *
 * Copyright 2014 NHN China. All rights Reserved.
 * NHN China PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.ctrip.api.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * nhn ctrip-api
 * com.ctrip.api.test.AbstractTest.java
 * @author CN40101
 * @date 2014年1月26日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:context-ctrip.xml", "classpath:context-data.xml"})
public abstract class AbstractTest {
}
