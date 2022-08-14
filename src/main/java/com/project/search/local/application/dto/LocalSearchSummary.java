package com.project.search.local.application.dto;

import lombok.Getter;

@Getter
public class LocalSearchSummary {
    private String addressName;
    private String roadAddressName;
    private String placeName;
    private String placeUrl;

    public LocalSearchSummary(String addressName, String roadAddressName, String placeName, String placeUrl) {
        this.addressName = addressName;
        this.roadAddressName = roadAddressName;
        this.placeName = placeName;
        this.placeUrl = placeUrl;
    }
}
