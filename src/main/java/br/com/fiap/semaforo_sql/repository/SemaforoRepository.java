package br.com.fiap.semaforo_sql.repository;

import br.com.fiap.semaforo_sql.model.Semaforo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemaforoRepository extends JpaRepository<Semaforo, Long> {
}
