CREATE TABLE t_sensor
(
    id             INTEGER      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    loc_instalacao VARCHAR(100) NOT NULL,
    tp_sensor      VARCHAR(100) NOT NULL,
    dd_tecnicos    VARCHAR(100) NOT NULL,
    dt_instalacao  DATE         NOT NULL,
    st_operacao    BOOLEAN      NOT NULL,
    semaforo_id    INTEGER      NOT NULL,
    CONSTRAINT fk_semaforo FOREIGN KEY (semaforo_id) REFERENCES t_semaforo (id)
);