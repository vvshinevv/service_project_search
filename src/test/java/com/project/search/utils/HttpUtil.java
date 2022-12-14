package com.project.search.utils;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class HttpUtil {

    private HttpUtil() {
    }

    public static <T> ExtractableResponse<Response> post(String url, T body, Header header) {
        return RestAssured
                .given().log().all()
                .header(header)
                .body(body)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().post(url)
                .then().log().all()
                .extract();
    }

    public static <T> ExtractableResponse<Response> post(String url, T body) {
        return RestAssured
                .given().log().all()
                .body(body)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().post(url)
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> post(String url, Header header) {
        return RestAssured
                .given().log().all()
                .header(header)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().post(url)
                .then().log().all()
                .extract();
    }

    public static <T> ExtractableResponse<Response> put(String url, T body, Header header) {
        return RestAssured
                .given().log().all()
                .header(header)
                .body(body)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().put(url)
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> delete(String url, Header header) {
        return RestAssured
                .given().log().all()
                .header(header)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().delete(url)
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> get(String url, Header header) {
        return RestAssured
                .given().log().all()
                .header(header)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get(url)
                .then().log().all()
                .extract();
    }
}
