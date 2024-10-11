package br.com.fiap.semaforo_sql.service;

import br.com.fiap.semaforo_sql.dto.UsuarioCadastroDTO;
import br.com.fiap.semaforo_sql.dto.UsuarioExibicaoDTO;
import br.com.fiap.semaforo_sql.model.Usuario;
import br.com.fiap.semaforo_sql.model.UsuarioRole;
import br.com.fiap.semaforo_sql.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSalvar() {
        // Arrange
        UsuarioCadastroDTO usuarioCadastroDTO = new UsuarioCadastroDTO(
                "Teste",
                "email@teste.com",
                "1234",
                UsuarioRole.USER
        );
        Usuario usuarioSalvo = new Usuario();
        usuarioSalvo.setId(1L);
        usuarioSalvo.setNome(usuarioCadastroDTO.nome());
        usuarioSalvo.setEmail(usuarioCadastroDTO.email());
        usuarioSalvo.setRole(usuarioCadastroDTO.role());

        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuarioSalvo);

        // Act
        UsuarioExibicaoDTO resultado = usuarioService.salvar(usuarioCadastroDTO);

        // Assert
        assertEquals(usuarioSalvo.getId(), resultado.id());
        assertEquals(usuarioSalvo.getNome(), resultado.nome());
        assertEquals(usuarioSalvo.getEmail(), resultado.email());
        assertEquals(usuarioSalvo.getRole(), resultado.role());
    }
}
