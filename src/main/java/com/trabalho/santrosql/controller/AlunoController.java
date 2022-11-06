package com.trabalho.santrosql.controller;

import com.trabalho.santrosql.dto.AlunoModelDTO;
import com.trabalho.santrosql.model.Aluno;
import com.trabalho.santrosql.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping
    public List<AlunoModelDTO> buscar(){
        return toCollectionAlunoModelDTO(service.buscarTodos());
    }

    public List<AlunoModelDTO> toCollectionAlunoModelDTO(List<Aluno> alunos){
        return alunos.stream()
                .map(aluno -> toModelAlunoDTO(aluno))
                .collect(Collectors.toList());
    }

    private AlunoModelDTO toModelAlunoDTO(Aluno aluno){
        AlunoModelDTO alunoModelDTO = new AlunoModelDTO();
        alunoModelDTO.setId(aluno.getId());
        alunoModelDTO.setNome(aluno.getNome());
        return alunoModelDTO;
    }
}
