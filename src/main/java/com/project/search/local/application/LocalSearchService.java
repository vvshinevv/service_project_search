package com.project.search.local.application;

import com.project.search.common.event.Events;
import com.project.search.common.util.Streams;
import com.project.search.count.command.domain.SearchCountEvent;
import com.project.search.local.application.dto.LocalSearchSummary;
import com.project.search.local.application.dto.LocalSearchesSummary;
import com.project.search.local.application.exception.LocalSearchClientException;
import com.project.search.local.domain.AnalogyMeasurement;
import com.project.search.local.domain.LocalSearch;
import com.project.search.local.domain.LocalSearchContainer;
import com.project.search.local.domain.LocalSearchContainers;
import com.project.search.local.domain.LocalSearchFinder;
import com.project.search.local.domain.LocalSearchRepository;
import com.project.search.local.domain.LocalSearchSaveEvent;
import com.project.search.local.domain.comparator.OriginalOrderComparator;
import com.project.search.local.domain.comparator.ScoreComparator;
import com.project.search.local.domain.comparator.SearchTypeComparator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalSearchService {
    private final List<LocalSearchFinder> localSearchFinders;
    private final AnalogyMeasurement analogyMeasurement;
    private final LocalSearchRepository localSearchRepository;

    public LocalSearchService(
            List<LocalSearchFinder> localSearchFinders,
            @Qualifier("ETRIAnalogyMeasurement") AnalogyMeasurement analogyMeasurement,
            LocalSearchRepository localSearchRepository
    ) {
        this.localSearchFinders = localSearchFinders;
        this.analogyMeasurement = analogyMeasurement;
        this.localSearchRepository = localSearchRepository;
    }

    @Transactional
    public LocalSearchesSummary searchLocalByKeywordWithFailover(final String keyword) {
        try {
            return searchLocalByKeyword(keyword);
        } catch (LocalSearchClientException exception) {
            List<LocalSearch> localSearches = Streams.ofNullable(localSearchRepository.findLocalSearchByKeyword(keyword))
                    .limit(10)
                    .collect(Collectors.toList());

            return new LocalSearchesSummary(keyword, toSummary(localSearches));
        }
    }

    @Transactional
    public LocalSearchesSummary searchLocalByKeyword(final String keyword) {
        // ????????? ????????? ?????? API??? ?????? ???????????? ?????????
        List<LocalSearchContainer> collect = localSearchFinders.stream()
                .map(i -> i.findLocalSearchByKeyword(keyword, i.defaultPage(), i.defaultSize()))
                .collect(Collectors.toList());
        LocalSearchContainers containers = new LocalSearchContainers(collect);

        // ????????? ????????? ???????????? ???????????? ???????????? ??????(??????)??? ?????? ????????? ??????
        containers.decideScoreWithAnalogyMeasurement(analogyMeasurement);

        // ????????? ????????? ?????? ????????? ??????(?????????)??? ???????????? ?????????
        List<LocalSearch> mergedLocalSearch = containers.mergeLocalSearch();

        // ?????? ????????? ?????? ??????
        mergedLocalSearch.sort(new SearchTypeComparator().thenComparing(new ScoreComparator()).thenComparing(new OriginalOrderComparator()));

        // ?????? 10???
        List<LocalSearch> results = Streams.ofNullable(mergedLocalSearch).limit(10).collect(Collectors.toList());

        // ????????? ????????? ????????? ??????
        Events.raise(new SearchCountEvent(keyword));
        LocalSearchesSummary localSearchesSummary = new LocalSearchesSummary(keyword, toSummary(results));

        // failover??? ?????? DB ?????? ????????? ??????
        Events.raise(new LocalSearchSaveEvent(localSearchesSummary));

        return localSearchesSummary;
    }

    private List<LocalSearchSummary> toSummary(List<LocalSearch> localSearches) {
        return Streams.ofNullable(localSearches)
                .map(i -> new LocalSearchSummary(i.getAddressName(), i.getRoadAddressName(), i.getPlaceName(), i.getPlaceUrl(), i.getSearchType().name()))
                .collect(Collectors.toList());
    }
}
