package com.trabalho.santrosql.service;

import com.trabalho.santrosql.model.Aluno;
import com.trabalho.santrosql.repository.AlunoReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoReposity reposity;

    @Transactional
    public List<Aluno> buscarTodos(){
        return reposity.findAll();
    }
}
