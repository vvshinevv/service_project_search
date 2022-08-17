package com.project.search.local.acceptance;

import com.project.search.AcceptanceTest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.project.search.local.acceptance.step.LocalAcceptanceStep.키워드_검색을_요청한다;
import static com.project.search.local.acceptance.step.LocalAcceptanceStep.키워드가_검색되었는지_검증한다;

@DisplayName("지역 키워드 검색 인수테스트")
public class LocalSearchAcceptanceTest extends AcceptanceTest {
    @DisplayName("키워드를_통해_지역을_검색한다.")
    @Test
    void 키워드를_통해_지역을_검색() {
        // given
        String keyword = "카카오 아지트";
        ExtractableResponse<Response> 검색된_내용 = 키워드_검색을_요청한다(keyword);

        // then
        키워드가_검색되었는지_검증한다(keyword);
    }
}
