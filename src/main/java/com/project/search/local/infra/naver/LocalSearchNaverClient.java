package com.project.search.local.infra.naver;

import com.project.search.local.infra.naver.execption.LocalSearchNaverClientException;
import com.project.search.local.infra.naver.model.LocalSearchNaverContainerResponse;
import com.project.search.local.infra.naver.model.LocalSearchNaverRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Component
public class LocalSearchNaverClient {
    private final String restClientKey;
    private final String restClientSecretKey;
    private final String restApiUrl;
    private final RestTemplate localSearchKakaoRestTemplate;

    public LocalSearchNaverClient(
            @Value("${naver.rest.api.client.key}") String restClientKey,
            @Value("${naver.rest.api.client.secret}") String restClientSecretKey,
            @Value("${naver.rest.api.url}") String restApiUrl,
            RestTemplate localSearchKakaoRestTemplate
    ) {
        this.restClientKey = restClientKey;
        this.restClientSecretKey = restClientSecretKey;
        this.restApiUrl = restApiUrl;
        this.localSearchKakaoRestTemplate = localSearchKakaoRestTemplate;
    }

    private HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Naver-Client-Id", restClientKey);
        headers.set("X-Naver-Client-Secret", restClientSecretKey);
        return headers;
    }

    public LocalSearchNaverContainerResponse searchLocalByKeyWord(LocalSearchNaverRequest request) {
        HttpHeaders headers = headers();
        HttpEntity<Void> httpEntity = new HttpEntity<>(headers);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("query", request.getQuery());
        params.add("display", String.valueOf(request.getDisplay()));
        params.add("start", String.valueOf(request.getStart()));
        params.add("sort", request.getSort().getName());

        URI uri = UriComponentsBuilder.fromUriString(restApiUrl + "/search/local.json")
                .queryParams(params)
                .build()
                .toUri();

        try {
            ResponseEntity<LocalSearchNaverContainerResponse> response = localSearchKakaoRestTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    httpEntity,
                    LocalSearchNaverContainerResponse.class
            );

            return response.getBody();
        } catch (LocalSearchNaverClientException exception) {
            log.error("LocalSearchKakaoClientException is occurred while invoking searchLocalByKeyWord() method :: ", exception);
            throw exception;
        }
    }

}
