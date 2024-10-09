package br.com.fiap.semaforo_sql.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EventoNaoEncontradoException extends RuntimeException {

    public EventoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
