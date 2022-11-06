package com.trabalho.santrosql.dto;

import com.trabalho.santrosql.model.Aluno;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class AlunoModelDTO {

    private Long id;
    private String nome;

    public static List<AlunoModelDTO> toCollectionAlunoModelDTO(List<Aluno> alunos){
        return alunos.stream()
                .map(aluno -> toModelAlunoDTO(aluno))
                .collect(Collectors.toList());
    }

    public static AlunoModelDTO toModelAlunoDTO(Aluno aluno){
        AlunoModelDTO alunoModelDTO = new AlunoModelDTO();
        alunoModelDTO.setId(aluno.getId());
        alunoModelDTO.setNome(aluno.getNome());
        return alunoModelDTO;
    }

}