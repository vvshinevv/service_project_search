package com.project.search.local.infra.naver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.search.local.domain.LocalSearch;
import com.project.search.local.domain.SearchType;
import lombok.Getter;

@Getter
public class LocalSearchNaverResponse {
    @JsonProperty("address")
    private String address;

    @JsonProperty("roadAddress")
    private String roadAddress;

    @JsonProperty("title")
    private String title;

    @JsonProperty("link")
    private String link;

    protected LocalSearchNaverResponse() {
    }

    public LocalSearch toDomain(String keyword) {
        return new LocalSearch(keyword, address, roadAddress, title, link, SearchType.NAVER);
    }
}
