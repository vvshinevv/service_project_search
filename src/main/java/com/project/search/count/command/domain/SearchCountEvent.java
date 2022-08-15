package com.project.search.count.command.domain;

import lombok.Getter;

@Getter
public class SearchCountEvent {
    private final String keyword;

    public SearchCountEvent(String keyword) {
        this.keyword = keyword;
    }
}
