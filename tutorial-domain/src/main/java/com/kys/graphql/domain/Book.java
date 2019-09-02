package com.kys.graphql.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "BOOK", uniqueConstraints = {@UniqueConstraint(name="BOOK_ID", columnNames = {"BOOK_ID"})})
public class Book {

    @Id
    @Column(name = "BOOK_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PAGE_COUNT")
    private Integer pageCount;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;

}
