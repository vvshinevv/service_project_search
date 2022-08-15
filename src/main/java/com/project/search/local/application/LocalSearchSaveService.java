package com.project.search.local.application;

import com.project.search.common.util.Streams;
import com.project.search.local.application.dto.LocalSearchSaveDto;
import com.project.search.local.application.dto.LocalSearchesSaveDto;
import com.project.search.local.domain.AnalogyMeasurement;
import com.project.search.local.domain.LocalSearch;
import com.project.search.local.domain.LocalSearchRepository;
import com.project.search.local.domain.SearchType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalSearchSaveService {
    private final LocalSearchRepository localSearchRepository;
    private final AnalogyMeasurement analogyMeasurement;

    public LocalSearchSaveService(
            LocalSearchRepository localSearchRepository,
            @Qualifier("simpleAnalogyMeasurement") AnalogyMeasurement analogyMeasurement) {
        this.localSearchRepository = localSearchRepository;
        this.analogyMeasurement = analogyMeasurement;
    }

    @Transactional
    public void saveLocalSearch(LocalSearchesSaveDto localSearchesSaveDto) {
        String keyword = localSearchesSaveDto.getKeyword();
        List<LocalSearch> transients = Streams.ofNullable(localSearchesSaveDto.getItems())
                .map(i -> toDomain(keyword, i))
                .collect(Collectors.toList());

        List<LocalSearch> persists = new ArrayList<>();
        List<LocalSearch> manages = localSearchRepository.findLocalSearchByKeyword(keyword);
        for (LocalSearch trans : transients) {
            boolean isSimilar = false;
            for (LocalSearch manage : manages) {
                if (analogyMeasurement.measureAnalogy(trans, manage)) {
                    isSimilar = true;
                }
            }

            if (!isSimilar) {
                persists.add(trans);
            }
        }

        localSearchRepository.saveAll(persists);
    }

    private LocalSearch toDomain(String keyword, LocalSearchSaveDto dto) {
        return new LocalSearch(keyword, dto.getAddressName(), dto.getRoadAddressName(), dto.getPlaceName(), dto.getPlaceUrl(),
                SearchType.of(dto.getSearchType()));
    }
}
