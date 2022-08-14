package com.project.search.local.infra.naver;

import com.project.search.local.application.exception.LocalSearchClientException;
import com.project.search.local.domain.LocalSearchContainer;
import com.project.search.local.domain.LocalSearchFinder;
import com.project.search.local.infra.naver.model.LocalSearchNaverContainerResponse;
import com.project.search.local.infra.naver.model.LocalSearchNaverRequest;
import com.project.search.local.infra.naver.model.SortType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LocalSearchNaverFinder implements LocalSearchFinder {
    private final LocalSearchNaverClient localSearchNaverClient;

    public LocalSearchNaverFinder(LocalSearchNaverClient localSearchNaverClient) {
        this.localSearchNaverClient = localSearchNaverClient;
    }

    @Override
    @Retryable(value = LocalSearchClientException.class, maxAttempts = 2, backoff = @Backoff(delay = 500))
    public LocalSearchContainer findLocalSearchByKeyword(String keyword) {
        LocalSearchNaverRequest request = new LocalSearchNaverRequest(keyword, 5, 1, SortType.RANDOM);
        LocalSearchNaverContainerResponse response = localSearchNaverClient.searchLocalByKeyWord(request);
        return response.toDomain();
    }
}