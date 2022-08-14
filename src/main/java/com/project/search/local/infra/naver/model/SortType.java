package com.project.search.local.infra.naver.model;

import lombok.Getter;

@Getter
public enum SortType {
    RANDOM("random"),
    COMMENT("comment");

    private final String name;

    SortType(String name) {
        this.name = name;
    }
}
