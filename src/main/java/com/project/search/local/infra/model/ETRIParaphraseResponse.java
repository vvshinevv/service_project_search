package com.project.search.local.infra.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ETRIParaphraseResponse {
    @JsonProperty("request_id")
    private String requestId;

    @JsonProperty("result")
    private int result;

    @JsonProperty("return_object")
    private ETRIReturnObjectResponse etriReturnObjectResponse;
}
