package com.project.search.local.application.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class LocalSearchesSaveDto {
    private String keyword;
    private List<LocalSearchSaveDto> items;

    public LocalSearchesSaveDto(String keyword, List<LocalSearchSaveDto> items) {
        this.keyword = keyword;
        this.items = items;
    }
}
