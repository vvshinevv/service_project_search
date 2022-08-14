package com.project.search.local.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class LocalSearchContainer {
    private SearchType searchType;
    private List<LocalSearch> items;
    private boolean isEnd;

    protected LocalSearchContainer() {
    }

    public LocalSearchContainer(SearchType searchType, List<LocalSearch> items, boolean isEnd) {
        this.searchType = searchType;
        this.items = items;
        this.isEnd = isEnd;
    }

    public void decideScoreWithAnalogyMeasurement(List<LocalSearch> targets, AnalogyMeasurement analogyMeasurement) {
        for (LocalSearch item : items) {
            for (LocalSearch target : targets) {
                if (analogyMeasurement.measureAnalogy(item, target)) {
                    item.increaseScore();
                }
            }
        }
    }
}
