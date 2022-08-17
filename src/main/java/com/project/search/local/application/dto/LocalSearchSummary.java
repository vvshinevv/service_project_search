package com.project.search.local.application.dto;

import lombok.Getter;

@Getter
public class LocalSearchSummary {
    private final String addressName;
    private final String roadAddressName;
    private final String placeName;
    private final String placeUrl;
    private final String searchType;

    public LocalSearchSummary(String addressName, String roadAddressName, String placeName, String placeUrl, String searchType) {
        this.addressName = addressName;
        this.roadAddressName = roadAddressName;
        this.placeName = placeName;
        this.placeUrl = placeUrl;
        this.searchType = searchType;
    }
}
