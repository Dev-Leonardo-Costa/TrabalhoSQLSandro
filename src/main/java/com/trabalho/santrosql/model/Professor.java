package com.trabalho.santrosql.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "disciplina_codigo", nullable = false)
    private Disciplina disciplina;

    @OneToMany(mappedBy = "professor")
    private List<Aluno> alunos = new ArrayList<>();

}