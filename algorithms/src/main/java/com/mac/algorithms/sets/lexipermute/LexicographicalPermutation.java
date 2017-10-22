package com.mac.algorithms.sets.lexipermute;

public class LexicographicalPermutation {

    private static boolean nextPermutation(char[] array) {
        // Find non-increasing suffix
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }

        // Find successor to pivot
        int j = array.length - 1;
        while (array[j] <= array[i - 1]) {
            j--;
        }
        char temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        // Reverse suffix
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        return true;
    }

    public static String nextPermutation(String str) {
        char[] toCharArray = str.toCharArray();
        if (nextPermutation(toCharArray)) {
            return String.valueOf(toCharArray);
        }
        return null;
    }
}
