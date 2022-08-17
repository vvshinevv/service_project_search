package com.project.search.local.domain;

import com.project.search.local.fixture.LocalSearchFixture;
import com.project.search.local.infra.TestAnalogyMeasurement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LocalSearchContainerTest {
    @DisplayName("API요청_이후_검색_결과_순서_결정_테스트")
    @Test
    void API요청_이후_검색_결과_순서_결정_테스트() {
        // given
        LocalSearch 네이버_검색1 = LocalSearchFixture.카카오_아지트_네이버_결과1();
        LocalSearch 네이버_검색2 = LocalSearchFixture.카카오_아지트_네이버_결과2();
        LocalSearch 네이버_검색3 = LocalSearchFixture.카카오_아지트_네이버_결과3();
        LocalSearch 네이버_검색4 = LocalSearchFixture.카카오_아지트_네이버_결과4();
        LocalSearch 네이버_검색5 = LocalSearchFixture.카카오_아지트_네이버_결과5();

        List<LocalSearch> 네이버_검색_결과들 = Arrays.asList(네이버_검색1, 네이버_검색2, 네이버_검색3, 네이버_검색4, 네이버_검색5);

        // when
        LocalSearchContainer 컨테이너 = new LocalSearchContainer(SearchType.NAVER, 네이버_검색_결과들, 1, 5, true);
        LocalSearch expected1 = 컨테이너.getItems().get(0);
        LocalSearch expected2 = 컨테이너.getItems().get(1);
        LocalSearch expected3 = 컨테이너.getItems().get(2);
        LocalSearch expected4 = 컨테이너.getItems().get(3);
        LocalSearch expected5 = 컨테이너.getItems().get(4);

        // then
        assertThat(expected1.getOriginalOrder()).isEqualTo(0);
        assertThat(expected2.getOriginalOrder()).isEqualTo(1);
        assertThat(expected3.getOriginalOrder()).isEqualTo(2);
        assertThat(expected4.getOriginalOrder()).isEqualTo(3);
        assertThat(expected5.getOriginalOrder()).isEqualTo(4);
    }

    @DisplayName("유사도_측정_이후_유사하다면_문서의_점수_증가_테스트")
    @Test
    void 유사도_측정_이후_유사하다면_문서의_점수_증가_테스트() {
        // given
        LocalSearchContainer 카카오_검색_결과_컨테이너 = LocalSearchFixture.카카오_검색_컨테이너();

        LocalSearch 네이버_검색1 = LocalSearchFixture.카카오_아지트_네이버_결과1();
        LocalSearch 네이버_검색2 = LocalSearchFixture.카카오_아지트_네이버_결과2();
        LocalSearch 네이버_검색3 = LocalSearchFixture.카카오_아지트_네이버_결과3();
        LocalSearch 네이버_검색4 = LocalSearchFixture.카카오_아지트_네이버_결과4();
        LocalSearch 네이버_검색5 = LocalSearchFixture.카카오_아지트_네이버_결과5();
        List<LocalSearch> 네이버_검색_결과들 = Arrays.asList(네이버_검색1, 네이버_검색2, 네이버_검색3, 네이버_검색4, 네이버_검색5);

        // when
        카카오_검색_결과_컨테이너.decideScoreWithAnalogyMeasurement(네이버_검색_결과들, new TestAnalogyMeasurement());
        LocalSearch expected1 = 카카오_검색_결과_컨테이너.getItems().get(0);
        LocalSearch expected2 = 카카오_검색_결과_컨테이너.getItems().get(1);
        LocalSearch expected3 = 카카오_검색_결과_컨테이너.getItems().get(4);
        LocalSearch expected4 = 카카오_검색_결과_컨테이너.getItems().get(7);
        LocalSearch expected5 = 카카오_검색_결과_컨테이너.getItems().get(2);

        // then
        assertThat(expected1.getScore()).isEqualTo(new Score(1));
        assertThat(expected2.getScore()).isEqualTo(new Score(1));
        assertThat(expected3.getScore()).isEqualTo(new Score(1));
        assertThat(expected4.getScore()).isEqualTo(new Score(1));
        assertThat(expected5.getScore()).isEqualTo(new Score(0));
    }

    @DisplayName("유사성이_없는_문서_찾아내는_테스트")
    @Test
    void 유사성이_없는_문서_찾아내는_테스트() {
        // given
        LocalSearchContainer 카카오_검색_결과_컨테이너 = LocalSearchFixture.카카오_검색_컨테이너();

        LocalSearch 네이버_검색1 = LocalSearchFixture.카카오_아지트_네이버_결과1(); // 유사하므로 제외 대상
        LocalSearch 네이버_검색2 = LocalSearchFixture.카카오_아지트_네이버_결과2(); // 유사하므로 제외 대상
        LocalSearch 네이버_검색3 = LocalSearchFixture.카카오_아지트_네이버_결과3(); // 유사하므로 제외 대상
        LocalSearch 네이버_검색4 = LocalSearchFixture.카카오_아지트_네이버_결과4(); // 유사하므로 제외 대상
        LocalSearch 네이버_검색5 = LocalSearchFixture.카카오_아지트_네이버_결과5();
        List<LocalSearch> 네이버_검색_결과들 = Arrays.asList(네이버_검색1, 네이버_검색2, 네이버_검색3, 네이버_검색4, 네이버_검색5);

        // when
        카카오_검색_결과_컨테이너.decideScoreWithAnalogyMeasurement(네이버_검색_결과들, new TestAnalogyMeasurement());
        List<LocalSearch> expected = 카카오_검색_결과_컨테이너.findNotAnalogyDocuments();

        // then
        assertThat(expected.size()).isEqualTo(6);
        assertThat(expected.get(0).getPlaceName()).isEqualTo("카카오판교아지트 전기차충전소");
    }
}
