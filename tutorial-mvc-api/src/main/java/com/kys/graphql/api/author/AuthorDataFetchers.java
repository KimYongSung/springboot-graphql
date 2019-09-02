package com.kys.graphql.api.author;

import com.kys.graphql.api.exception.AuthorNotFoundException;
import com.kys.graphql.api.exception.BookNotFoundException;
import com.kys.graphql.domain.Author;
import com.kys.graphql.domain.repository.AuthorCrudRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorDataFetchers{

    private AuthorCrudRepository crudRepository;

    /**
     * BookId로 Book 정보 조회
     * @return
     */
    public DataFetcher<Author> getAuthorDataFetcher() {
        return dataFetchingEnvironment -> {
            return crudRepository.findById(dataFetchingEnvironment.getArgument("authorId"))
                                 .orElseThrow(AuthorNotFoundException::new);
        };
    }

}