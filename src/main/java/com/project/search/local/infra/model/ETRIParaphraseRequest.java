package com.project.search.local.infra.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ETRIParaphraseRequest {
    @JsonProperty("request_id")
    private String requestId;
    @JsonProperty("access_key")
    private String accessKey;
    @JsonProperty("argument")
    private ETRIArgumentRequest ETRIArgumentRequest;

    protected ETRIParaphraseRequest() {
    }

    public ETRIParaphraseRequest(String requestId, String accessKey, ETRIArgumentRequest ETRIArgumentRequest) {
        this.requestId = requestId;
        this.accessKey = accessKey;
        this.ETRIArgumentRequest = ETRIArgumentRequest;
    }
}
