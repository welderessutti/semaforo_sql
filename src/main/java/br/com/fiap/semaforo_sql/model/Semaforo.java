package br.com.fiap.semaforo_sql.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "t_semaforo")
@Data
public class Semaforo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loc_instalacao")
    private String localInstalacao;

    @Column(name = "tp_verde")
    private Integer tempoVerde;

    @Column(name = "tp_amarelo")
    private Integer tempoAmarelo;

    @Column(name = "tp_vermelho")
    private Integer tempoVermelho;

}
