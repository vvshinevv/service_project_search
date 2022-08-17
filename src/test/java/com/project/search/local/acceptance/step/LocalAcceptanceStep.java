package com.project.search.local.acceptance.step;

import com.project.search.count.query.application.dto.SearchCountSummary;
import com.project.search.count.query.application.dto.SearchCountsSummary;
import com.project.search.utils.HttpUtil;
import io.restassured.http.Header;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LocalAcceptanceStep {
    private static final String API_URL = "/local/search";

    private static Header createHeader() {
        return new Header("Content-Type", "application/json; charset=utf8");
    }

    public static ExtractableResponse<Response> 키워드_검색을_요청한다(String keyword) {
        return HttpUtil.get(API_URL + "?keyword=" + keyword, createHeader());
    }

    public static void 키워드가_검색되었는지_검증한다(String keyword) {
        ExtractableResponse<Response> 검색_탑_10 = HttpUtil.get("/search/count", createHeader());
        SearchCountsSummary 결과 = 검색_탑_10.as(SearchCountsSummary.class);
        assertThat(결과.getSummaries().contains(new SearchCountSummary(keyword, 1))).isEqualTo(true);
    }
}
