package com.mac.algorithms.sets;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        SubSets<String> subSets = new SubSets<>();
        String input = "testwords";

        List<Set<String>> subsets = subSets.getSubsets(Arrays.asList(input.split("")), 2);
        System.out.println(subsets);
    }

}
