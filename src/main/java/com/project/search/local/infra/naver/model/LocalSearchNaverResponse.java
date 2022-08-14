package com.project.search.local.infra.naver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.search.local.domain.LocalSearch;
import lombok.Getter;

@Getter
public class LocalSearchNaverResponse {
    @JsonProperty("address")
    private String address;

    @JsonProperty("roadAddress")
    private String roadAddress;

    @JsonProperty("title")
    private String title;

    protected LocalSearchNaverResponse() {
    }

    public LocalSearch toDomain() {
        return new LocalSearch(address, roadAddress, title);
    }
}
