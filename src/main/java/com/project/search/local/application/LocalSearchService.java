package com.project.search.local.application;

import com.project.search.common.util.Streams;
import com.project.search.local.application.dto.LocalSearchSummary;
import com.project.search.local.application.dto.LocalSearchesSummary;
import com.project.search.local.domain.AnalogyMeasurement;
import com.project.search.local.domain.LocalSearch;
import com.project.search.local.domain.LocalSearchContainer;
import com.project.search.local.domain.LocalSearchContainers;
import com.project.search.local.domain.LocalSearchFinder;
import com.project.search.local.domain.comparator.OriginalOrderComparator;
import com.project.search.local.domain.comparator.ScoreComparator;
import com.project.search.local.domain.comparator.SearchTypeComparator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalSearchService {
    private final List<LocalSearchFinder> localSearchFinders;
    private final AnalogyMeasurement analogyMeasurement;

    public LocalSearchService(
            List<LocalSearchFinder> localSearchFinders,
            @Qualifier("simpleAnalogyMeasurement") AnalogyMeasurement analogyMeasurement
    ) {
        this.localSearchFinders = localSearchFinders;
        this.analogyMeasurement = analogyMeasurement;
    }

    public LocalSearchesSummary searchLocalByKeyWord(final String keyWord) {
        // 카카오 네이버 오픈 API를 통해 데이터를 가져옴
        List<LocalSearchContainer> collect = localSearchFinders.stream()
                .map(i -> i.findLocalSearchByKeyword(keyWord, i.defaultPage(), i.defaultSize()))
                .collect(Collectors.toList());
        LocalSearchContainers containers = new LocalSearchContainers(collect);

        // 유사한 장소를 판단하고 동일하게 나타나는 문서(장소)에 높은 점수를 매김
        containers.decideScoreWithAnalogyMeasurement(analogyMeasurement);
        List<LocalSearch> mergedLocalSearch = containers.mergeLocalSearch();

        // 우선 순위에 따른 정렬
        mergedLocalSearch.sort(new SearchTypeComparator().thenComparing(new ScoreComparator()).thenComparing(new OriginalOrderComparator()));
        return new LocalSearchesSummary(toSummary(mergedLocalSearch));
    }

    private List<LocalSearchSummary> toSummary(List<LocalSearch> localSearches) {
        return Streams.ofNullable(localSearches)
                .map(i -> new LocalSearchSummary(i.getAddressName(), i.getRoadAddressName(), i.getPlaceName(), i.getPlaceUrl()))
                .collect(Collectors.toList());
    }
}
