package com.leandromendes25.agendador_de_tarefas.infrastructure.exceptions;

import javax.naming.AuthenticationException;

public class UnathorizedException extends AuthenticationException {
    public UnathorizedException(String message) {
        super(message);
    }
}
