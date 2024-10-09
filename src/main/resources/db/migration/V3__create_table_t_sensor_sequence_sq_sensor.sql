CREATE SEQUENCE sq_sensor
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1;

CREATE TABLE t_sensor
(
    id             INTEGER DEFAULT nextval('sq_sensor') PRIMARY KEY,
    loc_instalacao VARCHAR(100) NOT NULL,
    tp_sensor      VARCHAR(100) NOT NULL,
    dd_tecnicos    VARCHAR(100) NOT NULL,
    dt_instalacao  DATE         NOT NULL,
    st_operacao    BOOLEAN      NOT NULL,
    semaforo_id    INTEGER      NOT NULL,
    CONSTRAINT fk_semaforo FOREIGN KEY (semaforo_id) REFERENCES t_semaforo (id)
);