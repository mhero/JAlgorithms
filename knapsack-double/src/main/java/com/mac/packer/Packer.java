package com.mac.packer;

import java.util.ArrayList;
import java.util.List;

import com.mac.exceptions.APIException;
import com.mac.parser.Parser;
import com.mac.util.Store;
import com.mac.util.Util;

public class Packer {

	public static String pack(String filePath) throws APIException {
		List<String> lines = Store.readFile(filePath);
		StringBuilder stringBuilder = new StringBuilder();
		for (String line : lines) {
			Parser parser = new Parser(line);
			stringBuilder.append(Util.printSortedList(parser.parse())).append("\n");
		}
		return stringBuilder.toString();
	}

	public static List<Integer> printknapSack(int W, Integer weights[], Integer values[]) {

		if (weights.length != values.length)
			return null;

		int n = weights.length;
		List<Integer> indexes = new ArrayList<>();

		int K[][] = new int[n + 1][W + 1];

		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (weights[i - 1] <= w)
					K[i][w] = Math.max(values[i - 1] + K[i - 1][w - weights[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}

		int res = K[n][W];

		for (int i = n, w = W; i > 0 && res > 0; i--) {

			if (res == K[i - 1][w])
				continue;
			else {
				indexes.add(i);

				res = res - values[i - 1];
				w = w - weights[i - 1];
			}
		}

		return indexes;
	}
}
