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
        LocalSearchContainer 카카오_검색_결과_컨테이너 = LocalSearchFixture.카카오_검색_컨테이너();
        LocalSearchContainer 네이버_검색_결과_컨테이너 = LocalSearchFixture.네이버_검색_컨테이너();

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
        LocalSearchContainer 카카오_검색_결과_컨테이너 = LocalSearchFixture.카카오_검색_컨테이너();
        LocalSearchContainer 네이버_검색_결과_컨테이너 = LocalSearchFixture.네이버_검색_컨테이너();

        // when
        LocalSearchContainers 컨테이너들 = new LocalSearchContainers(Arrays.asList(카카오_검색_결과_컨테이너, 네이버_검색_결과_컨테이너));
        컨테이너들.decideScoreWithAnalogyMeasurement(new TestAnalogyMeasurement());
        List<LocalSearch> expected = 컨테이너들.mergeLocalSearch();

        // then
        assertThat(expected.size()).isEqualTo(11);
    }
}
