package com.project.search.local.application.dto;

import lombok.Getter;

@Getter
public class LocalSearchSummary {
    private final String addressName;
    private final String roadAddressName;
    private final String placeName;
    private final String placeUrl;

    public LocalSearchSummary(String addressName, String roadAddressName, String placeName, String placeUrl) {
        this.addressName = addressName;
        this.roadAddressName = roadAddressName;
        this.placeName = placeName;
        this.placeUrl = placeUrl;
    }
}
