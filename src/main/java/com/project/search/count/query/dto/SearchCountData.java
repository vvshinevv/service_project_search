package com.project.search.count.query.dto;

import com.project.search.count.command.util.CountConverter;
import com.project.search.count.command.vo.Count;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "search_count")
public class SearchCountData {
    @Id
    @Column(name = "search_count_id")
    private Long id;

    @Column(name = "keyword")
    private String keyword;

    @Convert(converter = CountConverter.class)
    @Column(name = "count")
    private Count count;

    protected SearchCountData() {
    }
}
