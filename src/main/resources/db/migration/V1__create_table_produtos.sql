CREATE TABLE produtos
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    categoria VARCHAR(50)    NOT NULL,
    nome      VARCHAR(255)   NOT NULL,
    descricao  TEXT,
    preco     DECIMAL(10, 2) NOT NULL
);