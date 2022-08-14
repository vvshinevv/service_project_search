package com.project.search.local.infra.kakao.exception;

import com.project.search.local.application.exception.LocalSearchClientException;

public class LocalSearchKakaoClientException extends LocalSearchClientException {
    public LocalSearchKakaoClientException() {
    }

    public LocalSearchKakaoClientException(String message) {
        super(message);
    }
}
