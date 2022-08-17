package com.project.search.count.query.application.dto;

import lombok.Getter;

import java.util.Objects;

@Getter
public class SearchCountSummary {
    private String keyword;
    private int count;

    protected SearchCountSummary() {
    }

    public SearchCountSummary(String keyword, int count) {
        this.keyword = keyword;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchCountSummary that = (SearchCountSummary) o;
        return getCount() == that.getCount() && Objects.equals(getKeyword(), that.getKeyword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKeyword(), getCount());
    }
}
