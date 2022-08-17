package com.project.search.count.command.domain;

import com.project.search.common.event.Event;
import lombok.Getter;

@Getter
public class SearchCountEvent extends Event {
    private final String keyword;

    public SearchCountEvent(String keyword) {
        this.keyword = keyword;
    }
}
