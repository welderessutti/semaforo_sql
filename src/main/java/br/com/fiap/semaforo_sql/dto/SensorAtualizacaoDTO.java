package br.com.fiap.semaforo_sql.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record SensorAtualizacaoDTO(

        @NotNull(message = "O ID é obrigatório!")
        Long id,

        @NotBlank(message = "O endereço de localização é obrigatório!")
        String localInstalacao,

        @NotBlank(message = "O tipo de sensor é obrigatório!")
        String tipoSensor,

        @NotBlank(message = "Os dados técnicos são obrigatórios!")
        String dadosTecnicos,

        @NotNull(message = "A data de instalação é obrigatória!")
        LocalDate dataInstalacao,

        @NotNull(message = "O status da operação é obrigatória!")
        Boolean statusOperacao,

        @Valid()
        SemaforoSensorDTO semaforo

) {
}
