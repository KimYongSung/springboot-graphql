package com.kys.graphql.domain.repository;

import com.kys.graphql.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCrudRepository extends JpaRepository<Book, Long> {
}
