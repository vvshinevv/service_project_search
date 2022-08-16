package com.project.search.local.domain;

import com.project.search.local.fixture.LocalSearchFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DirtiesContext()
public class LocalSearchTest {
    @DisplayName("스코어_증가_테스트")
    @Test
    void 스코어_증가_테스트() {
        // given
        LocalSearch 카카오_검색1 = LocalSearchFixture.카카오_아지트_카카오_결과1();

        // when
        카카오_검색1.increaseScore();

        // then
        assertThat(카카오_검색1.getScore()).isEqualTo(new Score(1));
    }
}
