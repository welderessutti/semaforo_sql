CREATE SEQUENCE sq_semaforo
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1;

CREATE TABLE t_semaforo
(
    id             INTEGER DEFAULT nextval('sq_semaforo') PRIMARY KEY,
    loc_instalacao VARCHAR(100)   NOT NULL,
    tp_verde       INTEGER UNIQUE NOT NULL,
    tp_amarelo     INTEGER        NOT NULL,
    tp_vermelho    INTEGER        NOT NULL
);