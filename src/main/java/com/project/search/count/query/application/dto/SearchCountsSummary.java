package com.project.search.count.query.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SearchCountsSummary {
    private List<SearchCountSummary> summaries;

    protected SearchCountsSummary() {
    }

    public SearchCountsSummary(List<SearchCountSummary> summaries) {
        this.summaries = new ArrayList<>(summaries);
    }

    @JsonIgnore
    public boolean isEmpty() {
        return CollectionUtils.isEmpty(summaries);
    }
}
