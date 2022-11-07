package com.trabalho.santrosql.controller;

import com.trabalho.santrosql.dto.AlunoModelDTO;
import com.trabalho.santrosql.dto.ProfessorModelDTO;
import com.trabalho.santrosql.exception.AlunoNaoEncontradoException;
import com.trabalho.santrosql.exception.NegocioException;
import com.trabalho.santrosql.exception.ProfessorNaoEncontrado;
import com.trabalho.santrosql.model.Aluno;
import com.trabalho.santrosql.model.Professor;
import com.trabalho.santrosql.service.AlunoService;
import com.trabalho.santrosql.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<AlunoModelDTO> buscar() {
        return AlunoModelDTO.toCollectionAlunoModelDTO(service.buscarTodos());
    }

    @GetMapping("/{alunoId}")
    public AlunoModelDTO buscarPorId(@PathVariable Long alunoId) {
        return AlunoModelDTO.toModelAlunoDTO(service.buscarAlunoOuFalhar(alunoId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoModelDTO adicionar(@RequestBody Aluno aluno) {
        try {
            Long profId = aluno.getProfessor().getId();
            Professor professor = professorService.buscarProfessorOuFalhar(profId);
            aluno.setProfessor(professor);
            aluno = service.salvar(aluno);
            return AlunoModelDTO.toModelADDDto(aluno);
        } catch (AlunoNaoEncontradoException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }


}