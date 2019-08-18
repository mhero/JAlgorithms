package com.mac.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Util {
	public static int getNumberOfDecimalPlaces(BigDecimal bigDecimal) {
		return Math.max(0, bigDecimal.stripTrailingZeros().scale());
	}

	public static int largestNumberOfDecimalPlaces(List<BigDecimal> bigDecimals) {
		int max = getNumberOfDecimalPlaces(bigDecimals.get(0));
		for (BigDecimal bigDecimal : bigDecimals) {
			int places = getNumberOfDecimalPlaces(bigDecimal);
			if (places > max) {
				max = places;
			}
		}
		return max;
	}

	public static List<Integer> bigDecimalsToIntegerScaled(List<BigDecimal> bigDecimals) {
		int decimalPlaces = largestNumberOfDecimalPlaces(bigDecimals);
		List<Integer> integers = new ArrayList<>();
		for (BigDecimal bigDecimal : bigDecimals) {
			integers.add(bigDecimal.multiply(new BigDecimal(Math.pow(10, decimalPlaces))).intValueExact());
		}
		return integers;

	}

	public static String printSortedList(List<Integer> list) {
		Collections.sort(list);
		return Arrays.toString(list.toArray());
	}
}
