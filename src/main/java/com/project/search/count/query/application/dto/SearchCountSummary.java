package com.project.search.count.query.application.dto;

import lombok.Getter;

@Getter
public class SearchCountSummary {
    private final String keyword;
    private final int count;

    public SearchCountSummary(String keyword, int count) {
        this.keyword = keyword;
        this.count = count;
    }
}
