CREATE TABLE pedidos
(
    id                BIGINT AUTO_INCREMENT PRIMARY KEY,
    cliente_id        BIGINT,
    preco_total       DECIMAL(10, 2) NOT NULL,
    data_hora_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status            ENUM('RECEBIDO', 'AGUARDANDO_PAGAMENTO', 'PAGAMENTO_CONFIRMADO', 'EM_PREPARACAO', 'PRONTO', 'FINALIZADO') NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES clientes (id) ON DELETE RESTRICT
);

CREATE TABLE pedidos_produtos
(
    id                BIGINT AUTO_INCREMENT PRIMARY KEY,
    pedido_id         BIGINT         NOT NULL,
    produto_id        BIGINT         NOT NULL,
    preco_produto     DECIMAL(10, 2) NOT NULL,
    quantidade        INT            NOT NULL,
    preco_total       DECIMAL(10, 2) NOT NULL,
    data_hora_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (pedido_id) REFERENCES pedidos (id) ON DELETE RESTRICT,
    FOREIGN KEY (produto_id) REFERENCES produtos (id) ON DELETE RESTRICT,
    UNIQUE KEY `produtos_pedidos_unq` (`pedido_id`,`produto_id`)
);