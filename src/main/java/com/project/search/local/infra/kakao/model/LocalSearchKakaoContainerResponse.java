package com.project.search.local.infra.kakao.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.search.common.util.Streams;
import com.project.search.local.domain.LocalSearchContainer;
import com.project.search.local.domain.SearchType;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class LocalSearchKakaoContainerResponse {
    @JsonProperty("documents")
    private List<LocalSearchKakaoResponse> localSearchKakaoResponses;
    @JsonProperty("meta")
    private MetaResponse meta;

    protected LocalSearchKakaoContainerResponse() {
    }

    public LocalSearchContainer toDomain(int page, int size) {
        return new LocalSearchContainer(
                SearchType.KAKAO,
                Streams.ofNullable(localSearchKakaoResponses).map(LocalSearchKakaoResponse::toDomain).collect(Collectors.toList()),
                page,
                size,
                meta.isEnd()
        );
    }
}
