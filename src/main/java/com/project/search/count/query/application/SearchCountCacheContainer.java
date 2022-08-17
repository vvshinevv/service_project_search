package com.project.search.count.query.application;

import com.project.search.count.query.application.dto.SearchCountSummary;
import com.project.search.count.query.application.dto.SearchCountsSummary;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Slf4j
@Component
public class SearchCountCacheContainer {
    private static final Queue<SearchCountSummary> CACHED = new ConcurrentLinkedQueue<>();
    private final QuerySearchCountService querySearchCountService;

    public SearchCountCacheContainer(QuerySearchCountService querySearchCountService) {
        this.querySearchCountService = querySearchCountService;
    }

    public static SearchCountsSummary getCached() {
        return new SearchCountsSummary(new ArrayList<>(CACHED));
    }

    @Scheduled(cron = "0 * * * * *")
    public void refreshSearchCount() {
        SearchCountsSummary searchCountsSummary = querySearchCountService.findTop10SearchCounts();

        CACHED.clear();
        CACHED.addAll(searchCountsSummary.getSummaries());
    }
}
