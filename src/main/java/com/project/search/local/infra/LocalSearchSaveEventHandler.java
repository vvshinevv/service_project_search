package com.project.search.local.infra;

import com.project.search.local.application.LocalSearchService;
import com.project.search.local.domain.LocalSearchSaveEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class LocalSearchSaveEventHandler {
    private final LocalSearchService localSearchService;

    public LocalSearchSaveEventHandler(LocalSearchService localSearchService) {
        this.localSearchService = localSearchService;
    }

    @Async
    @TransactionalEventListener(classes = LocalSearchSaveEvent.class)
    public void handler(LocalSearchSaveEvent localSearchSaveEvent) {

    }
}
