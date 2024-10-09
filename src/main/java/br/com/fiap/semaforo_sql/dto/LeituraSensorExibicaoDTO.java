package br.com.fiap.semaforo_sql.dto;

import br.com.fiap.semaforo_sql.model.LeituraSensor;

import java.time.LocalDateTime;

public record LeituraSensorExibicaoDTO(
        Long id,
        LocalDateTime dataHoraLeitura,
        Integer fluxoVeiculos,
        Double velocidadeMedia,
        Integer tempoFila,
        String condicaoClimatica,
        SensorExibicaoDTO sensor
) {
    public LeituraSensorExibicaoDTO(LeituraSensor leituraSensor) {
        this(
                leituraSensor.getId(),
                leituraSensor.getDataHoraLeitura(),
                leituraSensor.getFluxoVeiculos(),
                leituraSensor.getVelocidadeMedia(),
                leituraSensor.getTempoFila(),
                leituraSensor.getCondicaoClimatica(),
                new SensorExibicaoDTO(leituraSensor.getSensor())
        );
    }
}
