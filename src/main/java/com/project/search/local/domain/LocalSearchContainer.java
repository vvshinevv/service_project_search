package com.project.search.local.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class LocalSearchContainer {
    private List<LocalSearch> items;
    private boolean isEnd;

    protected LocalSearchContainer() {
    }

    public LocalSearchContainer(List<LocalSearch> items, boolean isEnd) {
        this.items = items;
        this.isEnd = isEnd;
    }
}
