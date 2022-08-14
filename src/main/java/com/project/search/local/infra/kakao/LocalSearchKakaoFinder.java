package com.project.search.local.infra.kakao;

import com.project.search.local.application.exception.LocalSearchClientException;
import com.project.search.local.domain.LocalSearchContainer;
import com.project.search.local.domain.LocalSearchFinder;
import com.project.search.local.infra.kakao.model.LocalSearchKakaoContainerResponse;
import com.project.search.local.infra.kakao.model.LocalSearchKakaoRequest;
import com.project.search.local.infra.kakao.model.SortType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class LocalSearchKakaoFinder implements LocalSearchFinder {
    private final LocalSearchKakaoClient localSearchKakaoClient;

    public LocalSearchKakaoFinder(LocalSearchKakaoClient localSearchKakaoClient) {
        this.localSearchKakaoClient = localSearchKakaoClient;
    }

    @Override
    @Retryable(value = LocalSearchClientException.class, maxAttempts = 2, backoff = @Backoff(delay = 500))
    public LocalSearchContainer findLocalSearchByKeyword(String keyword) {
        LocalSearchKakaoRequest request = new LocalSearchKakaoRequest(keyword, 1, 15, SortType.ACCURACY);
        LocalSearchKakaoContainerResponse response = localSearchKakaoClient.searchLocalByKeyWord(request);
        return response.toDomain();
    }
}
