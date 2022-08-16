package com.project.search.local.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Objects;

@Getter
@Entity
@Table(name = "local_search")
public class LocalSearch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "local_search_id")
    private Long id;

    @Column(name = "keyword")
    private String keyword;

    @Column(name = "address_name")
    private String addressName;

    @Column(name = "road_address_name")
    private String roadAddressName;

    @Column(name = "place_name")
    private String placeName;

    @Column(name = "place_url")
    private String placeUrl;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "saerch_type")
    private SearchType searchType;

    @Transient
    private int originalOrder;

    @Transient
    private Score score;

    protected LocalSearch() {
    }

    public LocalSearch(String keyword, String addressName, String roadAddressName, String placeName, String placeUrl, SearchType searchType) {
        this.keyword = keyword;
        this.addressName = addressName;
        this.roadAddressName = roadAddressName;
        this.placeName = placeName;
        this.placeUrl = placeUrl;
        this.searchType = searchType;
        this.score = new Score(0);
    }

    public void determineOriginalOrder(int order) {
        this.originalOrder = order;
    }

    public void increaseScore() {
        this.score = score.increase(1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalSearch that = (LocalSearch) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
