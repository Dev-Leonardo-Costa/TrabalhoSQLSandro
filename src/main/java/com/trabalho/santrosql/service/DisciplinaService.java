package com.trabalho.santrosql.service;

import com.trabalho.santrosql.model.Disciplina;
import com.trabalho.santrosql.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository repository;

    public List<Disciplina> buscarTodas(){
        return repository.findAll();
    }
}
