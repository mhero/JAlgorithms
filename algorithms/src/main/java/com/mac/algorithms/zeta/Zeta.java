package com.mac.algorithms.zeta;

import java.util.ArrayList;
import java.util.List;


/*
* Original Source
* http://www.geeksforgeeks.org/z-algorithm-linear-time-pattern-searching-algorithm/
* 
 */
public class Zeta {

    public List<Integer> search(String text, String pattern) {
        // Create concatenated string "P$T"
        String concat = pattern + "$" + text;
        int l = concat.length();

        // Construct Z array
        int Z[] = new int[l];
        getZarr(concat, Z);

        //creating list of indexes
        List<Integer> list = new ArrayList<>();

        //  now looping through Z array for matching condition
        for (int i = 0; i < l; ++i) {
            // if Z[i] (matched region) is equal to pattern
            // length  we got the pattern
            if (Z[i] == pattern.length()) {
                list.add(i - pattern.length() - 1);
            }
        }

        return list;
    }

    public void getZarr(String str, int Z[]) {
        int length = str.length();
        int left, right, k;

        left = right = 0;
        for (int i = 1; i < length; ++i) {

            if (i > right) {
                left = right = i;

                while (right < length && str.charAt(right - left) == str.charAt(right)) {
                    right++;
                }
                Z[i] = right - left;
                right--;
            } else {

                k = i - left;

                if (Z[k] < right - i + 1) {
                    Z[i] = Z[k];
                } else {

                    left = i;
                    while (right < length && str.charAt(right - left) == str.charAt(right)) {
                        right++;
                    }
                    Z[i] = right - left;
                    right--;
                }
            }
        }
    }
}
