package br.com.fiap.semaforo_sql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "t_evento")
@Data
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dt_hr_evento")
    private LocalDateTime dataHoraEvento;

    @Column(name = "tp_evento")
    private String tipoEvento;

    @Column(name = "loc_evento")
    private String localEvento;

    @Column(name = "impct_transito")
    private String impactoTransito;

    @Column(name = "ac_tomada")
    private String acaoTomada;

    @ManyToOne
    @JoinColumn(name = "ltr_sensor_id")
    private LeituraSensor leituraSensor;

}
