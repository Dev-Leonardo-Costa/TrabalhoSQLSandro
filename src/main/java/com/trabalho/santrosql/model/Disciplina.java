package com.trabalho.santrosql.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private Long codigo;

    @Column(nullable = false)
    private String nome;

}
