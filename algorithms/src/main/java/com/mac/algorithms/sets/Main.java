package com.mac.algorithms.sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String inputSubSet = "abcde";
        List<Set<String>> subSet = SubSets.getSubsets(Arrays.asList(inputSubSet.split("")), 4);
        System.out.println(subSet);

        String inputPowerSet = "123";
        Set<Set<String>> powerSet = PowerSets.powerSet(new HashSet<>(Arrays.asList(inputPowerSet.split(""))));
        System.out.println(powerSet);
    }

}
