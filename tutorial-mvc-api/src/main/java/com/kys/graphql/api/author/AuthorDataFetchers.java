package com.kys.graphql.api.author;

import com.kys.graphql.domain.repository.AuthorCrudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorDataFetchers {

    private AuthorCrudRepository crudRepository;

    public void test(){
        crudRepository = new AuthorCrudRepository() {
            @Override
            public String toString() {
                return super.toString();
            }
        };
    }
}
