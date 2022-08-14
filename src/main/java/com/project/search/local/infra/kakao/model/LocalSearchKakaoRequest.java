package com.project.search.local.infra.kakao.model;

import lombok.Getter;

@Getter
public class LocalSearchKakaoRequest {
    private String query;
    private int page;
    private int size;
    private SortType sort;

    protected LocalSearchKakaoRequest() {
    }

    public LocalSearchKakaoRequest(String query, int page, int size, SortType sort) {
        this.query = query;
        this.page = page;
        this.size = size;
        this.sort = sort;
    }
}
