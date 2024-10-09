CREATE SEQUENCE sq_usuario
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1;

CREATE TABLE t_usuario
(
    id    INTEGER     DEFAULT nextval('sq_usuario') PRIMARY KEY,
    nome  VARCHAR(100)               NOT NULL,
    email VARCHAR(100) UNIQUE        NOT NULL,
    senha VARCHAR(100)                NOT NULL,
    role  VARCHAR(20) DEFAULT 'USER' NOT NULL
);