package com.project.search.local.ui;

import com.project.search.common.event.Events;
import com.project.search.local.application.LocalSearchService;
import com.project.search.local.application.dto.LocalSearchesSummary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalSearchController {
    private final LocalSearchService localSearchService;

    public LocalSearchController(LocalSearchService localSearchService) {
        this.localSearchService = localSearchService;
    }

    @GetMapping("/local/search")
    public ResponseEntity<LocalSearchesSummary> searchLocalWithKeyword(
            @RequestParam(value = "keyword") String keyword
    ) {
        LocalSearchesSummary localSearchesSummary = localSearchService.searchLocalByKeyWord(keyword);
        return ResponseEntity.ok().body(localSearchesSummary);
    }
}
