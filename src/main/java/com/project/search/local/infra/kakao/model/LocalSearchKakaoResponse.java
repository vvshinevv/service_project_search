package com.project.search.local.infra.kakao.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.search.local.domain.LocalSearch;
import lombok.Getter;

@Getter
public class LocalSearchKakaoResponse {
    @JsonProperty("address_name")
    private String addressName;

    @JsonProperty("road_address_name")
    private String roadAddressName;

    @JsonProperty("place_name")
    private String placeName;

    protected LocalSearchKakaoResponse() {
    }

    public LocalSearch toDomain() {
        return new LocalSearch(addressName, roadAddressName, placeName);
    }
}
