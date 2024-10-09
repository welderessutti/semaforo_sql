package br.com.fiap.semaforo_sql.controller;

import br.com.fiap.semaforo_sql.dto.LeituraSensorAtualizacaoDTO;
import br.com.fiap.semaforo_sql.dto.LeituraSensorCadastroDTO;
import br.com.fiap.semaforo_sql.dto.LeituraSensorExibicaoDTO;
import br.com.fiap.semaforo_sql.service.LeituraSensorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leitura-sensor")
public class LeituraSensorController {

    @Autowired
    private LeituraSensorService leituraSensorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LeituraSensorExibicaoDTO salvar(@RequestBody @Valid LeituraSensorCadastroDTO leituraSensorCadastroDTO) {
        return leituraSensorService.salvar(leituraSensorCadastroDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<LeituraSensorExibicaoDTO> listarTodos(@PageableDefault(size = 2) Pageable paginacao) {
        return leituraSensorService.listarTodos(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeituraSensorExibicaoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(leituraSensorService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        leituraSensorService.excluir(id);
    }

    @PutMapping
    public ResponseEntity<LeituraSensorExibicaoDTO> atualizar(@RequestBody @Valid LeituraSensorAtualizacaoDTO leituraSensorAtualizacaoDTO) {
        return ResponseEntity.ok(leituraSensorService.atualizar(leituraSensorAtualizacaoDTO));
    }
}
