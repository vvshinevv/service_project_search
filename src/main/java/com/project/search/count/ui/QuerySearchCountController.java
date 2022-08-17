package com.project.search.count.ui;

import com.project.search.count.query.application.QuerySearchCountService;
import com.project.search.count.query.application.dto.SearchCountsSummary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuerySearchCountController {
    private final QuerySearchCountService querySearchCountService;

    public QuerySearchCountController(QuerySearchCountService querySearchCountService) {
        this.querySearchCountService = querySearchCountService;
    }

    @GetMapping("/search/count")
    public ResponseEntity<SearchCountsSummary> getSearchCounts() {
        SearchCountsSummary searchCountsSummary = querySearchCountService.findTop10SearchCounts();
        return ResponseEntity.ok().body(searchCountsSummary);
    }
}
