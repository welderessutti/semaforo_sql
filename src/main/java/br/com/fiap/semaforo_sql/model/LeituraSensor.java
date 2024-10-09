package br.com.fiap.semaforo_sql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "t_leitura_sensor")
@Data
public class LeituraSensor {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sq_leitura_sensor"
    )
    @SequenceGenerator(
            name = "sq_leitura_sensor",
            sequenceName = "sq_leitura_sensor",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "dt_hr_leitura")
    private LocalDateTime dataHoraLeitura;

    @Column(name = "flx_veiculos")
    private Integer fluxoVeiculos;

    @Column(name = "vel_media")
    private Double velocidadeMedia;

    @Column(name = "tmp_fila")
    private Integer tempoFila;

    @Column(name = "cond_climatica")
    private String condicaoClimatica;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

}
