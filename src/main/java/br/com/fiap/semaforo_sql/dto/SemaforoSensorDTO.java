package br.com.fiap.semaforo_sql.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SemaforoSensorDTO(

        @NotNull(message = "O ID do semáforo é obrigatório!")
        Long id

) {
}
