package com.project.search.local.domain;

import com.project.search.local.application.dto.LocalSearchesSummary;
import lombok.Getter;

@Getter
public class LocalSearchSaveEvent {
    private final LocalSearchesSummary localSearchesSummary;

    public LocalSearchSaveEvent(LocalSearchesSummary localSearchesSummary) {
        this.localSearchesSummary = localSearchesSummary;
    }
}
