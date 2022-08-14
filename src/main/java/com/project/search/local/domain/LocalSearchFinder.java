package com.project.search.local.domain;

public interface LocalSearchFinder {
    LocalSearchContainer findLocalSearchByKeyword(String keyword, int page, int size);
    int defaultPage();
    int defaultSize();
}
