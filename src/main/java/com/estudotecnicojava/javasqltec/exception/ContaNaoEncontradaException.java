package com.estudotecnicojava.javasqltec.exception;

public class ContaNaoEncontradaException  extends RuntimeException {
    public ContaNaoEncontradaException (String numero) {
        super(numero);
    }
}
