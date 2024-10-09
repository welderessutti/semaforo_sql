CREATE SEQUENCE sq_leitura_sensor
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1;

CREATE TABLE t_leitura_sensor
(
    id             INTEGER DEFAULT nextval('sq_leitura_sensor') PRIMARY KEY,
    dt_hr_leitura  TIMESTAMP        NOT NULL,
    flx_veiculos   INTEGER          NOT NULL,
    vel_media      DOUBLE PRECISION NOT NULL,
    tmp_fila       INTEGER          NOT NULL,
    cond_climatica VARCHAR(100)     NOT NULL,
    sensor_id      INTEGER          NOT NULL,
    CONSTRAINT fk_sensor FOREIGN KEY (sensor_id) REFERENCES t_sensor (id)
);