package br.com.fiap.semaforo_sql.dto;

import br.com.fiap.semaforo_sql.model.Usuario;
import br.com.fiap.semaforo_sql.model.UsuarioRole;

public record UsuarioExibicaoDTO(
        Long id,
        String nome,
        String email,
        UsuarioRole role
) {
    public UsuarioExibicaoDTO(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRole()
        );
    }
}
