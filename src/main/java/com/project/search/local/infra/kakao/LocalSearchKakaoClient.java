package com.project.search.local.infra.kakao;

import com.project.search.local.infra.kakao.exception.LocalSearchKakaoClientException;
import com.project.search.local.infra.kakao.model.LocalSearchKakaoContainerResponse;
import com.project.search.local.infra.kakao.model.LocalSearchKakaoRequest;
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

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Slf4j
@Component
public class LocalSearchKakaoClient {
    private final String restApiKey;
    private final String restApiUrl;
    private final RestTemplate localSearchKakaoRestTemplate;

    public LocalSearchKakaoClient(
            @Value("${kakao.rest.api.key}") String restApiKey,
            @Value("${kakao.rest.api.url}") String restApiUrl,
            RestTemplate localSearchKakaoRestTemplate
    ) {
        this.restApiKey = restApiKey;
        this.restApiUrl = restApiUrl;
        this.localSearchKakaoRestTemplate = localSearchKakaoRestTemplate;
    }

    private HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(AUTHORIZATION, "KakaoAK " + restApiKey);
        return headers;
    }

    public LocalSearchKakaoContainerResponse searchLocalByKeyWord(LocalSearchKakaoRequest request) {
        HttpHeaders headers = headers();
        HttpEntity<Void> httpEntity = new HttpEntity<>(headers);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("query", request.getQuery());
        params.add("page", String.valueOf(request.getPage()));
        params.add("size", String.valueOf(request.getSize()));
        params.add("sort", request.getSort().getName());

        URI uri = UriComponentsBuilder.fromUriString(restApiUrl + "/local/search/keyword.json")
                .queryParams(params)
                .build()
                .toUri();

        try {
            ResponseEntity<LocalSearchKakaoContainerResponse> response = localSearchKakaoRestTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    httpEntity,
                    LocalSearchKakaoContainerResponse.class
            );

            return response.getBody();
        } catch (LocalSearchKakaoClientException exception) {
            log.error("LocalSearchKakaoClientException is occurred while invoking searchLocalByKeyWord() method :: ", exception);
            throw exception;
        }
    }
}
