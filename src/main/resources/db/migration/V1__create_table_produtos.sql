CREATE TABLE produtos
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo_produto ENUM('LANCHES', 'ACOMPANHAMENTOS', 'BEBIDAS', 'SOBREMESAS') NOT NULL,
    nome         VARCHAR(255)   NOT NULL,
    descricao    TEXT,
    preco        DECIMAL(10, 2) NOT NULL,
    data_hora_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);