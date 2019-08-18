package com.mac.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Store {

	private static BufferedReader bufferedReader;

	public static List<String> readFile(String path) {
		List<String> lines = new ArrayList<>();
		try {
			File f = new File(path);

			bufferedReader = new BufferedReader(new FileReader(f));
			String readLine = "";
			while ((readLine = bufferedReader.readLine()) != null) {
				lines.add(readLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
}
