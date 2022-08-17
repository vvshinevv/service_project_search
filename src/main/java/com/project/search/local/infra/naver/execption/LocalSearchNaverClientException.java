package com.project.search.local.infra.naver.execption;

import com.project.search.local.application.exception.LocalSearchClientException;

public class LocalSearchNaverClientException extends LocalSearchClientException {
    public LocalSearchNaverClientException() {
    }

    public LocalSearchNaverClientException(String message) {
        super(message);
    }
}
