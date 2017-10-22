/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.algorithms.sets.permute;

import java.util.Arrays;

/**
 *
 * @author marco
 */
public class Main {

    
    public static void main(String[] args) {
        char[] c = {'A', 'B' , 'C'};
        System.out.println(Arrays.toString(Permutes.permuteWithRepetition(c, 4).toArray()));
    }
    
}
