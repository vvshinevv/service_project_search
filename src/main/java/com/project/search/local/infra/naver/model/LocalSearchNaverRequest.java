package com.project.search.local.infra.naver.model;

import lombok.Getter;

@Getter
public class LocalSearchNaverRequest {
    private String query;
    private int start;
    private int display;
    private SortType sort;

    protected LocalSearchNaverRequest() {
    }

    public LocalSearchNaverRequest(String query, int start, int display, SortType sort) {
        this.query = query;
        this.start = start;
        this.display = display;
        this.sort = sort;
    }
}
