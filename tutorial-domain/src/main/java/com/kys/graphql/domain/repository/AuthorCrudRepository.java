package com.kys.graphql.domain.repository;

import com.kys.graphql.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorCrudRepository extends JpaRepository<Author, Long> {
}
