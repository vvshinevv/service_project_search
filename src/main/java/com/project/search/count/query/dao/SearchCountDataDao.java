package com.project.search.count.query.dao;

import com.project.search.count.command.domain.SearchCount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchCountDataDao extends JpaRepository<SearchCount, Long> {
    List<SearchCount> findTop10ByOrderByCountDesc();
}
