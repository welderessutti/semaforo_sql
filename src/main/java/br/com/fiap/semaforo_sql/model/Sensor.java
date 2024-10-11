package br.com.fiap.semaforo_sql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "t_sensor")
@Data
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loc_instalacao")
    private String localInstalacao;

    @Column(name = "tp_sensor")
    private String tipoSensor;

    @Column(name = "dd_tecnicos")
    private String dadosTecnicos;

    @Column(name = "dt_instalacao")
    private LocalDate dataInstalacao;

    @Column(name = "st_operacao")
    private Boolean statusOperacao;

    @ManyToOne
    @JoinColumn(name = "semaforo_id")
    private Semaforo semaforo;

}
