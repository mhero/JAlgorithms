/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.algorithms.sets.permute;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author marco
 */
public class Main {

    public static void main(String[] args) {
        List<Integer> c = Arrays.asList(1, 2, 3);
        System.out.println(Arrays.toString(Permutes.permuteWithRepetition(c, 4).toArray()));
    }

}
