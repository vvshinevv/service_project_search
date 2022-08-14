package com.project.search.local.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Getter
public class LocalSearchContainer {
    private SearchType searchType;
    private List<LocalSearch> items;
    private int page;
    private int size;
    private boolean isEnd;

    protected LocalSearchContainer() {
    }

    public LocalSearchContainer(SearchType searchType, List<LocalSearch> items, int page, int size, boolean isEnd) {
        this.searchType = searchType;
        this.items = items;
        this.page = page;
        this.size = size;
        this.isEnd = isEnd;
        IntStream.range(0, items.size()).forEach(i -> items.get(i).determineOrder(i));
    }

    public void decideScoreWithAnalogyMeasurement(List<LocalSearch> targets, AnalogyMeasurement analogyMeasurement) {
        for (LocalSearch item : items) {
            for (LocalSearch target : targets) {
                if (analogyMeasurement.measureAnalogy(item, target)) {
                    item.increaseScore();
                    item.addSimilarLocalSearch(target);
                }
            }
        }
    }

    public List<LocalSearch> findDifferentLocalSearch(List<LocalSearch> targets) {
        List<LocalSearch> results = new ArrayList<>(targets);
        for (LocalSearch item : items) {
            for (LocalSearch result : results) {
                if (!result.isSimilar(item)) {
                    results.add(item);
                }
            }
        }
        return results;
    }
}
