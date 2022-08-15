package com.project.search.count.infra;

import com.project.search.count.command.application.SearchCountService;
import com.project.search.count.command.domain.SearchCountEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class SearchCountEventHandler {
    private final SearchCountService searchCountService;

    public SearchCountEventHandler(SearchCountService searchCountService) {
        this.searchCountService = searchCountService;
    }

    @Async
    @TransactionalEventListener(classes = SearchCountEvent.class)
    public void handler(SearchCountEvent searchCountEvent) {
        searchCountService.updateSearchCount(searchCountEvent.getKeyword());
    }
}
