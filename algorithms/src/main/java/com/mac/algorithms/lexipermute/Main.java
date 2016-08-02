package com.mac.algorithms.lexipermute;

import static com.mac.algorithms.lexipermute.LexicographicalPermutation.nextPermutation;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {
            String word = nextPermutation(scanner.nextLine());
            if (word != null) {
                System.out.println(word);
            } else {
                System.out.println("no answer");
            }
        }
    }

}
