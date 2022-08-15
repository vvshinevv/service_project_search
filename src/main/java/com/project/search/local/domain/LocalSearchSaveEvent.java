package com.project.search.local.domain;

import com.project.search.local.application.dto.LocalSearchesSummary;
import lombok.Getter;

@Getter
public class LocalSearchSaveEvent {
    private final String keyword;
    private final LocalSearchesSummary localSearchesSummary;

    public LocalSearchSaveEvent(String keyword, LocalSearchesSummary localSearchesSummary) {
        this.keyword = keyword;
        this.localSearchesSummary = localSearchesSummary;
    }
}
