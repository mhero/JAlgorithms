package com.mac.algorithms.sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSets<T> {

    private void getSubsets(List<T> superSet, int k, int idx, Set<T> current, List<Set<T>> solution) {
        if (current.size() == k) {
            solution.add(new HashSet<>(current));
            return;
        }
        if (idx == superSet.size()) {
            return;
        }
        T x = superSet.get(idx);
        current.add(x);

        getSubsets(superSet, k, idx + 1, current, solution);
        current.remove(x);

        getSubsets(superSet, k, idx + 1, current, solution);
    }

    public List<Set<T>> getSubsets(List<T> superSetInput, int k) {
        List<Set<T>> res = new ArrayList<>();
        getSubsets(superSetInput, k, 0, new HashSet<>(), res);
        return res;
    }
}
