package br.com.fiap.postech.techchallenge.application.domain;

public enum StatusPedido {
    RECEBIDO,
    AGUARDANDO_PAGAMENTO,
    PAGAMENTO_CONFIRMADO,
    EM_PREPARACAO,
    PRONTO,
    FINALIZADO;
}
