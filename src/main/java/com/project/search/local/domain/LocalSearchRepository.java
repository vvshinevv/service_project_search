package com.project.search.local.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocalSearchRepository extends JpaRepository<LocalSearch, Long> {
    List<LocalSearch> findLocalSearchByKeyword(String keyword);
}
