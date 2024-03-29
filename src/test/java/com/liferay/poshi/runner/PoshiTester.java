/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.poshi.runner;

import com.liferay.poshi.core.util.PropsUtil;

import java.io.FileInputStream;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Kenji Heigel
 */
public class PoshiTester extends PoshiRunnerTestCase {

	@Before
	public void setUp() throws Exception {
		Properties properties = new Properties();

		properties.load(
			new FileInputStream(
				_TEST_BASE_DIR_NAME + "/poshi-runner-ext.properties"));

		PropsUtil.clear();

		PropsUtil.setProperties(properties);

		setUpPoshiRunner(_TEST_BASE_DIR_NAME);
	}

	@Test
	public void testPoshiTest() throws Exception {
		PoshiRunner poshiRunner = new PoshiRunner("PoshiScriptTest#MyTest");

		poshiRunner.setUp();

		poshiRunner.test();
	}

	private static final String _TEST_BASE_DIR_NAME =
		"/opt/dev/projects/github/poshi-dev-tools/src/test/resources/poshiFiles";

}