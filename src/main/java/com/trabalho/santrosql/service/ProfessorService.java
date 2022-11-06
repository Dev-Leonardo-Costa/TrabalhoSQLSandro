package com.trabalho.santrosql.service;

import com.trabalho.santrosql.exception.ProfessorNaoEncontrado;
import com.trabalho.santrosql.model.Professor;
import com.trabalho.santrosql.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    public static final String MSG_PROFESSOR_NAO_ENCONTRADA
            = "Não existe cadastro de PROFESSOR com esse código %d ";
    @Autowired
    private ProfessorRepository repository;

    @Transactional
    public List<Professor> buscarTodos(){
        return  repository.findAll();
    }

    @Transactional
    public Optional<Professor> buscarPorid(Long professorId){
        return repository.findById(professorId);
    }

    public Professor buscarProfessorOuFalhar(Long professorId){
        return  repository.findById(professorId)
                .orElseThrow(() -> new ProfessorNaoEncontrado(
                        String.format(MSG_PROFESSOR_NAO_ENCONTRADA, professorId)));
    }
}
