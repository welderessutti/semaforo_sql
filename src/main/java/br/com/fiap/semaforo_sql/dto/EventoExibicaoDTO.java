package br.com.fiap.semaforo_sql.dto;

import br.com.fiap.semaforo_sql.model.Evento;

import java.time.LocalDateTime;

public record EventoExibicaoDTO(
        Long id,
        LocalDateTime dataHoraEvento,
        String tipoEvento,
        String localEvento,
        String impactoTransito,
        String acaoTomada,
        LeituraSensorExibicaoDTO leituraSensor
) {
    public EventoExibicaoDTO(Evento evento) {
        this(
                evento.getId(),
                evento.getDataHoraEvento(),
                evento.getTipoEvento(),
                evento.getLocalEvento(),
                evento.getImpactoTransito(),
                evento.getAcaoTomada(),
                new LeituraSensorExibicaoDTO(evento.getLeituraSensor())
        );
    }
}
