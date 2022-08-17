package com.project.search.local.infra;

import com.project.search.local.domain.LocalSearch;
import com.project.search.local.fixture.LocalSearchFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ETRIAnalogyMeasurementTest {
    @Autowired
    private ETRIAnalogyMeasurement etriAnalogyMeasurement;

    @BeforeEach
    void setup() {
    }

    @DisplayName("ETRI_문장_패러프레이즈_인식_API를_활용하여_문장_유사성_테스트")
    @Test
    void ETRI_문장_패러프레이즈_인식_API를_활용하여_문장_유사성_테스트() {
        LocalSearch 네이버_검색1 = LocalSearchFixture.카카오_아지트_네이버_결과1();
        LocalSearch 카카오_검색1 = LocalSearchFixture.카카오_아지트_카카오_결과1();
        boolean expected = etriAnalogyMeasurement.measureAnalogy(네이버_검색1, 카카오_검색1);
        assertThat(expected).isEqualTo(true);
    }
}

