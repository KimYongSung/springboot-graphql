package com.kys.graphql.api.book;

import com.kys.graphql.domain.Book;
import com.kys.graphql.domain.repository.BookCrudRepository;
import graphql.schema.DataFetcher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookDataFetchers {

    private BookCrudRepository crudRepository;

    public DataFetcher<Book> getBookByIdDataFetcher() {

        return dataFetchingEnvironment -> {
            Long bookId = dataFetchingEnvironment.getArgument("id");
            /*return books.stream()
                    .filter(book -> book.get("id").equals(bookId))
                    .findFirst()
                    .orElse(null);*/
            return null;
        };
    }
}
