package com.project.search.count.application;

import com.project.search.count.command.application.SearchCountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest
public class SearchCountServiceTest {
    @Autowired
    private SearchCountService searchCountService;

    @Test
    void test() {
        searchCountService.updateSearchCount("카카오");
    }
}
