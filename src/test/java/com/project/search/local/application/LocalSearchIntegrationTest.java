package com.project.search.local.application;

import com.project.search.count.command.domain.SearchCount;
import com.project.search.count.command.domain.SearchCountRepository;
import com.project.search.count.command.vo.Count;
import com.project.search.local.application.dto.LocalSearchesSummary;
import com.project.search.local.domain.LocalSearch;
import com.project.search.local.domain.LocalSearchRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest
public class LocalSearchIntegrationTest {
    @Autowired
    private LocalSearchService localSearchService;
    @Autowired
    private LocalSearchRepository localSearchRepository;
    @Autowired
    private SearchCountRepository searchCountRepository;

    @DisplayName("지역_키워드_검색_통합_테스트")
    @Test
    void 지역_키워드_검색_통합_테스트() {
        // given
        LocalSearchesSummary expected = localSearchService.searchLocalByKeyword("카카오 아지트");

        // when
        SearchCount searchCountActual = searchCountRepository.findSearchCountByKeyword("카카오 아지트").get();
        List<LocalSearch> localSearchActual = localSearchRepository.findLocalSearchByKeyword("카카오 아지트");

        // then
        assertThat(searchCountActual.getCount()).isEqualTo(new Count(1));
        assertThat(localSearchActual.size()).isEqualTo(expected.getItems().size());
    }
}
