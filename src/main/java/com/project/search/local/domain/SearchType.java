package com.project.search.local.domain;

import lombok.Getter;

@Getter
public enum SearchType {
    KAKAO(1), NAVER(2);

    private final int order;

    SearchType(int order) {
        this.order = order;
    }
}
