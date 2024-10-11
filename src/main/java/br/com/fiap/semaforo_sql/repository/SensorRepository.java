package br.com.fiap.semaforo_sql.repository;

import br.com.fiap.semaforo_sql.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

    Boolean existsBySemaforo_Id(Long semaforoId);

}
