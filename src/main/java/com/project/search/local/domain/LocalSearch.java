package com.project.search.local.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Entity
@Table(name = "local_search")
public class LocalSearch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "local_search_id")
    private Long id;

    private String addressName;
    private String roadAddressName;
    private String placeName;
    private String placeUrl;

    private SearchType searchType;
    private int originalOrder;
    private Score score;
    private final List<LocalSearch> similarities = new ArrayList<>();

    protected LocalSearch() {
    }

    public LocalSearch(String addressName, String roadAddressName, String placeName, String placeUrl, SearchType searchType) {
        this.addressName = addressName;
        this.roadAddressName = roadAddressName;
        this.placeName = placeName;
        this.placeUrl = placeUrl;
        this.searchType = searchType;
        this.score = new Score(0);
    }

    public void determineOrder(int order) {
        this.originalOrder = order;
    }

    public void increaseScore() {
        this.score = score.increase(1);
    }

    public void addSimilarLocalSearch(LocalSearch similar) {
        this.similarities.add(similar);
    }

    public boolean isSimilar(LocalSearch localSearch) {
        return this.similarities.contains(localSearch);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalSearch that = (LocalSearch) o;
        return Objects.equals(getAddressName(), that.getAddressName()) && Objects.equals(getRoadAddressName(), that.getRoadAddressName()) && Objects.equals(getPlaceName(), that.getPlaceName()) && Objects.equals(getPlaceUrl(), that.getPlaceUrl()) && getSearchType() == that.getSearchType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddressName(), getRoadAddressName(), getPlaceName(), getPlaceUrl(), getSearchType());
    }
}
