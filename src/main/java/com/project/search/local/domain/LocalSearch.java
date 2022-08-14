package com.project.search.local.domain;

import lombok.Getter;

@Getter
public class LocalSearch {
    private String addressName;
    private String roadAddressName;
    private String placeName;
    private String placeUrl;
    private Score score;

    protected LocalSearch() {
    }

    public LocalSearch(String addressName, String roadAddressName, String placeName, String placeUrl) {
        this.addressName = addressName;
        this.roadAddressName = roadAddressName;
        this.placeName = placeName;
        this.placeUrl = placeUrl;
    }

    public void increaseScore() {
        this.score = score.increase(1);
    }
}
