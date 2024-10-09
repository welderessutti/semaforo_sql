package br.com.fiap.semaforo_sql.dto;

import br.com.fiap.semaforo_sql.model.Sensor;

import java.time.LocalDate;

public record SensorExibicaoDTO(
        Long id,
        String localInstalacao,
        String tipoSensor,
        String dadosTecnicos,
        LocalDate dataInstalacao,
        Boolean statusOperacao,
        SemaforoExibicaoDTO semaforo
) {
    public SensorExibicaoDTO(Sensor sensor) {
        this(
                sensor.getId(),
                sensor.getLocalInstalacao(),
                sensor.getTipoSensor(),
                sensor.getDadosTecnicos(),
                sensor.getDataInstalacao(),
                sensor.getStatusOperacao(),
                new SemaforoExibicaoDTO(sensor.getSemaforo())
        );
    }
}
