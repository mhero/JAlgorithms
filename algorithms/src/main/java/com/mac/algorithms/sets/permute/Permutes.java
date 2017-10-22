/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.algorithms.sets.permute;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public class Permutes {

    /*
        to generate all strings of length N with letters from C
            -generate all strings of length N with letters from C that start with the empty string.

        to generate all strings of length N with letters from C that start with a string S
            -if the length of S is N
                -print S
            -else for each c in C
                -generate all strings of length N with letters from C that start with S+c
    */
    /* function performer */
    public static <T> void permuteWithRepetition(List<T> c, int n, String start, List<String> result) {

        if (start.length() >= n) {
            result.add(start);
        } else {
            for (T x : c) {
                permuteWithRepetition(c, n, start + String.valueOf(x), result);
            }
        }
    }

    /* function wrapper */
    /* gets all combinations with repetitions */
    /* eg
       input [A,B,C]
       result [AAAA,AAAB,AAAC,AABA,AABB,AABC,AACA,AACB,AACC,ABAA,ABAB,ABAC,ABBA,ABBB,
       ABBC,ABCA,ABCB,ABCC,ACAA,ACAB,ACAC,ACBA,ACBB,ACBC,ACCA,ACCB,ACCC,BAAA,
       BAAB,BAAC,BABA,BABB,BABC,BACA,BACB,BACC,BBAA,BBAB,BBAC,BBBA,BBBB,BBBC,
       BBCA,BBCB,BBCC,BCAA,BCAB,BCAC,BCBA,BCBB,BCBC,BCCA,BCCB,BCCC,CAAA,CAAB,
       CAAC,CABA,CABB,CABC,CACA,CACB,CACC,CBAA,CBAB,CBAC,CBBA,CBBB,CBBC,CBCA,
       CBCB,CBCC,CCAA,CCAB,CCAC,CCBA,CCBB,CCBC,CCCA,CCCB,CCCC]
    */
    public static <T> List<String> permuteWithRepetition(List<T> c, int sizeOfSets) {
        List<String> result = new ArrayList<>();
        permuteWithRepetition(c, sizeOfSets, "", result);
        return result;
    }

}
