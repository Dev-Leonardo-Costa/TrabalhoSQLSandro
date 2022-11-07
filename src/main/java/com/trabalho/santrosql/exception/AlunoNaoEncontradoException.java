package com.trabalho.santrosql.exception;

public class AlunoNaoEncontradoException extends NegocioException{

    public AlunoNaoEncontradoException(String message) {
        super(message);
    }

    public AlunoNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }
}
