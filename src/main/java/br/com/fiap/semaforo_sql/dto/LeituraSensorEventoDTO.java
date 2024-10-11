package br.com.fiap.semaforo_sql.dto;

import jakarta.validation.constraints.NotNull;

public record LeituraSensorEventoDTO(

        @NotNull(message = "O ID da leitura do sensor é obrigatória!")
        Long id

) {
}
