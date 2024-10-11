package br.com.fiap.semaforo_sql.controller;

import br.com.fiap.semaforo_sql.config.security.TokenService;
import br.com.fiap.semaforo_sql.dto.TokenDTO;
import br.com.fiap.semaforo_sql.dto.UsuarioCadastroDTO;
import br.com.fiap.semaforo_sql.dto.UsuarioExibicaoDTO;
import br.com.fiap.semaforo_sql.dto.UsuarioLoginDTO;
import br.com.fiap.semaforo_sql.model.Usuario;
import br.com.fiap.semaforo_sql.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody @Valid UsuarioLoginDTO usuarioLoginDTO) {
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(
                usuarioLoginDTO.email(),
                usuarioLoginDTO.senha()
        );

        Authentication authentication = authenticationManager.authenticate(usernamePassword);
        String token = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(token));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDTO registrar(@RequestBody @Valid UsuarioCadastroDTO usuarioCadastroDTO) {
        return usuarioService.salvar(usuarioCadastroDTO);
    }
}
