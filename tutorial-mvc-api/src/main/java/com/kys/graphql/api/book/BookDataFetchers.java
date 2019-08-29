package com.kys.graphql.api.book;

import com.kys.graphql.api.exception.BookNotFoundException;
import com.kys.graphql.domain.Book;
import com.kys.graphql.domain.repository.BookCrudRepository;
import graphql.schema.DataFetcher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookDataFetchers {

    private BookCrudRepository crudRepository;

    /**
     * BookId로 Book 정보 조회
     * @return
     */
    public DataFetcher<Book> getBookByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            return crudRepository.findById(dataFetchingEnvironment.getArgument("id"))
                                 .orElseThrow(BookNotFoundException::new);
        };
    }
}
