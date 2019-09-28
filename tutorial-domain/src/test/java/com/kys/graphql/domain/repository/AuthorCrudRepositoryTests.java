package com.kys.graphql.domain.repository;

import com.kys.graphql.domain.Author;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AuthorCrudRepositoryTests {

    @Autowired
    private AuthorCrudRepository authorCrudRepository;

    @Test
    public void saveTest() throws Exception {

        // given
        Author author = Author.builder()
                              .firstName("KIM")
                              .lastName("YongSung")
                              .build();

        // when
        authorCrudRepository.save(author);

        // then
        Author newAuthor = authorCrudRepository.findById(author.getId())
                                               .orElseThrow(Exception::new);

        System.out.println(author.toString());
        System.out.println(newAuthor.toString());

        assertThat(newAuthor).isEqualTo(author);

    }
}
