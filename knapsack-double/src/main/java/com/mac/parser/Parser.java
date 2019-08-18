package com.mac.parser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mac.exceptions.APIException;
import com.mac.packer.Packer;

public class Parser {

	private String input;
	private final Integer GROUP_SIZE = 3;
	private final Integer TOP_WEIGHT = 100;
	private final Integer MAX_ITEM_LIST_SIZE = 15;
	private final Integer MAX_ITEM_SIZE = 100;
	private final String EURO = "€";

	public Parser(String input) {
		this.input = input;
	}

	public List<Integer> parse() throws APIException {
		Items items = groupItems(parseItems());
		Integer parsedWeight = parseWeight();

		if (!validParsing(items, parsedWeight)) {
			throw new APIException("Invalid parsed values");
		}
		List<Integer> result = Packer.printknapSack(parsedWeight * items.decimalPlacesScale(), items.getWeightsArray(),
				items.getValuesArray());
		return result;
	}

	public boolean validParsing(Items items, Integer weight) {
		if (weight > TOP_WEIGHT)
			return false;
		if (items.getValuesArray().length != items.getWeightsArray().length)
			return false;
		if (items.getValuesArray().length > MAX_ITEM_LIST_SIZE)
			return false;
		if (invalidListValues(items.getValues(), MAX_ITEM_SIZE)
				|| invalidListValues(items.getWeights(), new BigDecimal(MAX_ITEM_SIZE))) {
			return false;

		}
		return true;
	}

	public <T extends Object & Comparable<? super T>> boolean invalidListValues(List<T> values, T topLimit) {
		return Collections.max(values).compareTo(topLimit) > 0;
	}

	public Integer parseWeight() throws APIException {
		try {
			return Integer.parseInt(input.split(":")[0].trim());
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			throw new APIException("Unable to parse");
		}
	}

	public Items groupItems(List<String> parsedItems) throws APIException {
		Items items = new Items();

		if (parsedItems.size() % GROUP_SIZE != 0) {
			throw new APIException("Unable to parse, wrong number of elements");
		}
		for (int i = 0; i + GROUP_SIZE <= parsedItems.size(); i += GROUP_SIZE) {
			items.addItem(parsedItems.get(i + 1), parsedItems.get(i + 2));
		}
		return items;
	}

	public List<String> parseItems() {
		List<String> items = new ArrayList<>();
		String itemsStr = input.split(":")[1].trim();
		itemsStr = removeUnusedChars(itemsStr);
		Pattern p = Pattern.compile("\\((.*?)\\)");
		Matcher m = p.matcher(itemsStr);
		while (m.find()) {
			items.addAll(Arrays.asList(m.group(1).split("\\s*,\\s*")));
		}
		return items;
	}

	public String removeUnusedChars(String input) {
		return input.replace(EURO, "");
	}
}
