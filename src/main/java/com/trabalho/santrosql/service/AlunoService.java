package com.trabalho.santrosql.service;

import com.trabalho.santrosql.exception.ProfessorNaoEncontrado;
import com.trabalho.santrosql.model.Aluno;
import com.trabalho.santrosql.model.Professor;
import com.trabalho.santrosql.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    public static final String MSG_ALUNO_NAO_ENCONTRADA
            = "Não existe cadastro de PROFESSOR com esse código %d ";
    @Autowired
    private AlunoRepository repository;

    @Autowired
    private ProfessorService professorService;

    @Transactional
    public List<Aluno> buscarTodos(){
        return repository.findAll();
    }

    @Transactional
    public Aluno salvar(Aluno aluno){
        Long professorId = aluno.getProfessor().getId();
        Professor professor = professorService.buscarProfessorOuFalhar(professorId);
        aluno.setProfessor(professor);
        return  repository.save(aluno);
    }

    @Transactional
    public Optional<Aluno> buscarPorId(Long alunoId) {
        return repository.findById(alunoId);
    }
    public Aluno buscarAlunoOuFalhar(Long alunoId){
        return repository.findById(alunoId)
                .orElseThrow(() -> new ProfessorNaoEncontrado(
                        String.format(MSG_ALUNO_NAO_ENCONTRADA, alunoId)));
    }
}
