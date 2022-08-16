package com.project.search.local.domain;

import com.project.search.local.fixture.LocalSearchFixture;
import com.project.search.local.infra.TestAnalogyMeasurement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LocalSearchContainersTest {
    @DisplayName("API요청_이후_검색_결과_순서_결정_테스트")
    @Test
    void API요청_이후_검색_결과_순서_결정_테스트() {
        // given
        LocalSearch 카카오_검색1 = LocalSearchFixture.카카오_아지트_카카오_결과1(); // 네이버 결과 1과 유사
        LocalSearch 카카오_검색2 = LocalSearchFixture.카카오_아지트_카카오_결과2(); // 네이버 결과 4와 유사
        LocalSearch 카카오_검색3 = LocalSearchFixture.카카오_아지트_카카오_결과3();
        LocalSearch 카카오_검색4 = LocalSearchFixture.카카오_아지트_카카오_결과4();
        LocalSearch 카카오_검색5 = LocalSearchFixture.카카오_아지트_카카오_결과5(); // 네이버 결과 3과 유사
        LocalSearch 카카오_검색6 = LocalSearchFixture.카카오_아지트_카카오_결과6();
        LocalSearch 카카오_검색7 = LocalSearchFixture.카카오_아지트_카카오_결과7();
        LocalSearch 카카오_검색8 = LocalSearchFixture.카카오_아지트_카카오_결과8(); // 네이버 결과 2와 유사
        LocalSearch 카카오_검색9 = LocalSearchFixture.카카오_아지트_카카오_결과9();
        LocalSearch 카카오_검색10 = LocalSearchFixture.카카오_아지트_카카오_결과10();
        List<LocalSearch> 카카오_검색_결과들 = Arrays.asList(카카오_검색1, 카카오_검색2, 카카오_검색3, 카카오_검색4, 카카오_검색5, 카카오_검색6, 카카오_검색7, 카카오_검색8, 카카오_검색9, 카카오_검색10);
        LocalSearchContainer 카카오_검색_결과_컨테이너 = new LocalSearchContainer(SearchType.KAKAO, 카카오_검색_결과들, 1, 10, false);

        LocalSearch 네이버_검색1 = LocalSearchFixture.카카오_아지트_네이버_결과1();
        LocalSearch 네이버_검색2 = LocalSearchFixture.카카오_아지트_네이버_결과2();
        LocalSearch 네이버_검색3 = LocalSearchFixture.카카오_아지트_네이버_결과3();
        LocalSearch 네이버_검색4 = LocalSearchFixture.카카오_아지트_네이버_결과4();
        LocalSearch 네이버_검색5 = LocalSearchFixture.카카오_아지트_네이버_결과5();
        List<LocalSearch> 네이버_검색_결과들 = Arrays.asList(네이버_검색1, 네이버_검색2, 네이버_검색3, 네이버_검색4, 네이버_검색5);
        LocalSearchContainer 네이버_검색_결과_컨테이너 = new LocalSearchContainer(SearchType.NAVER, 네이버_검색_결과들, 1, 5, true);

        // when
        LocalSearchContainers 컨테이너들 = new LocalSearchContainers(Arrays.asList(카카오_검색_결과_컨테이너, 네이버_검색_결과_컨테이너));
        컨테이너들.decideScoreWithAnalogyMeasurement(new TestAnalogyMeasurement());

        // then
        assertThat(컨테이너들.getContainers().get(0).getItems().get(0).getScore()).isEqualTo(new Score(1));
        assertThat(컨테이너들.getContainers().get(0).getItems().get(1).getScore()).isEqualTo(new Score(1));
        assertThat(컨테이너들.getContainers().get(0).getItems().get(2).getScore()).isEqualTo(new Score(0));
        assertThat(컨테이너들.getContainers().get(0).getItems().get(3).getScore()).isEqualTo(new Score(0));
        assertThat(컨테이너들.getContainers().get(0).getItems().get(4).getScore()).isEqualTo(new Score(1));
        assertThat(컨테이너들.getContainers().get(0).getItems().get(5).getScore()).isEqualTo(new Score(0));
        assertThat(컨테이너들.getContainers().get(0).getItems().get(6).getScore()).isEqualTo(new Score(0));
        assertThat(컨테이너들.getContainers().get(0).getItems().get(7).getScore()).isEqualTo(new Score(1));
        assertThat(컨테이너들.getContainers().get(0).getItems().get(8).getScore()).isEqualTo(new Score(0));
        assertThat(컨테이너들.getContainers().get(0).getItems().get(9).getScore()).isEqualTo(new Score(0));

        assertThat(컨테이너들.getContainers().get(1).getItems().get(0).getScore()).isEqualTo(new Score(1));
        assertThat(컨테이너들.getContainers().get(1).getItems().get(1).getScore()).isEqualTo(new Score(1));
        assertThat(컨테이너들.getContainers().get(1).getItems().get(2).getScore()).isEqualTo(new Score(1));
        assertThat(컨테이너들.getContainers().get(1).getItems().get(3).getScore()).isEqualTo(new Score(1));
        assertThat(컨테이너들.getContainers().get(1).getItems().get(4).getScore()).isEqualTo(new Score(0));
    }

    @DisplayName("유사성이_없는_문서를_고려해서_두_검색_결과를_합치는_테스트")
    @Test
    void 유사성이_없는_문서를_고려해서_두_검색_결과를_합치는_테스트() {
        // given
        LocalSearch 카카오_검색1 = LocalSearchFixture.카카오_아지트_카카오_결과1(); // 네이버 결과 1과 유사
        LocalSearch 카카오_검색2 = LocalSearchFixture.카카오_아지트_카카오_결과2(); // 네이버 결과 4와 유사
        LocalSearch 카카오_검색3 = LocalSearchFixture.카카오_아지트_카카오_결과3();
        LocalSearch 카카오_검색4 = LocalSearchFixture.카카오_아지트_카카오_결과4();
        LocalSearch 카카오_검색5 = LocalSearchFixture.카카오_아지트_카카오_결과5(); // 네이버 결과 3과 유사
        LocalSearch 카카오_검색6 = LocalSearchFixture.카카오_아지트_카카오_결과6();
        LocalSearch 카카오_검색7 = LocalSearchFixture.카카오_아지트_카카오_결과7();
        LocalSearch 카카오_검색8 = LocalSearchFixture.카카오_아지트_카카오_결과8(); // 네이버 결과 2와 유사
        LocalSearch 카카오_검색9 = LocalSearchFixture.카카오_아지트_카카오_결과9();
        LocalSearch 카카오_검색10 = LocalSearchFixture.카카오_아지트_카카오_결과10();
        List<LocalSearch> 카카오_검색_결과들 = Arrays.asList(카카오_검색1, 카카오_검색2, 카카오_검색3, 카카오_검색4, 카카오_검색5, 카카오_검색6, 카카오_검색7, 카카오_검색8, 카카오_검색9, 카카오_검색10);
        LocalSearchContainer 카카오_검색_결과_컨테이너 = new LocalSearchContainer(SearchType.KAKAO, 카카오_검색_결과들, 1, 10, false);

        LocalSearch 네이버_검색1 = LocalSearchFixture.카카오_아지트_네이버_결과1();
        LocalSearch 네이버_검색2 = LocalSearchFixture.카카오_아지트_네이버_결과2();
        LocalSearch 네이버_검색3 = LocalSearchFixture.카카오_아지트_네이버_결과3();
        LocalSearch 네이버_검색4 = LocalSearchFixture.카카오_아지트_네이버_결과4();
        LocalSearch 네이버_검색5 = LocalSearchFixture.카카오_아지트_네이버_결과5();
        List<LocalSearch> 네이버_검색_결과들 = Arrays.asList(네이버_검색1, 네이버_검색2, 네이버_검색3, 네이버_검색4, 네이버_검색5);
        LocalSearchContainer 네이버_검색_결과_컨테이너 = new LocalSearchContainer(SearchType.NAVER, 네이버_검색_결과들, 1, 5, true);

        // when
        LocalSearchContainers 컨테이너들 = new LocalSearchContainers(Arrays.asList(카카오_검색_결과_컨테이너, 네이버_검색_결과_컨테이너));
        컨테이너들.decideScoreWithAnalogyMeasurement(new TestAnalogyMeasurement());
        List<LocalSearch> expected = 컨테이너들.mergeLocalSearch();

        // then
        assertThat(expected.size()).isEqualTo(11);
    }
}
