package com.project.search.local.infra.kakao;

import com.project.search.local.domain.LocalSearchContainer;
import com.project.search.local.domain.LocalSearchFinder;
import com.project.search.local.infra.kakao.model.LocalSearchKakaoContainerResponse;
import com.project.search.local.infra.kakao.model.LocalSearchKakaoRequest;
import com.project.search.local.infra.kakao.model.SortType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LocalSearchKakaoFinder implements LocalSearchFinder {
    private final LocalSearchKakaoClient localSearchKakaoClient;

    public LocalSearchKakaoFinder(LocalSearchKakaoClient localSearchKakaoClient) {
        this.localSearchKakaoClient = localSearchKakaoClient;
    }

    @Override
    public LocalSearchContainer findLocalSearchByKeyword(String keyword) {
        LocalSearchKakaoRequest request = new LocalSearchKakaoRequest(keyword, 1, 15, SortType.ACCURACY);
        LocalSearchKakaoContainerResponse response = localSearchKakaoClient.searchLocalByKeyWord(request);
        return response.toDomain();
    }
}
