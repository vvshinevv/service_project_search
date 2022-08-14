package com.project.search.local.infra.kakao.model;

import lombok.Getter;

@Getter
public enum SortType {
    ACCURACY("accuracy"),
    DISTANCE("distance");

    private final String name;

    SortType(String name) {
        this.name = name;
    }
}
