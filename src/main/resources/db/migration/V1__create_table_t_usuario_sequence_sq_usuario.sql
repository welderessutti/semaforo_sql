CREATE TABLE t_usuario
(
    id    INTEGER             NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome  VARCHAR(100)        NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(100)        NOT NULL,
    role  VARCHAR(20)         NOT NULL DEFAULT 'USER'
);