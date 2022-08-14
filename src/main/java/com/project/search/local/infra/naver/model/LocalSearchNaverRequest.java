package com.project.search.local.infra.naver.model;

import lombok.Getter;

@Getter
public class LocalSearchNaverRequest {
    private String query;
    private int display;
    private int start;
    private SortType sort;

    protected LocalSearchNaverRequest() {
    }

    public LocalSearchNaverRequest(String query, int display, int start, SortType sort) {
        this.query = query;
        this.display = display;
        this.start = start;
        this.sort = sort;
    }
}
