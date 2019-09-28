package com.kys.graphql.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "AUTHOR", uniqueConstraints = {@UniqueConstraint(name="AUTHOR_ID", columnNames = {"AUTHOR_ID"})})
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID" , nullable = false)
    private Long id;

    @Setter
    @Column(name = "FIRST_NAME" , nullable = false)
    private String firstName;

    @Setter
    @Column(name = "LAST_NAME" , nullable = false)
    private String lastName;

    @Builder
    private Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
