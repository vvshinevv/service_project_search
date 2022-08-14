package com.project.search.common.util;

import java.util.Collection;
import java.util.stream.Stream;

public class Streams {
    public static <T> Stream<T> ofNullable(Collection<T> collection) {
        return collection == null ? Stream.empty() : collection.stream();
    }

    @SafeVarargs
    public static <T> Stream<T> ofNullable(T... values) {
        return values == null ? Stream.empty() : Stream.of(values);
    }
}
