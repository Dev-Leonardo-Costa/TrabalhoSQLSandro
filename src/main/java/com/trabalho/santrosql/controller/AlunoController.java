package com.trabalho.santrosql.controller;

import com.trabalho.santrosql.dto.AlunoModelDTO;
import com.trabalho.santrosql.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping
    public List<AlunoModelDTO> buscar() {
        return AlunoModelDTO.toCollectionAlunoModelDTO(service.buscarTodos());
    }

}