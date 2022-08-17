package com.project.search.local.infra;

import com.project.search.local.domain.LocalSearchFinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LocalSearchNaverFinderTest {
    @Autowired
    private LocalSearchFinder localSearchNaverFinder;

    @BeforeEach
    void setup() {
    }

    @DisplayName("네이버_오픈_API를_활용하여_키워드로_장소_검색_테스트")
    @Test
    void 네이버_오픈_API를_활용하여_키워드로_장소_검색_테스트() {
        localSearchNaverFinder.findLocalSearchByKeyword("카카오 아지트", 1, 5);
    }
}
