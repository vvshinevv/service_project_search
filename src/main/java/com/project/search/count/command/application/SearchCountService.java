package com.project.search.count.command.application;

import com.project.search.count.command.domain.SearchCount;
import com.project.search.count.command.domain.SearchCountRepository;
import com.project.search.count.command.vo.Count;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SearchCountService {
    private final SearchCountRepository searchCountRepository;

    public SearchCountService(SearchCountRepository searchCountRepository) {
        this.searchCountRepository = searchCountRepository;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void updateSearchCount(String keyword) {
        SearchCount searchCount = searchCountRepository.findSearchCountForUpdate(keyword).orElse(new SearchCount(keyword, new Count(0)));
        searchCount.plusCount(1);

        searchCountRepository.save(searchCount);
    }
}
