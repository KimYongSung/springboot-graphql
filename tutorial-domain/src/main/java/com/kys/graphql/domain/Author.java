package com.kys.graphql.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Table(name = "AUTHOR", uniqueConstraints = {@UniqueConstraint(name="AUTHOR_ID", columnNames = {"AUTHOR_ID"})})
@Getter
@Setter
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID" , nullable = false)
    private Long id;

    @Column(name = "FIRST_NAME" , nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME" , nullable = false)
    private String lastName;
}
