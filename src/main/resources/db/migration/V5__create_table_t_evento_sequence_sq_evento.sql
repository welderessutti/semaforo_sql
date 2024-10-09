CREATE SEQUENCE sq_evento
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1;

CREATE TABLE t_evento
(
    id             INTEGER DEFAULT nextval('sq_evento') PRIMARY KEY,
    dt_hr_evento   TIMESTAMP    NOT NULL,
    tp_evento      VARCHAR(100) NOT NULL,
    loc_evento     VARCHAR(100) NOT NULL,
    impct_transito VARCHAR(100) NOT NULL,
    ac_tomada      VARCHAR(100) NOT NULL,
    ltr_sensor_id  INTEGER      NOT NULL,
    CONSTRAINT fk_ltr_sensor FOREIGN KEY (ltr_sensor_id) REFERENCES t_leitura_sensor (id)
);