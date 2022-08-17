package com.project.search.local.domain;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum SearchType {
    KAKAO(1), NAVER(2);

    private final int order;

    SearchType(int order) {
        this.order = order;
    }

    public static SearchType of(String name) {
        return Arrays.stream(SearchType.values()).filter(i -> name.equals(i.name())).findAny().orElseThrow();
    }
}
