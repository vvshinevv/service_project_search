package com.project.search.local.infra;

import com.project.search.local.infra.exception.ETRIClientException;
import com.project.search.local.infra.model.ETRIParaphraseRequest;
import com.project.search.local.infra.model.ETRIParaphraseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Component
public class ETRIAnalogyClient {
    private final String restApiUrl;
    private final RestTemplate etriRestTemplate;

    public ETRIAnalogyClient(
            @Value("${etri.rest.api.url}") String restApiUrl,
            RestTemplate etriRestTemplate
    ) {
        this.restApiUrl = restApiUrl;
        this.etriRestTemplate = etriRestTemplate;
    }

    private HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    public ETRIParaphraseResponse queryParaphraseAnalogy(ETRIParaphraseRequest request) {
        HttpHeaders headers = headers();
        HttpEntity<ETRIParaphraseRequest> httpEntity = new HttpEntity<>(request, headers);

        URI uri = UriComponentsBuilder.fromUriString(restApiUrl + "/ParaphraseQA")
                .build()
                .toUri();

        try {
            ResponseEntity<ETRIParaphraseResponse> response = etriRestTemplate.exchange(
                    uri,
                    HttpMethod.POST,
                    httpEntity,
                    ETRIParaphraseResponse.class
            );

            return response.getBody();
        } catch (ETRIClientException exception) {
            log.error("ETRIClientException is occurred while invoking queryParaphraseAnalogy method :: ", exception);
            throw exception;
        }
    }
}
