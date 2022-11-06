package com.trabalho.santrosql.dto;

import com.trabalho.santrosql.model.Aluno;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProfessorModelDTO {

    private String professor;
    private DisciplinaModelDTO disciplina;
    private AlunoModelDTO alunos;

}
