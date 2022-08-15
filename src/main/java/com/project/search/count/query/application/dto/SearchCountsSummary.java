package com.project.search.count.query.application.dto;

import lombok.Getter;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SearchCountsSummary {
    private final List<SearchCountSummary> summaries;

    public SearchCountsSummary(List<SearchCountSummary> summaries) {
        this.summaries = new ArrayList<>(summaries);
    }

    public boolean isEmpty() {
        return CollectionUtils.isEmpty(summaries);
    }
}
