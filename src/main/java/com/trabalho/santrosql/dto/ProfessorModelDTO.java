package com.trabalho.santrosql.dto;

import com.trabalho.santrosql.model.Aluno;
import com.trabalho.santrosql.model.Professor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ProfessorModelDTO {

    private String professor;
    private DisciplinaModelDTO disciplina;
    private List<AlunoModelDTO> alunos;

    public static ProfessorModelDTO toModelProfessorDTO(Professor professor) {
        DisciplinaModelDTO disciplinaModelDTO = new DisciplinaModelDTO();
        disciplinaModelDTO.setCodigo(professor.getDisciplina().getCodigo());
        disciplinaModelDTO.setDisciplina(professor.getDisciplina().getNome());

        List<AlunoModelDTO> alunos = AlunoModelDTO.toCollectionAlunoModelDTO(professor.getAlunos());

        ProfessorModelDTO professorModelDTO = new ProfessorModelDTO();
        professorModelDTO.setProfessor(professor.getNome());

        professorModelDTO.setDisciplina(disciplinaModelDTO);
        professorModelDTO.setAlunos(alunos);
        return professorModelDTO;
    }

    public static List<ProfessorModelDTO> toCollectionModelDTO(List<Professor> professors) {
        return professors.stream()
                .map(professor -> toModelProfessorDTO(professor))
                .collect(Collectors.toList());
    }

}