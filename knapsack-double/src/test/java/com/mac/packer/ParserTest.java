package com.mac.packer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mac.exceptions.APIException;
import com.mac.parser.Items;
import com.mac.parser.Parser;

public class ParserTest {

	private Parser parser;
	private String okString;
	private String notOkString;
	private String alsoNotOkString;

	private List<String> parsedItems;

	@Before
	public void init() {
		okString = "81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)";
		parsedItems = Arrays.asList("1", "53.38", "45", "2", "88.62", "98", "3", "78.48", "3", "4", "72.30", "76", "5",
				"30.18", "9", "6", "46.34", "48");
		notOkString = "8e : (1,53.3t8,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)";
		alsoNotOkString = "8e : (53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)";
	}

	@Test
	public void testSuccessGetWeight() throws APIException {
		parser = new Parser(okString);
		boolean success = parser.parseWeight().equals(81);
		Assert.assertTrue(success);
	}

	@Test(expected = APIException.class)
	public void testFailGetWeight() throws APIException {
		parser = new Parser(notOkString);
		parser.parseWeight();
	}

	@Test
	public void testSuccessParseItems() {
		parser = new Parser(okString);
		boolean success = parser.parseItems().equals(parsedItems);
		Assert.assertTrue(success);
	}

	@Test
	public void testSuccessGetItems() throws APIException {
		parser = new Parser(okString);
		List<BigDecimal> weights = Arrays.asList(new BigDecimal("53.38"), new BigDecimal("88.62"),
				new BigDecimal("78.48"), new BigDecimal("72.30"), new BigDecimal("30.18"), new BigDecimal("46.34"));
		List<Integer> values = Arrays.asList(45, 98, 3, 76, 9, 48);

		Items items = new Items(values, weights);
		boolean success = parser.groupItems(parsedItems).equals(items);
		Assert.assertTrue(success);
	}

	@Test
	public void testFailGetItems() throws APIException {
		parser = new Parser(okString);
		List<BigDecimal> weights = Arrays.asList(new BigDecimal("53.38"), new BigDecimal("88.62"),
				new BigDecimal("78.48"), new BigDecimal("2.30"), new BigDecimal("30.18"), new BigDecimal("46.34"));
		List<Integer> values = Arrays.asList(45, 98, 3, 76, 9, 47);

		Items items = new Items(values, weights);
		boolean fail = parser.groupItems(parsedItems).equals(items);
		Assert.assertTrue(!fail);
	}

	@Test(expected = APIException.class)
	public void testFailGetItemsByInputSize() throws APIException {
		parser = new Parser(notOkString);
		parser.groupItems(parser.parseItems());
	}

	@Test(expected = APIException.class)
	public void testFailGetItemsByInputContent() throws APIException {
		parser = new Parser(alsoNotOkString);
		parser.groupItems(parser.parseItems());
	}

}
