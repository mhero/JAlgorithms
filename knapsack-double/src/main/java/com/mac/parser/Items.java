package com.mac.parser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.mac.exceptions.APIException;
import com.mac.util.Util;

public class Items {
	private List<Integer> values;
	private List<BigDecimal> weights;

	public Items() {
		weights = new ArrayList<>();
		values = new ArrayList<>();
	}

	public Items(List<Integer> values, List<BigDecimal> weights) {
		super();
		this.values = values;
		this.weights = weights;
	}

	public void addItem(BigDecimal weight, Integer value) {
		weights.add(weight);
		values.add(value);
	}

	public void addItem(String weight, String value) throws APIException {
		try {
			weights.add(new BigDecimal(weight));
			values.add(Integer.parseInt(value));
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			throw new APIException("Unable to parse");
		}
	}

	public List<BigDecimal> getWeights() {
		return weights;
	}

	public List<Integer> getValues() {
		return values;
	}

	public Integer[] getWeightsArray() {
		return Util.bigDecimalsToIntegerScaled(weights).stream().toArray(Integer[]::new);
	}

	public Integer[] getValuesArray() {
		return values.stream().toArray(Integer[]::new);
	}

	public Integer decimalPlacesScale() {
		return (int) Math.pow(10, Util.largestNumberOfDecimalPlaces(weights));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((values == null) ? 0 : values.hashCode());
		result = prime * result + ((weights == null) ? 0 : weights.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Items other = (Items) obj;
		if (values == null) {
			if (other.values != null)
				return false;
		} else if (!values.equals(other.values))
			return false;
		if (weights == null) {
			if (other.weights != null)
				return false;
		} else if (!weights.equals(other.weights))
			return false;
		return true;
	}

}
