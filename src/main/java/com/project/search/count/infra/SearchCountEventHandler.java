package com.project.search.count.infra;

import com.project.search.count.command.application.SearchCountService;
import com.project.search.count.command.domain.SearchCountEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SearchCountEventHandler {
    private final SearchCountService searchCountService;

    public SearchCountEventHandler(SearchCountService searchCountService) {
        this.searchCountService = searchCountService;
    }

    @EventListener(classes = SearchCountEvent.class)
    public void handler(SearchCountEvent searchCountEvent) {
        searchCountService.updateSearchCount(searchCountEvent.getKeyword());
    }
}
