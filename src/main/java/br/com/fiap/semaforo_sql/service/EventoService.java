package br.com.fiap.semaforo_sql.service;

import br.com.fiap.semaforo_sql.dto.EventoAtualizacaoDTO;
import br.com.fiap.semaforo_sql.dto.EventoCadastroDTO;
import br.com.fiap.semaforo_sql.dto.EventoExibicaoDTO;
import br.com.fiap.semaforo_sql.exception.EventoNaoEncontradoException;
import br.com.fiap.semaforo_sql.exception.LeituraSensorNaoEncontradaException;
import br.com.fiap.semaforo_sql.model.Evento;
import br.com.fiap.semaforo_sql.model.LeituraSensor;
import br.com.fiap.semaforo_sql.repository.EventoRepository;
import br.com.fiap.semaforo_sql.repository.LeituraSensorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private LeituraSensorRepository leituraSensorRepository;


    @Transactional
    public EventoExibicaoDTO salvar(EventoCadastroDTO eventoCadastroDTO) {
        Optional<LeituraSensor> leituraSensorOptinal =
                leituraSensorRepository.findById(eventoCadastroDTO.leituraSensor().id());

        if (leituraSensorOptinal.isPresent()) {
            Evento evento = new Evento();
            BeanUtils.copyProperties(eventoCadastroDTO, evento);
            evento.setLeituraSensor(leituraSensorOptinal.get());
            return new EventoExibicaoDTO(eventoRepository.save(evento));
        } else {
            throw new LeituraSensorNaoEncontradaException(
                    "Leitura do sensor não encontrada para cadastrar o evento!"
            );
        }
    }

    public Page<EventoExibicaoDTO> listarTodos(Pageable paginacao) {
        return eventoRepository
                .findAll(paginacao)
                .map(EventoExibicaoDTO::new);
    }

    public EventoExibicaoDTO buscarPorId(Long id) {
        Optional<Evento> eventoOptional = eventoRepository.findById(id);

        if (eventoOptional.isPresent()) {
            return new EventoExibicaoDTO(eventoOptional.get());
        } else {
            throw new EventoNaoEncontradoException("Evento não encontrado!");
        }
    }

    @Transactional
    public void excluir(Long id) {
        Optional<Evento> eventoOptional = eventoRepository.findById(id);

        if (eventoOptional.isPresent()) {
            eventoRepository.delete(eventoOptional.get());
        } else {
            throw new EventoNaoEncontradoException("Evento não encontrado!");
        }
    }

    @Transactional
    public EventoExibicaoDTO atualizar(EventoAtualizacaoDTO eventoAtualizacaoDTO) {
        Optional<Evento> eventoOptional = eventoRepository.findById(eventoAtualizacaoDTO.id());

        if (eventoOptional.isPresent()) {
            Optional<LeituraSensor> leituraSensorOptional =
                    leituraSensorRepository.findById(eventoAtualizacaoDTO.leituraSensor().id());

            if (leituraSensorOptional.isPresent()) {
                BeanUtils.copyProperties(eventoAtualizacaoDTO, eventoOptional.get());
                eventoOptional.get().setLeituraSensor(leituraSensorOptional.get());

                return new EventoExibicaoDTO(eventoRepository.save(eventoOptional.get()));
            } else {
                throw new LeituraSensorNaoEncontradaException("Leitura do sensor não encontrada!");
            }
        } else {
            throw new EventoNaoEncontradoException("Evento não encontrado!");
        }
    }
}
