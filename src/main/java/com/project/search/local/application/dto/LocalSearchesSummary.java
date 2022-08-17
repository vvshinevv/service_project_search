package com.project.search.local.application.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class LocalSearchesSummary {
    private final String keyword;
    private final List<LocalSearchSummary> items;

    public LocalSearchesSummary(String keyword, List<LocalSearchSummary> items) {
        this.keyword = keyword;
        this.items = new ArrayList<>(items);
    }
}
