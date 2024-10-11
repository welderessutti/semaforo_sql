CREATE TABLE t_semaforo
(
    id             INTEGER        NOT NULL AUTO_INCREMENT PRIMARY KEY,
    loc_instalacao VARCHAR(100)   NOT NULL,
    tp_verde       INTEGER UNIQUE NOT NULL,
    tp_amarelo     INTEGER        NOT NULL,
    tp_vermelho    INTEGER        NOT NULL
);