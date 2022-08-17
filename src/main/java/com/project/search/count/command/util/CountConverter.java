package com.project.search.count.command.util;

import com.project.search.count.command.vo.Count;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class CountConverter implements AttributeConverter<Count, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Count count) {
        return count == null ? null : count.getCount();
    }

    @Override
    public Count convertToEntityAttribute(Integer value) {
        return value == null ? null : new Count(value);
    }
}
