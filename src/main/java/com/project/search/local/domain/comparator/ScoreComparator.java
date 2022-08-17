package com.project.search.local.domain.comparator;

import com.project.search.local.domain.LocalSearch;

import java.util.Comparator;

public class ScoreComparator implements Comparator<LocalSearch> {
    @Override
    public int compare(LocalSearch o1, LocalSearch o2) {
        return o2.getScore().compareTo(o1.getScore());
    }
}
