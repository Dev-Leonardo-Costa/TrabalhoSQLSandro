package com.trabalho.santrosql.repository;

import com.trabalho.santrosql.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoReposity extends JpaRepository<Aluno, Long> {
}
