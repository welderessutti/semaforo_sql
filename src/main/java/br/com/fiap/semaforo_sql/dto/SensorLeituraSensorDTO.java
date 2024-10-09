package br.com.fiap.semaforo_sql.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SensorLeituraSensorDTO(

        @NotNull(message = "O ID do sensor é obrigatório!")
        Long id

) {
}
