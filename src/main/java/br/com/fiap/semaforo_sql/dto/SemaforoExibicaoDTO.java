package br.com.fiap.semaforo_sql.dto;

import br.com.fiap.semaforo_sql.model.Semaforo;

public record SemaforoExibicaoDTO(
        Long id,
        String localInstalacao,
        Integer tempoVerde,
        Integer tempoAmarelo,
        Integer tempoVermelho
) {
    public SemaforoExibicaoDTO(Semaforo semaforo) {
        this(
                semaforo.getId(),
                semaforo.getLocalInstalacao(),
                semaforo.getTempoVerde(),
                semaforo.getTempoAmarelo(),
                semaforo.getTempoVermelho()
        );
    }
}
