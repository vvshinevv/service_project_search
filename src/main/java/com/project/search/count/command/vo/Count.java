package com.project.search.count.command.vo;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Count {
    private final int count;

    public Count(int count) {
        this.count = count;
    }

    public Count plus(int plusCount) {
        return new Count(count + plusCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count count1 = (Count) o;
        return getCount() == count1.getCount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCount());
    }
}
