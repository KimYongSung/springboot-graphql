package com.kys.graphql.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "GOODS", uniqueConstraints = {@UniqueConstraint(name="GOODS_ID", columnNames = {"GOODS_ID"})})
@Getter
@Setter
@NoArgsConstructor
public class Goods {

    @Id
    @Column(name = "GOODS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "GOODS_NAME")
    private String name;

}
