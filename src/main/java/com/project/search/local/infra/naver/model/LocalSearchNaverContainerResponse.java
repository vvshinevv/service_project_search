package com.project.search.local.infra.naver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.search.common.util.Streams;
import com.project.search.local.domain.LocalSearchContainer;
import com.project.search.local.domain.SearchType;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class LocalSearchNaverContainerResponse {
    @JsonProperty("items")
    private List<LocalSearchNaverResponse> localSearchNaverResponses;

    @JsonProperty("total")
    private int total;

    @JsonProperty("start")
    private int start;

    @JsonProperty("display")
    private int display;

    protected LocalSearchNaverContainerResponse() {
    }

    public LocalSearchContainer toDomain(int page, int size) {
        return new LocalSearchContainer(
                SearchType.NAVER,
                Streams.ofNullable(localSearchNaverResponses).map(LocalSearchNaverResponse::toDomain).collect(Collectors.toList()),
                page,
                size,
                total == display
        );
    }
}
