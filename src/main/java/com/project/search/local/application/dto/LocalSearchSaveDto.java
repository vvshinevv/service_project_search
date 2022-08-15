package com.project.search.local.application.dto;

import lombok.Getter;

@Getter
public class LocalSearchSaveDto {
    private String addressName;
    private String roadAddressName;
    private String placeName;
    private String placeUrl;
    private String searchType;


    public LocalSearchSaveDto(String addressName, String roadAddressName, String placeName, String placeUrl, String searchType) {
        this.addressName = addressName;
        this.roadAddressName = roadAddressName;
        this.placeName = placeName;
        this.placeUrl = placeUrl;
        this.searchType = searchType;
    }
}
