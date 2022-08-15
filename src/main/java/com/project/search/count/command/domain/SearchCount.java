package com.project.search.count.command.domain;

import com.project.search.count.command.util.CountConverter;
import com.project.search.count.command.vo.Count;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "search_count")
public class SearchCount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "search_count_id")
    private Long id;

    @Column(name = "keyword")
    private String keyword;

    @Convert(converter = CountConverter.class)
    @Column(name = "count")
    private Count count;

    protected SearchCount() {
    }

    public SearchCount(String keyword, Count count) {
        this.keyword = keyword;
        this.count = count;
    }

    public void plusCount(int plusCount) {
        this.count = count.plus(plusCount);
    }
}
