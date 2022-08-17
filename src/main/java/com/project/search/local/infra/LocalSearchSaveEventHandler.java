package com.project.search.local.infra;

import com.project.search.common.util.Streams;
import com.project.search.local.application.LocalSearchSaveService;
import com.project.search.local.application.dto.LocalSearchSaveDto;
import com.project.search.local.application.dto.LocalSearchSummary;
import com.project.search.local.application.dto.LocalSearchesSaveDto;
import com.project.search.local.application.dto.LocalSearchesSummary;
import com.project.search.local.domain.LocalSearchSaveEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocalSearchSaveEventHandler {
    private final LocalSearchSaveService localSearchSaveService;

    public LocalSearchSaveEventHandler(LocalSearchSaveService localSearchSaveService) {
        this.localSearchSaveService = localSearchSaveService;
    }

    @Async
    @TransactionalEventListener(
            classes = LocalSearchSaveEvent.class,
            phase = TransactionPhase.AFTER_COMMIT
    )
    public void handler(LocalSearchSaveEvent localSearchSaveEvent) {
        localSearchSaveService.saveLocalSearch(toDto(localSearchSaveEvent));
    }

    private LocalSearchesSaveDto toDto(LocalSearchSaveEvent event) {
        LocalSearchesSummary summary = event.getLocalSearchesSummary();
        return new LocalSearchesSaveDto(summary.getKeyword(), toDto(summary.getItems()));
    }

    private List<LocalSearchSaveDto> toDto(List<LocalSearchSummary> summaries) {
        return Streams.ofNullable(summaries).map(this::toDto).collect(Collectors.toList());
    }

    private LocalSearchSaveDto toDto(LocalSearchSummary summary) {
        return new LocalSearchSaveDto(
                summary.getAddressName(),
                summary.getRoadAddressName(),
                summary.getPlaceName(),
                summary.getPlaceUrl(),
                summary.getSearchType()
        );
    }
}
