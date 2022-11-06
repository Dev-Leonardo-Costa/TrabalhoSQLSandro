package com.trabalho.santrosql.exception;

public class ProfessorNaoEncontrado extends RuntimeException{

    public ProfessorNaoEncontrado(String message) {
        super(message);
    }

    public ProfessorNaoEncontrado(String message, Throwable cause) {
        super(message, cause);
    }
}
