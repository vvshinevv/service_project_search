package com.project.search.local.infra.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ETRIReturnObjectResponse {
    @JsonProperty("result")
    private String result;
}
