package com.example.gestaoprodutosapi.exceptions;

public class ProdutoNaoEncontradoException extends RuntimeException {

    public ProdutoNaoEncontradoException() {
        super();
    }
    public ProdutoNaoEncontradoException(String message) {
        super(message);
    }

    public ProdutoNaoEncontradoException(Throwable t) {
        super(t);
    }
}
