package com.mac.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UtilTest {

	@Before
	public void init() {

	}

	@Test
	public void testSuccessNumberOfDecimals() {

		boolean success = Util.getNumberOfDecimalPlaces(new BigDecimal("4.5678")) == 4;
		Assert.assertTrue(success);

		success = Util.getNumberOfDecimalPlaces(new BigDecimal("4.568")) == 3;
		Assert.assertTrue(success);
	}

	@Test
	public void testSuccessMaxNumberOfDecimals() {
		List<BigDecimal> bigDecimals = Arrays.asList(new BigDecimal("4.5678"), new BigDecimal("4.568"));
		boolean success = Util.largestNumberOfDecimalPlaces(bigDecimals) == 4;
		Assert.assertTrue(success);
	}

	@Test
	public void testSuccessBigDecimalsToIntegerScaled() {
		List<BigDecimal> bigDecimals = Arrays.asList(new BigDecimal("4.567"), new BigDecimal("4.568"));
		List<Integer> integers = Arrays.asList(4567, 4568);
		boolean success = integers.equals(Util.bigDecimalsToIntegerScaled(bigDecimals));
		Assert.assertTrue(success);
	}
}