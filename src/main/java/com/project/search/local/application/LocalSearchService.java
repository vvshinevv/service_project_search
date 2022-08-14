package com.project.search.local.application;

import com.project.search.local.application.dto.LocalSearchSummary;
import com.project.search.local.domain.AnalogyMeasurement;
import com.project.search.local.domain.LocalSearchContainer;
import com.project.search.local.domain.LocalSearchContainers;
import com.project.search.local.domain.LocalSearchFinder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalSearchService {
    private final List<LocalSearchFinder> localSearchFinders;
    private final AnalogyMeasurement simpleAnalogyMeasurement;

    public LocalSearchService(
            List<LocalSearchFinder> localSearchFinders,
            AnalogyMeasurement simpleAnalogyMeasurement
    ) {
        this.localSearchFinders = localSearchFinders;
        this.simpleAnalogyMeasurement = simpleAnalogyMeasurement;
    }

    public LocalSearchSummary searchLocalByKeyWord(final String keyWord) {
        List<LocalSearchContainer> collect = localSearchFinders.stream()
                .map(i -> i.findLocalSearchByKeyword(keyWord))
                .collect(Collectors.toList());

        LocalSearchContainers containers = new LocalSearchContainers(collect);
        containers.decideScoreWithAnalogyMeasurement(simpleAnalogyMeasurement);


        return null;
    }
}
