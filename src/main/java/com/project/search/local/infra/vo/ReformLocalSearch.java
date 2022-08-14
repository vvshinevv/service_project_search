package com.project.search.local.infra.vo;

import com.project.search.local.domain.LocalSearch;
import lombok.Getter;

import java.util.Objects;

@Getter
public class ReformLocalSearch {
    private final String addressName;
    private final String roadAddressName;
    private final String placeName;

    private ReformLocalSearch(String addressName, String roadAddressName, String placeName) {
        this.addressName = addressName;
        this.roadAddressName = roadAddressName;
        this.placeName = placeName;
    }

    public static ReformLocalSearch of(LocalSearch localSearch) {
        return new ReformLocalSearch(
                reform(localSearch.getAddressName()),
                reform(localSearch.getRoadAddressName()),
                reform(localSearch.getPlaceName())
        );
    }

    private static String reform(String target) {
        return target.replaceAll("\\s+|<b>|</b>", "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReformLocalSearch that = (ReformLocalSearch) o;
        return Objects.equals(getAddressName(), that.getAddressName()) && Objects.equals(getRoadAddressName(), that.getRoadAddressName()) && Objects.equals(getPlaceName(), that.getPlaceName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddressName(), getRoadAddressName(), getPlaceName());
    }
}
