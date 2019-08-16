package com.kys.graphql.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "MEMBER", uniqueConstraints = {@UniqueConstraint(name="ID", columnNames = {"ID"})})
@Getter
@Setter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID" , nullable = false)
    private Long id;

    @Column(name = "AGE" , nullable = false)
    private Integer age;
}
