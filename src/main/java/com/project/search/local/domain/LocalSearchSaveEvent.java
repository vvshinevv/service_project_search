package com.project.search.local.domain;

import com.project.search.common.event.Event;
import com.project.search.local.application.dto.LocalSearchesSummary;
import lombok.Getter;

@Getter
public class LocalSearchSaveEvent extends Event {
    private final LocalSearchesSummary localSearchesSummary;

    public LocalSearchSaveEvent(LocalSearchesSummary localSearchesSummary) {
        this.localSearchesSummary = localSearchesSummary;
    }
}
