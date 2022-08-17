package com.project.search.local.infra.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ETRIArgumentRequest {
    @JsonProperty("sentence1")
    private String sentence1;
    @JsonProperty("sentence2")
    private String sentence2;

    protected ETRIArgumentRequest() {
    }

    public ETRIArgumentRequest(String sentence1, String sentence2) {
        this.sentence1 = sentence1;
        this.sentence2 = sentence2;
    }
}
