package com.project.search.local.domain;

import lombok.Getter;

@Getter
public class LocalSearch {
    private String addressName;
    private String roadAddressName;
    private String placeName;

    protected LocalSearch() {
    }

    public LocalSearch(String addressName, String roadAddressName, String placeName) {
        this.addressName = addressName;
        this.roadAddressName = roadAddressName;
        this.placeName = placeName;
    }
}
