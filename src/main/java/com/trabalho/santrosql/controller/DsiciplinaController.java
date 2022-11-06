package com.trabalho.santrosql.controller;

import com.trabalho.santrosql.model.Disciplina;
import com.trabalho.santrosql.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DsiciplinaController {

    @Autowired
    private DisciplinaService service;

    @GetMapping
    public List<Disciplina> buscar(){
        return service.buscarTodas();
    }
}
