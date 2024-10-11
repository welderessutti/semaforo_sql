package br.com.fiap.semaforo_sql.repository;

import br.com.fiap.semaforo_sql.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
