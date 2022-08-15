package com.project.search.local.application.dto;

import lombok.Getter;

@Getter
public class LocalSearchSaveDto {
    private final String keyword;
    private final String addressName;
    private final String roadAddressName;
    private final String placeName;
    private final String placeUrl;

    public LocalSearchSaveDto(String keyword, String addressName, String roadAddressName, String placeName, String placeUrl) {
        this.keyword = keyword;
        this.addressName = addressName;
        this.roadAddressName = roadAddressName;
        this.placeName = placeName;
        this.placeUrl = placeUrl;
    }
}
