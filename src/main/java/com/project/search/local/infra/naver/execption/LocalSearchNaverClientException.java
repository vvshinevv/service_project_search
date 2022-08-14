package com.project.search.local.infra.naver.execption;

public class LocalSearchNaverClientException extends RuntimeException {
    public LocalSearchNaverClientException() {
    }

    public LocalSearchNaverClientException(String message) {
        super(message);
    }
}
