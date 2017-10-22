package com.mac.algorithms.sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        SubSets<String> subSets = new SubSets<>();
        String inputSubSet = "abcde";
        List<Set<String>> subSet = subSets.getSubsets(Arrays.asList(inputSubSet.split("")), 4);
        System.out.println(subSet);

        PowerSets<String> powerSets = new PowerSets<>();
        String inputPowerSet = "123";
        Set<Set<String>> powerSet = powerSets.powerSet(new HashSet<>(Arrays.asList(inputPowerSet.split(""))));
        System.out.println(powerSet);
    }

}
