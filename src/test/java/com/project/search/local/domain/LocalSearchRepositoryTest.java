package com.project.search.local.domain;

import com.project.search.local.fixture.LocalSearchFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class LocalSearchRepositoryTest {
    @Autowired
    private LocalSearchRepository localSearchRepository;

    @DisplayName("지역_키워드_검색_저장_테스트")
    @Test
    void 지역_키워드_검색_저장_테스트() {
        // given
        LocalSearch localSearch = LocalSearchFixture.카카오_아지트_네이버_결과1();

        // when
        LocalSearch persist = localSearchRepository.save(localSearch);

        // then
        assertThat(localSearch).isEqualTo(persist);
    }
}
