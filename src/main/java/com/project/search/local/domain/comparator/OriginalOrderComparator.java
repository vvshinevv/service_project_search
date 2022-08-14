package com.project.search.local.domain.comparator;

import com.project.search.local.domain.LocalSearch;

import java.util.Comparator;

public class OriginalOrderComparator implements Comparator<LocalSearch> {
    @Override
    public int compare(LocalSearch o1, LocalSearch o2) {
        return o1.getOriginalOrder() - o2.getOriginalOrder();
    }
}
