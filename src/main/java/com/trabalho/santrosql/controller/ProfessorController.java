package com.trabalho.santrosql.controller;

import com.trabalho.santrosql.dto.AlunoModelDTO;
import com.trabalho.santrosql.dto.DisciplinaModelDTO;
import com.trabalho.santrosql.dto.ProfessorModelDTO;
import com.trabalho.santrosql.model.Professor;
import com.trabalho.santrosql.service.AlunoService;
import com.trabalho.santrosql.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/professors")
public class ProfessorController {
    @Autowired
    private ProfessorService service;

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<ProfessorModelDTO> buscar() {
        return ProfessorModelDTO.toCollectionModelDTO(service.buscarTodos());
    }

    @GetMapping("/{professorId}")
    public ProfessorModelDTO buscarPorId(@PathVariable Long professorId) {
        Professor professor = service.buscarProfessorOuFalhar(professorId);
        return ProfessorModelDTO.toModelProfessorDTO(professor);
    }
}