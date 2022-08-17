package com.project.search.count.query.application;

import com.project.search.common.util.Streams;
import com.project.search.count.command.domain.SearchCount;
import com.project.search.count.query.application.dto.SearchCountSummary;
import com.project.search.count.query.application.dto.SearchCountsSummary;
import com.project.search.count.query.dao.SearchCountDataDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuerySearchCountService {
    private final SearchCountDataDao searchCountDataDao;

    public QuerySearchCountService(SearchCountDataDao searchCountDataDao) {
        this.searchCountDataDao = searchCountDataDao;
    }

    public SearchCountsSummary findTop10SearchCounts() {
        SearchCountsSummary cached = SearchCountCacheContainer.getCached();
        if (!cached.isEmpty()) {
            return cached;
        }

        List<SearchCount> results = searchCountDataDao.findTop10ByOrderByCountDesc();
        return toSummary(results);
    }

    private SearchCountsSummary toSummary(List<SearchCount> searchCounts) {
        return new SearchCountsSummary(Streams.ofNullable(searchCounts).map(this::toSummary).collect(Collectors.toList()));
    }

    private SearchCountSummary toSummary(SearchCount searchCount) {
        return new SearchCountSummary(searchCount.getKeyword(), searchCount.getCount().getCount());
    }
}
