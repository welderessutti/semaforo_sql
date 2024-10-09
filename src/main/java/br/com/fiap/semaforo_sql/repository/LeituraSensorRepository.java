package br.com.fiap.semaforo_sql.repository;

import br.com.fiap.semaforo_sql.model.LeituraSensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeituraSensorRepository extends JpaRepository<LeituraSensor, Long> {
}
