package com.kys.graphql.graphql;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphQLDataFetchers {

    private static List<Map<String, String>> books = Arrays.asList(
            ImmutableMap.of("id", "book-1", "name", "kys1", "pageCount","223", "authorId", "author-1"),
            ImmutableMap.of("id", "book-2", "name", "kys2", "pageCount","635", "authorId", "author-2"),
            ImmutableMap.of("id", "book-3", "name", "kys3", "pageCount","371", "authorId", "author-3")
    );
}
