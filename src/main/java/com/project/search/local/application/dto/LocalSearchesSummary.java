package com.project.search.local.application.dto;

import java.util.ArrayList;
import java.util.List;

public class LocalSearchesSummary {
    private List<LocalSearchSummary> items;

    public LocalSearchesSummary(List<LocalSearchSummary> items) {
        this.items = new ArrayList<>(items);
    }
}
