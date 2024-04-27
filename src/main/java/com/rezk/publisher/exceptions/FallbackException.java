package com.rezk.publisher.exceptions;

public class FallbackException extends RuntimeException {

    public FallbackException(Throwable cause) {
        super("Estamos com indisponibilidade no mommento.", cause);
    }

}
