package com.mac.packer;

import java.util.Scanner;

import com.mac.exceptions.APIException;

public class App {
	private static Scanner scanner;

	public static void main(String[] args) {

		try {
			scanner = new Scanner(System.in);
			System.out.println("Please enter a location for your file");
			System.out.println(Packer.pack(scanner.nextLine()));
		} catch (APIException e) {
			e.printStackTrace();
		}

	}

	

}
