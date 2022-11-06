package com.trabalho.santrosql.controller;

import com.trabalho.santrosql.dto.AlunoModelDTO;
import com.trabalho.santrosql.dto.DisciplinaModelDTO;
import com.trabalho.santrosql.dto.ProfessorModelDTO;
import com.trabalho.santrosql.model.Aluno;
import com.trabalho.santrosql.model.Professor;
import com.trabalho.santrosql.service.AlunoService;
import com.trabalho.santrosql.service.DisciplinaService;
import com.trabalho.santrosql.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/professors")
public class ProfessorContreller {

    @Autowired
    private ProfessorService service;

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<ProfessorModelDTO> buscar(){
        return toCollectionModelDTO(service.buscarTodos());
    }

    @GetMapping("/{professorId}")
    public ProfessorModelDTO buscarPorId(@PathVariable Long professorId){
        Professor professor = service.buscarProfessorOuFalhar(professorId);
        return toModelProfessorDTO(professor);
    }

    private static ProfessorModelDTO toModelProfessorDTO(Professor professor) {
        DisciplinaModelDTO disciplinaModelDTO = new DisciplinaModelDTO();
        disciplinaModelDTO.setCodigo(professor.getDisciplina().getCodigo());
        disciplinaModelDTO.setDisciplina(professor.getDisciplina().getNome());

        ProfessorModelDTO professorModelDTO = new ProfessorModelDTO();
        professorModelDTO.setProfessor(professor.getNome());

        professorModelDTO.setDisciplina(disciplinaModelDTO);

        List<AlunoModelDTO> alunos = new ArrayList<>();
        professorModelDTO.setAlunos(alunos);

        return professorModelDTO;
    }

    private List<ProfessorModelDTO> toCollectionModelDTO(List<Professor> professors){
        return professors.stream()
                .map(professor -> toModelProfessorDTO(professor))
                .collect(Collectors.toList());
    }

}